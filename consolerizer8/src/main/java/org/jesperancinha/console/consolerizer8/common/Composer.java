package org.jesperancinha.console.consolerizer8.common;

public abstract class Composer<T> {

    protected final String splitter;

    protected final StringBuffer sb = new StringBuffer();

    protected Composer() {
        this.splitter = "";
    }

    protected Composer(String splitter) {
        this.splitter = splitter;
    }

    public abstract T out(ConsolerizerColor consolerizerColor, String text);

    public T white(String text) {
        out(ConsolerizerColor.WHITE, text);
        return (T) this;
    }

    public T black(String text) {
        out(ConsolerizerColor.BLACK, text);
        return (T) this;
    }

    public T blue(String text) {
        out(ConsolerizerColor.BLUE, text);
        return (T) this;
    }

    public T green(String text) {
        out(ConsolerizerColor.GREEN, text);
        return (T) this;
    }

    public T cyan(String text) {
        out(ConsolerizerColor.CYAN, text);
        return (T) this;
    }

    public T red(String text) {
        out(ConsolerizerColor.RED, text);
        return (T) this;
    }

    public T orange(String text) {
        out(ConsolerizerColor.ORANGE, text);
        return (T) this;
    }

    public T magenta(String text) {
        out(ConsolerizerColor.MAGENTA, text);
        return (T) this;
    }

    public T brown(String text) {
        out(ConsolerizerColor.BROWN, text);
        return (T) this;
    }

    public T yellow(String text) {
        out(ConsolerizerColor.YELLOW, text);
        return (T) this;
    }

    public T lightGrey(String text) {
        out(ConsolerizerColor.LIGHT_GREY, text);
        return (T) this;
    }

    public T darkGrey(String text) {
        out(ConsolerizerColor.DARK_GREY, text);
        return (T) this;
    }

    public T brightBlue(String text) {
        out(ConsolerizerColor.BRIGHT_BLUE, text);
        return (T) this;
    }

    public T brightGreen(String text) {
        out(ConsolerizerColor.BRIGHT_GREEN, text);
        return (T) this;
    }

    public T brightCyan(String text) {
        out(ConsolerizerColor.BRIGHT_CYAN, text);
        return (T) this;
    }

    public T brightRed(String text) {
        out(ConsolerizerColor.BRIGHT_RED, text);
        return (T) this;
    }

    public T brightMagenta(String text) {
        out(ConsolerizerColor.BRIGHT_MAGENTA, text);
        return (T) this;
    }

    public T brightWhite(String text) {
        out(ConsolerizerColor.BRIGHT_WHITE, text);
        return (T) this;
    }

    public T bgOrange(String text) {
        out(ConsolerizerColor.BG_ORANGE, text);
        return (T) this;
    }

    public T build(){
        return (T)this;
    }
}
