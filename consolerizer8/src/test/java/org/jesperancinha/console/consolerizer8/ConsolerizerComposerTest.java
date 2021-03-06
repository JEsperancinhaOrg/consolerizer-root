package org.jesperancinha.console.consolerizer8;

import org.jesperancinha.console.consolerizer8.console.Consolerizer;
import org.jesperancinha.console.consolerizer8.console.ConsolerizerComposer;
import org.jesperancinha.console.consolerizer8.console.ConsolerizerGraphs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.jesperancinha.console.consolerizer8.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer8.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer8.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer8.common.ConsolerizerColor.RESET;

class ConsolerizerComposerTest {

    @BeforeEach
    public void setUp() {
        Consolerizer.setupFastDefault();
    }

    @Test
    void testConsolerizerComposer_whenNoSplitter_thenNiceLog() {
        ConsolerizerComposer.out().white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog").toConsole();
        ConsolerizerComposer.out().white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog").toConsole();
    }

    @Test
    void testConsolerizerComposerWithVarags_whenNoSplitter_thenNiceLog() {
        ConsolerizerComposer.out().white("The%s", "One").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog").toConsole();
        ConsolerizerComposer.out().white("The").blue("quick").red("brown").white("fox").orange("jumps").yellow("over")
                .blue("the").green("lazy").red("dog with a %s", "bone").toConsole();
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
}