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

    public abstract T out(ConsolerizerColor consolerizerColor, String text);

    public T white(String text, String...args) {
        out(ConsolerizerColor.WHITE, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T black(String text, String...args) {
        out(ConsolerizerColor.BLACK, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T blue(String text, String...args) {
        out(ConsolerizerColor.BLUE, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T green(String text, String...args) {
        out(ConsolerizerColor.GREEN, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T cyan(String text, String...args) {
        out(ConsolerizerColor.CYAN, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T red(String text, String...args) {
        out(ConsolerizerColor.RED, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T orange(String text, String...args) {
        out(ConsolerizerColor.ORANGE, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T magenta(String text, String...args) {
        out(ConsolerizerColor.MAGENTA, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T brown(String text, String...args) {
        out(ConsolerizerColor.BROWN, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T yellow(String text, String...args) {
        out(ConsolerizerColor.YELLOW, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T lightGrey(String text, String...args) {
        out(ConsolerizerColor.LIGHT_GREY, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T darkGrey(String text, String...args) {
        out(ConsolerizerColor.DARK_GREY, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T brightBlue(String text, String...args) {
        out(ConsolerizerColor.BRIGHT_BLUE, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T brightGreen(String text, String...args) {
        out(ConsolerizerColor.BRIGHT_GREEN, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T brightCyan(String text, String...args) {
        out(ConsolerizerColor.BRIGHT_CYAN, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T brightRed(String text, String...args) {
        out(ConsolerizerColor.BRIGHT_RED, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T brightMagenta(String text, String...args) {
        out(ConsolerizerColor.BRIGHT_MAGENTA, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T brightWhite(String text, String...args) {
        out(ConsolerizerColor.BRIGHT_WHITE, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T bgOrange(String text, String...args) {
        out(ConsolerizerColor.BG_ORANGE, String.format(text, (Object[]) args));
        return (T) this;
    }

    public T build(){
        return (T)this;
    }
}
