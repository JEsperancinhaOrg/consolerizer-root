package org.jesperancinha.console.consolerizer.common;

public abstract class Composer<T> {

    protected final String splitter;

    protected final StringBuffer sb = new StringBuffer();

    protected Composer() {
        this.splitter = "";
    }

    protected Composer(String splitter) {
        this.splitter = splitter;
    }

    public abstract T out(ConsolerizerColor consolerizerColor, Object text);

    public T out(Object text) {
        sb.append(text);
        return (T) this;
    }

    public T white(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.WHITE);
        return (T) this;
    }

    public T black(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.BLACK);
        return (T) this;
    }

    public T blue(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.BLUE);
        return (T) this;
    }

    public T green(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.GREEN);
        return (T) this;
    }

    public T cyan(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.CYAN);
        return (T) this;
    }

    public T red(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.RED);
        return (T) this;
    }

    public T orange(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.ORANGE);
        return (T) this;
    }

    public T magenta(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.MAGENTA);
        return (T) this;
    }

    public T brown(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.BROWN);
        return (T) this;
    }

    public T yellow(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.YELLOW);
        return (T) this;
    }

    public T lightGrey(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.LIGHT_GREY);
        return (T) this;
    }

    public T darkGrey(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.DARK_GREY);
        return (T) this;
    }

    public T brightBlue(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.BRIGHT_BLUE);
        return (T) this;
    }

    public T brightGreen(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.BRIGHT_GREEN);
        return (T) this;
    }

    public T brightCyan(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.BRIGHT_CYAN);
        return (T) this;
    }

    public T brightRed(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.BRIGHT_RED);
        return (T) this;
    }

    public T brightMagenta(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.BRIGHT_MAGENTA);
        return (T) this;
    }

    public T brightWhite(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.BRIGHT_WHITE);
        return (T) this;
    }

    public T bgOrange(Object text, Object... args) {
        processText(text, args, ConsolerizerColor.BG_ORANGE);
        return (T) this;
    }

    private void processText(Object text, Object[] args, ConsolerizerColor white) {
        out(white, String.format("" + text, args));
    }

    public T newLine() {
        out("\n");
        return (T) this;
    }

    public T build() {
        return (T) this;
    }
}
