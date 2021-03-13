package org.jesperancinha.console.consolerizer.common;

import java.io.File;
import java.util.Arrays;

public abstract class Composer<T> {

    protected final String splitter;

    protected String appender;

    protected boolean autoWrite;

    protected final StringBuilder sb = new StringBuilder();

    protected File file;

    protected Composer() {
        this.splitter = "";
        this.appender = "";
    }

    protected Composer(String splitter) {
        this.splitter = splitter;
        this.appender = "";
    }

    public abstract T out(ConsolerizerColor consolerizerColor, Object text);

    public T out(Object text) {
        sb.append(text);
        return (T) this;
    }

    public T file(final String fileName) {
        this.file = new File(fileName);
        return (T) this;
    }

    public T file() {
        this.file = null;
        return (T) this;
    }

    public T autoWrite() {
        this.autoWrite = true;
        return (T) this;
    }

    public T endWrite() {
        this.autoWrite = false;
        return (T) this;
    }

    public T white(Object... args) {
        processText(args, ConsolerizerColor.WHITE);
        return (T) this;
    }

    public T black(Object... args) {
        processText(args, ConsolerizerColor.BLACK);
        return (T) this;
    }

    public T blue(Object... args) {
        processText(args, ConsolerizerColor.BLUE);
        return (T) this;
    }

    public T green(Object... args) {
        processText(args, ConsolerizerColor.GREEN);
        return (T) this;
    }

    public T cyan(Object... args) {
        processText(args, ConsolerizerColor.CYAN);
        return (T) this;
    }

    public T red(Object... args) {
        processText(args, ConsolerizerColor.RED);
        return (T) this;
    }

    public T orange(Object... args) {
        processText(args, ConsolerizerColor.ORANGE);
        return (T) this;
    }

    public T magenta(Object... args) {
        processText(args, ConsolerizerColor.MAGENTA);
        return (T) this;
    }

    public T brown(Object... args) {
        processText(args, ConsolerizerColor.BROWN);
        return (T) this;
    }

    public T yellow(Object... args) {
        processText(args, ConsolerizerColor.YELLOW);
        return (T) this;
    }

    public T lightGrey(Object... args) {
        processText(args, ConsolerizerColor.LIGHT_GREY);
        return (T) this;
    }

    public T darkGrey(Object... args) {
        processText(args, ConsolerizerColor.DARK_GREY);
        return (T) this;
    }

    public T brightBlue(Object... args) {
        processText(args, ConsolerizerColor.BRIGHT_BLUE);
        return (T) this;
    }

    public T brightGreen(Object... args) {
        processText(args, ConsolerizerColor.BRIGHT_GREEN);
        return (T) this;
    }

    public T brightCyan(Object... args) {
        processText(args, ConsolerizerColor.BRIGHT_CYAN);
        return (T) this;
    }

    public T brightRed(Object... args) {
        processText(args, ConsolerizerColor.BRIGHT_RED);
        return (T) this;
    }

    public T brightMagenta(Object... args) {
        processText(args, ConsolerizerColor.BRIGHT_MAGENTA);
        return (T) this;
    }

    public T brightWhite(Object... args) {
        processText(args, ConsolerizerColor.BRIGHT_WHITE);
        return (T) this;
    }

    public T bgOrange(Object... args) {
        processText(args, ConsolerizerColor.BG_ORANGE);
        return (T) this;
    }

    public T bgYellow(Object... args) {
        processText(args, ConsolerizerColor.BG_YELLOW);
        return (T) this;
    }

    private void processText(Object[] args, ConsolerizerColor consolerizerColor) {
        if (args.length == 0) {
            out(consolerizerColor);
        } else {
            Object text = args[0];
            final Object[] objects = Arrays.copyOfRange(args, 1, args.length);
            out(consolerizerColor, String.format(("" + text).concat(appender), objects));
        }
    }

    public T newLine() {
        out("\n");
        return (T) this;
    }

    public T build() {
        return (T) this;
    }
}
