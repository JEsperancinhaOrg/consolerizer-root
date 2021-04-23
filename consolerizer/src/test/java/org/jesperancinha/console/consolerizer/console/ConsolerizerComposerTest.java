package org.jesperancinha.console.consolerizer.console;

import org.jesperancinha.console.consolerizer.common.ConsolerizerVars;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RESET;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerEmoji.POTATO;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerEmoji.TOMATO;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerVars.create;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerVars.createListFromObjects;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerVars.createListFromStrings;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.quote;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title;

class ConsolerizerComposerTest {

    @BeforeAll
    public static void setUp() {
        final var file = new File("/tmp/out.txt");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testConsolerizerComposer_whenNoSplitter_thenNiceLog() {
        ConsolerizerComposer.out().none().white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog").toConsole();
        ConsolerizerComposer.out().none().white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog").toConsole();
    }

    @Test
    void testConsolerizerComposer_whenSplitter_thenNiceLog() {
        ConsolerizerComposer.out(" ").none().white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog").toConsole();
        ConsolerizerComposer.out(" ").none().white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog").toConsole();
    }

    @Test
    void testConsolerizerComposer_whenNoSplitterLn_thenNiceLog() {
        ConsolerizerComposer.out().white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog").toConsoleLn();
        ConsolerizerComposer.out().white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog").toConsoleLn();
    }

    @Test
    void testConsolerizerComposerWithVarags_whenNoSplitter_thenNiceLog() {
        ConsolerizerComposer.out().white("The%s", "One").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog").toConsole();
        ConsolerizerComposer.out().white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog with a %s", "bone").toConsole();
    }

    @Test
    void testConsolerizerComposer_whenSplitterLn_thenNiceLog() {
        ConsolerizerComposer.out(" ").none().white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").bgOrange("dog").build().toConsoleLn();
        ConsolerizerComposer.out(" ").none().brown("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").magenta("dog").toConsoleLn();
    }

    @Test
    void testConsolerizerComposer2_whenSplitterLn_thenNiceLog() {
        ConsolerizerComposer.out(" ").none().brightCyan("The").brightWhite("quick").brightMagenta("brown").white("fox").brightRed("jumps").yellow("over")
                .blue("the").green("lazy").bgOrange("dog").toConsoleLn();
        ConsolerizerComposer.out(" ").cyan("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").magenta("dog").toConsoleLn();
    }

    @Test
    void testConsolerizerComposer3_whenSplitterLn_thenNiceLog() {
        ConsolerizerComposer.out(" ").none().brightCyan("The").black("quick").lightGrey("brown").white("fox").brightRed("jumps").yellow("over")
                .blue("the").green("lazy").darkGrey("dog").toConsoleLn();
        ConsolerizerComposer.out(" ").brightBlue("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").brightGreen("dog").toConsoleLn();
    }

    @Test
    void testConsolerizerComposer4_whenTitlePhenomenon_thenNiceLog() {
        BLUE.printGenericTitleLn("This shouldn't influence the next log");
        RED.printGenericLn("This shouldn't influence the next log");
        BLUE.printGenericTitleLn("This shouldn't influence the next log");

        ConsolerizerGraphs.printUnicornsLn(100);
        System.out.print(RESET);
        System.out.print("---");
        System.out.print(MAGENTA);
        System.out.println("---");
        System.out.print(RESET);

        ConsolerizerComposer.out(" ").white("The").black("quick").lightGrey("brown").white("fox").brightRed("jumps").yellow("over")
                .blue("the").green("lazy").darkGrey("dog").toConsoleLn();
        ConsolerizerComposer.out(" ").brightBlue("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").brightGreen("dog").toConsoleLn();
    }

    @Test
    void testConsolerizerComposer_whenNewLineAndObject_thenNiceLog() {
        final var leafyGreen = new LeafyGreen("Cabbage");
        ConsolerizerComposer
                .out(" ")
                .green("Eating leafy greens is awesome.")
                .brightGreen("For example, we can eat")
                .newLine()
                .blue(leafyGreen)
                .newLine()
                .yellow("and feel great afterwards!")
                .toConsoleLn();
    }

    @Test
    void testConsolerizerComposerSpace_whenNewLineAndObject_thenNiceLog() {
        final var leafyGreen = new LeafyGreen("Cabbage");
        ConsolerizerComposer
                .outSpace()
                .green("Eating leafy greens is awesome.")
                .brightGreen("For example, we can eat")
                .newLine()
                .blue(leafyGreen)
                .newLine()
                .yellow("and feel great afterwards!")
                .toConsoleLn();
    }

    @Test
    void testConsolerizerComposerSpaceTitle_whenNewLineAndObject_thenNiceLog() {
        final LeafyGreen leafyGreen = new LeafyGreen("Cabbage");
        ConsolerizerComposer
                .outSpace()
                .green(title("Eating leafy greens is awesome."))
                .newLine()
                .brightGreen("For example, we can eat")
                .newLine()
                .blue(leafyGreen)
                .newLine()
                .yellow("and feel great afterwards!")
                .toConsoleLn();
    }

    @Test
    void testConsolerizerComposerSpaceTitleLn_whenNewLineAndObject_thenNiceLog() {
        final LeafyGreen leafyGreen = new LeafyGreen("Cabbage");
        ConsolerizerComposer
                .outSpace()
                .ln()
                .green(title("Eating leafy greens is awesome."))
                .brightGreen("For example, we can eat")
                .blue(leafyGreen)
                .yellow("and feel great afterwards!")
                .black()
                .bgYellow("It's good!")
                .red()
                .bgYellow("It's good!")
                .green()
                .bgYellow("It's good!")
                .none()
                .green(title("Eating leafy greens is awesome."))
                .brightGreen("For example, we can eat")
                .blue(leafyGreen)
                .yellow("and feel great afterwards!")
                .black()
                .bgYellow("It's good!")
                .red()
                .bgYellow("It's good!")
                .toConsoleLn();
    }

    @Test
    void testConsolerizerComposerTitleArguments_whenNewLineAndString_thenNiceLog() {
        ConsolerizerComposer
                .outSpace()
                .ln()
                .green(title("Eating leafy greens is awesome. Let's eat a %s!", "org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration"))
                .toConsoleLn();
    }

    @Test
    void testConsolerizerComposerAutoWrite_whenNewLineAndString_thenNiceLog() {
        ConsolerizerComposer
                .outSpace()
                .ln()
                .autoWrite()
                .file("/tmp/out.txt")
                .green(title("Eating leafy greens is awesome. Let's eat a %s!", "org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration"))
                .none()
                .blue("Gotcha!")
                .yellow("No explicit output needed")
                .ln()
                .red("Tomato!")
                .red("Bell Peppers!")
                .none()
                .green("This is all")
                .black()
                .bgYellow("Tomato Soup!");
    }

    @Test
    void testConsolerizerComposerAutoWriteTitle_whenNewLineAndString_thenNiceLog() {
        ConsolerizerComposer.outSpace()
                .ln()
                .black()
                .bgOrange("1. postProcessBeanFactory")
                .reset()
                .red(title("This is phase BeanFactoryPostProcessor"))
                .blue("This is bean %s", "beanFactory")
                .toConsoleLn();
    }

    @Test
    void testConsolerizerComposerAutoWriteFile_whenNewLineAndString_thenNiceLog() {
        ConsolerizerComposer.outSpace()
                .file("/tmp/out.txt")
                .ln()
                .black()
                .bgOrange("1. postProcessBeanFactory")
                .reset()
                .red(title("This is phase BeanFactoryPostProcessor"))
                .blue("This is bean %s", "beanFactory")
                .toConsoleLn();
    }

    @Test
    void testConsolerizerComposerAllBGw_whenNewLineAndString_thenNiceLog() {
        ConsolerizerComposer.outSpace()
                .black()
                .bgOrange("Hah")
                .bgBlue("Hah")
                .bgCyan("Hah")
                .bgYellow("Hah")
                .bgMagenta("Stayin' Alive")
                .bgRed("Stayin' Alive")
                .bgGreen("Hah")
                .blue("from: http://youtube.com/watch?v=I_izvAbhExY");
    }

    @Test
    void testConsolerizerComposerReset_whenNewLineAndString_thenNiceLog() {
        ConsolerizerComposer.outSpace()
                .endWrite()
                .black()
                .bgOrange("Hah")
                .bgBlue("Hah")
                .bgCyan("Hah")
                .bgYellow("Hah")
                .bgMagenta("Stayin' Alive")
                .bgRed("Stayin' Alive")
                .bgGreen("Hah")
                .blue("from: http://youtube.com/watch?v=I_izvAbhExY")
                .reset()
                .toConsole();
        System.out.println("This is back to normal color!");
        ConsolerizerComposer.outSpace()
                .black()
                .bgOrange("Hah")
                .bgBlue("Hah")
                .bgCyan("Hah")
                .bgYellow("Hah")
                .bgMagenta("Stayin' Alive")
                .bgRed("Stayin' Alive")
                .bgGreen("Hah")
                .blue("from: http://youtube.com/watch?v=I_izvAbhExY")
                .reset();
        System.out.println("This is back to normal color!");
    }

    @Test
    void testConsolerizerComposerForEach_whenStream_thenNiceLog() {
        final var variables = List.of("a", "b", "c", "d", "e");
        ConsolerizerComposer.outSpace()
                .orange()
                .outList("This is variable %s",
                        variables.stream()
                                .map(ConsolerizerVars::create)
                                .collect(Collectors.toList()))
                .reset();
        ConsolerizerComposer.outSpace()
                .red()
                .outList("This is variable %s",
                        create(variables))
                .reset();

        ConsolerizerComposer.outSpace()
                .magenta()
                .outList("This is variable %s",
                        createListFromStrings(variables))
                .reset();
    }

    @Test
    void testConsolerizerComposerForEachComplex_whenStream_thenNiceLog() {
        final var variables = List.of(new Object[]{"a", "b"}, new Object[]{"c", "d"});
        ConsolerizerComposer.outSpace()
                .magenta()
                .outList("This is variable %s, %s",
                        createListFromObjects(variables))
                .reset();
    }

    @Test
    void testConsolerizerComposerQuote_whenText_thenNiceLog() {
        ConsolerizerComposer.outSpace()
                .magenta()
                .magenta(quote("The Color out of space"))
                .reset();
    }

    @Test
    void testConsolerizerCom_whenText_thenNiceLog() {
        ConsolerizerComposer.outSpace()
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .random("This is a random color out of space")
                .reset();
    }


    @Test
    void testConsolerizerComposerUnicorns_whenUnicorns_thenNiceLog() {
        ConsolerizerComposer.outSpace()
                .bgOrange()
                .unicorns(10)
                .unicorn()
                .bgGreen()
                .emoji(POTATO)
                .emoji(POTATO, 100)
                .bgYellow()
                .emoji(TOMATO)
                .emoji(TOMATO, 100)
                .reset()
                .rainbow()
                .rainbow(100)
                .reset();
    }

    @Test
    void testJsonPrettyPrint_whenObject_thenPrintNiceJSON() {
        final var leafyGreen = new LeafyGreen("Cabbage");
        ConsolerizerComposer.outSpace()
                .random()
                .jsonPrettyPrint(leafyGreen)
                .random()
                .jsonPrettyPrint(leafyGreen)
                .reset();
    }
    @Test
    void testJsonPrettyPrint_whenString_thenPrintNiceJSON() {
        ConsolerizerComposer.outSpace()
                .random()
                .jsonPrettyPrint("{\"name\":\"artichoke\"}")
                .random()
                .jsonPrettyPrint("{\"name\":\"artichoke\"}")
                .reset();
    }
}
