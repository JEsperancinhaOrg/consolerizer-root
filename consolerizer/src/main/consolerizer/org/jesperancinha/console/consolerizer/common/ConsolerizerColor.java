package org.jesperancinha.console.consolerizer.common;

import org.jesperancinha.console.consolerizer.console.Consolerizer;
import org.jesperancinha.console.consolerizer.html.Htmlizer;

import java.util.Arrays;
import java.util.List;

public enum ConsolerizerColor {
    RESET("FFFFFF", "\033[0m"),
    WHITE("FFFFFF", "\033[0m"),
    BLACK("000000", "\033[0;30m"),
    BLUE("0000AA", "\033[0;34m"),
    GREEN("00AA00", "\033[0;32m"),
    CYAN("00AAAA", "\033[38:2:0:255:255m"),
    RED("AA0000", "\033[38:2:255:0:0m"),
    ORANGE("FFA500", "\u001b[38;5;208m"),
    MAGENTA("AA00AA", "\u001b[38;5;135m"),
    BROWN("AA5500", "\033[0;33m"),
    YELLOW("FFFF55", "\u001b[38;5;226m"),
    LIGHT_GREY("AAAAAA", "\033[0;37m"),
    DARK_GREY("555555", "\033[0;90m"),
    BRIGHT_BLUE("5555FF", "\033[1;34m"),
    BRIGHT_GREEN("55FF55", "\033[1;32m"),
    BRIGHT_CYAN("55FFFF", "\033[38:2:0:255:255:1m"),
    BRIGHT_RED("FF5555", "\033[38:2:255:0:0:1m"),
    BRIGHT_MAGENTA("FF55FF", "\033[0;95m"),
    BRIGHT_WHITE("FFFFFF", "\033[1;39m"),
    BRIGHT_YELLOW("FFFF55", "\u001b[38;5;226;1m"),
    BG_ORANGE("FF8000", "\033[48:2:255:165:0m"),
    BG_YELLOW("FFFF00", "\033[48:2:255:255:0m"),
    BG_GREEN("00FF00", "\033[48:2:0:255:0m"),
    BG_RED("FF0000", "\033[48:2:255:0:0m"),
    BG_BLUE("0000FF", "\033[48:2:0:0:255m"),
    BG_CYAN("00FFFF", "\033[48:2:0:255:255m"),
    BG_MAGENTA("FF00FF", "\033[48:2:255:0:255m");

    private final Consolerizer colorManager;
    private final String hexColor;
    private final String consoleColor;

    ConsolerizerColor(String hexColor, String consoleColor) {
        this.hexColor = hexColor;
        this.consoleColor = consoleColor;
        this.colorManager = new Consolerizer(this);
        Consolerizer.setupFastDefault();
    }

    public static ConsolerizerColor getRandomColor() {
        final ConsolerizerColor[] values = values();
        var randomI = (int) (Math.random() * values.length);
        return values[randomI];
    }

    public String getConsoleColor() {
        return consoleColor;
    }

    public String getHexColor() {
        return hexColor;
    }

    public Consolerizer getColorManager() {
        return colorManager;
    }

    public void printGenericLn(Object text, Object... args) {
        colorManager.printGenericLn(text, true, args);
    }

    synchronized
    public void printSyncGenericLn(Object text, Object... args) {
        colorManager.printGenericLn(text, true, args);
    }

    public void printGenericLn(Object text) {
        colorManager.printGenericLn(text);
    }

    synchronized
    public void printSyncGenericLn(Object text) {
        colorManager.printGenericLn(text);
    }

    public void printGeneric(Object text) {
        colorManager.printGeneric(text);
    }

    public void printGeneric(Object text, Object... args) {
        colorManager.printGeneric(text, true, args);
    }

    public void printGenericTitleLn(Object text, Object... args) {
        colorManager.printGenericTitleLn(text, args);
    }

    synchronized
    public void printSyncGenericTitleLn(Object text) {
        colorManager.printGenericTitleLn(text);
    }

    public void printGenericTitleLn(Object text) {
        colorManager.printGenericTitleLn(text);
    }

    public void printThrowableAndExit(Throwable e) {
        colorManager.printThrowableAndExit(e);
    }

    public void printInstanceLn(Object text) {
        colorManager.printInstanceLn(text);
    }

    public String getPText(Object text, Object... args) {
        return getPText(String.format("" + text, args));
    }

    public String getPText(Object text) {
        return Htmlizer.getPTextColor(this.hexColor, "" + text);
    }

    public String getPBText(Object text, Object... args) {
        return getPBText(String.format("" + text, args));
    }

    public String getPBText(Object text) {
        return Htmlizer.getPBTextColor(this.hexColor, "" + text);
    }

    public String getPBEscapedText(Object text, Object... args) {
        return getPBEscapedText(String.format("" + text, args));
    }

    public String getPBEscapedText(Object text) {
        return Htmlizer.getPBTextEscapedColor(this.hexColor, "" + text);
    }

    public String getAnchorLink(Object text, String url) {
        return Htmlizer.getAnchorLink(this.hexColor, "" + text, url);
    }

    public static List<String> getConsoleRainbow() {
        return Arrays.asList(RED.getConsoleColor(), ORANGE.getConsoleColor(), YELLOW.getConsoleColor(),
                GREEN.getConsoleColor(), BLUE.getConsoleColor(), MAGENTA.getConsoleColor());
    }

    public static List<ConsolerizerColor> getConsoleRainbowEnumList() {
        return Arrays.asList(RED, ORANGE, YELLOW, GREEN, BLUE, MAGENTA);
    }

    public void printExpectedException(String text, Object e) {
        printGenericLn("This is expected! %s -> %s", text, e);
    }

    @Override
    public String toString() {
        return consoleColor;
    }
}
