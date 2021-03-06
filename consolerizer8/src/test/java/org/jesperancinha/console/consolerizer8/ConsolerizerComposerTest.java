package org.jesperancinha.console.consolerizer8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsolerizerComposerTest {

    @BeforeEach
    public void setUp() {
        Consolerizer.titleSpread = 200;
        Consolerizer.maxLineCharsGlobal = 200;
    }

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
}