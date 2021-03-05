package org.jesperancinha.console.consolerizer;

public class ConsolerizerComposer {

    private String splitter;

    ConsolerizerComposer() {
        this.splitter = "";
    }

    ConsolerizerComposer(String splitter) {

        this.splitter = splitter;
    }

    public static ConsolerizerComposer out() {
        return new ConsolerizerComposer();
    }

    public static ConsolerizerComposer out(final String splitter) {
        return new ConsolerizerComposer(splitter);
    }

    private final StringBuilder sb = new StringBuilder();

    private ConsolerizerComposer out(ConsolerizerColor consolerizerColor, String text) {
        sb.append(consolerizerColor).append(text).append(splitter);
        return this;
    }

    public ConsolerizerComposer white(String text) {
        out(ConsolerizerColor.WHITE, text);
        return this;
    }

    public ConsolerizerComposer black(String text) {
        out(ConsolerizerColor.BLACK, text);
        return this;
    }

    public ConsolerizerComposer blue(String text) {
        out(ConsolerizerColor.BLUE, text);
        return this;
    }

    public ConsolerizerComposer red(String text) {
        out(ConsolerizerColor.RED, text);
        return this;
    }

    public ConsolerizerComposer yellow(String text) {
        out(ConsolerizerColor.YELLOW, text);
        return this;
    }

    public ConsolerizerComposer orange(String text) {
        out(ConsolerizerColor.ORANGE, text);
        return this;
    }

    public ConsolerizerComposer bgOrange(String text) {
        out(ConsolerizerColor.BG_ORANGE, text);
        return this;
    }

    public ConsolerizerComposer green(String text) {
        out(ConsolerizerColor.GREEN, text);
        return this;
    }

    public ConsolerizerComposer magenta(String text) {
        out(ConsolerizerColor.MAGENTA, text);
        return this;
    }
    public ConsolerizerComposer brown(String text) {
        out(ConsolerizerColor.BROWN, text);
        return this;
    }

    public ConsolerizerComposer cyan(String text) {
        out(ConsolerizerColor.CYAN, text);
        return this;
    }

    public ConsolerizerComposer brightWhite(String text) {
        out(ConsolerizerColor.BRIGHT_WHITE, text);
        return this;
    }
    public ConsolerizerComposer brightMagenta(String text) {
        out(ConsolerizerColor.BRIGHT_MAGENTA, text);
        return this;
    }

    public ConsolerizerComposer brightRed(String text) {
        out(ConsolerizerColor.BRIGHT_RED, text);
        return this;
    }
    public ConsolerizerComposer brightCyan(String text) {
        out(ConsolerizerColor.BRIGHT_CYAN, text);
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }

    public void toConsole() {
        Consolerizer.printRawGeneric(toString());
    }

    public void toConsoleLn() {
        Consolerizer.printRawGenericLn(toString());
    }
}
