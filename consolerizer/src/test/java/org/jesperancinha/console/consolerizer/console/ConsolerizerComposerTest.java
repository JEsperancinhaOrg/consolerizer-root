package org.jesperancinha.console.consolerizer.console;

import org.jesperancinha.console.consolerizer.console.utils.LeafyGreen;
import org.junit.jupiter.api.Test;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RESET;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title;

class ConsolerizerComposerTest {

    @Test
    void testConsolerizerComposer_whenNoSplitter_thenNiceLog() {
        ConsolerizerComposer.out().white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog").toConsole();
        ConsolerizerComposer.out().white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog").toConsole();
    }

    @Test
    void testConsolerizerComposer_whenSplitter_thenNiceLog() {
        ConsolerizerComposer.out(" ").white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog").toConsole();
        ConsolerizerComposer.out(" ").white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
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
        ConsolerizerComposer.out(" ").white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").bgOrange("dog").build().toConsoleLn();
        ConsolerizerComposer.out(" ").brown("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").magenta("dog").toConsoleLn();
    }

    @Test
    void testConsolerizerComposer2_whenSplitterLn_thenNiceLog() {
        ConsolerizerComposer.out(" ").brightCyan("The").brightWhite("quick").brightMagenta("brown").white("fox").brightRed("jumps").yellow("over")
                .blue("the").green("lazy").bgOrange("dog").toConsoleLn();
        ConsolerizerComposer.out(" ").cyan("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").magenta("dog").toConsoleLn();
    }

    @Test
    void testConsolerizerComposer3_whenSplitterLn_thenNiceLog() {
        ConsolerizerComposer.out(" ").brightCyan("The").black("quick").lightGrey("brown").white("fox").brightRed("jumps").yellow("over")
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
}
