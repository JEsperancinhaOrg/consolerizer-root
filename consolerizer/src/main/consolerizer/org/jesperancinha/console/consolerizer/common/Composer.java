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
        out(ConsolerizerColor.WHITE, String.format("" + text, args));
        return (T) this;
    }

    public T black(Object text, Object... args) {
        out(ConsolerizerColor.BLACK,  String.format("" + text, args));
        return (T) this;
    }

    public T blue(Object text, Object... args) {
        out(ConsolerizerColor.BLUE,  String.format("" + text, args));
        return (T) this;
    }

    public T green(Object text, Object... args) {
        out(ConsolerizerColor.GREEN,  String.format("" + text, args));
        return (T) this;
    }

    public T cyan(Object text, Object... args) {
        out(ConsolerizerColor.CYAN,  String.format("" + text, args));
        return (T) this;
    }

    public T red(Object text, Object... args) {
        out(ConsolerizerColor.RED,  String.format("" + text, args));
        return (T) this;
    }

    public T orange(Object text, Object... args) {
        out(ConsolerizerColor.ORANGE,  String.format("" + text, args));
        return (T) this;
    }

    public T magenta(Object text, Object... args) {
        out(ConsolerizerColor.MAGENTA,  String.format("" + text, args));
        return (T) this;
    }

    public T brown(Object text, Object... args) {
        out(ConsolerizerColor.BROWN,  String.format("" + text, args));
        return (T) this;
    }

    public T yellow(Object text, Object... args) {
        out(ConsolerizerColor.YELLOW,  String.format("" + text, args));
        return (T) this;
    }

    public T lightGrey(Object text, Object... args) {
        out(ConsolerizerColor.LIGHT_GREY,  String.format("" + text, args));
        return (T) this;
    }

    public T darkGrey(Object text, Object... args) {
        out(ConsolerizerColor.DARK_GREY,  String.format("" + text, args));
        return (T) this;
    }

    public T brightBlue(Object text, Object... args) {
        out(ConsolerizerColor.BRIGHT_BLUE,  String.format("" + text, args));
        return (T) this;
    }

    public T brightGreen(Object text, Object... args) {
        out(ConsolerizerColor.BRIGHT_GREEN,  String.format("" + text, args));
        return (T) this;
    }

    public T brightCyan(Object text, Object... args) {
        out(ConsolerizerColor.BRIGHT_CYAN,  String.format("" + text, args));
        return (T) this;
    }

    public T brightRed(Object text, Object... args) {
        out(ConsolerizerColor.BRIGHT_RED,  String.format("" + text, args));
        return (T) this;
    }

    public T brightMagenta(Object text, Object... args) {
        out(ConsolerizerColor.BRIGHT_MAGENTA,  String.format("" + text, args));
        return (T) this;
    }

    public T brightWhite(Object text, Object... args) {
        out(ConsolerizerColor.BRIGHT_WHITE,  String.format("" + text, args));
        return (T) this;
    }

    public T bgOrange(Object text, Object... args) {
        out(ConsolerizerColor.BG_ORANGE,  String.format("" + text, args));
        return (T) this;
    }

    public T newLine() {
        out("\n");
        return (T) this;
    }

    public T build() {
        return (T) this;
    }
}
