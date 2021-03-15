package org.jesperancinha.console.consolerizer.console;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;
import static java.util.stream.Collectors.joining;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_WHITE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RESET;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.WHITE;

public class Consolerizer {

    private final static int TYPING_DEFAULT_MS = 0;
    private final static int MAX_LINE_CHARS = 150;
    private final static int RAINBOW_LINE_CHARS = 10;
    private final static int TITLE_SPREAD = 150;
    private final static ConsolerizerColor CON_COLOR_DEFAULT = BRIGHT_WHITE;
    public static final String COLOR_REGEX = "(\033|\u001b)\\[(\\d)*((;|:)*(\\d)*){0,5}m";
    public static ConsolerizerColor currentColor;

    private int typingWait;

    public static int typingWaitGlobal = TYPING_DEFAULT_MS;
    public static int maxLineCharsGlobal = MAX_LINE_CHARS;
    public static int rainbowLineChars = RAINBOW_LINE_CHARS;
    public static int titleSpread = TITLE_SPREAD;
    public static boolean blackAndWhite;

    private final ConsolerizerColor consolerizerColor;

    public Consolerizer() {
        typingWait = TYPING_DEFAULT_MS;
        this.consolerizerColor = CON_COLOR_DEFAULT;
    }

    public Consolerizer(int typingWait) {
        this.typingWait = typingWait;
        this.consolerizerColor = CON_COLOR_DEFAULT;
    }

    public Consolerizer(ConsolerizerColor consolerizerColor) {
        this.consolerizerColor = consolerizerColor;
    }

    public static void setupFastDefault() {
        typingWaitGlobal = 0;
        maxLineCharsGlobal = 150;
        titleSpread = maxLineCharsGlobal;
        rainbowLineChars = 10;
        blackAndWhite = false;
    }

    public static void setupFastDefaultWideTitleSpread() {
        typingWaitGlobal = 0;
        maxLineCharsGlobal = 250;
        titleSpread = maxLineCharsGlobal;
        rainbowLineChars = 10;
        blackAndWhite = false;
    }

    public static void setupRetro() {
        typingWaitGlobal = 10;
        maxLineCharsGlobal = 0;
        titleSpread = 100;
        rainbowLineChars = 10;
        blackAndWhite = false;
    }

    public Consolerizer typingWait(int typingWait) {
        this.typingWait = typingWait;
        return this;
    }

    public static void printRandomColorGenericLn(String text, Object... args) {
        printRandomColorGeneric(text.concat("\n"), args);
    }

    public static void printRandomColorGenericLn(Object text) {
        printRandomColorGeneric(("" + text).trim()
                .concat("\n"));
    }

    public static void printRandomColorGeneric(Object text) {
        printColor(ConsolerizerColor.getRandomColor());
        printPrivateText(text.toString());
    }

    public static void printRandomColorGeneric(String text, Object... args) {
        printColor(ConsolerizerColor.getRandomColor());
        printPrivateText(text, true, args);
    }

    public void printColorText(final ConsolerizerColor consolerizerColor, String text) {
        printColor(consolerizerColor);
        printPrivateText(text);
    }

    public void printText(String text) {
        printColor(consolerizerColor);
        printPrivateText(text);
    }

    public void printText(String text, Object... vars) {
        printColor(consolerizerColor);
        printPrivateText(text, true, vars);
    }

    static void printPrivateText(Object text) {
        if (blackAndWhite) {
            printColor(WHITE);
        }
        printPrivateText(text.toString(), typingWaitGlobal, maxLineCharsGlobal, true);
    }

    private static void printPrivateText(String text, boolean newLineLimit, Object... vars) {
        if (blackAndWhite) {
            printColor(WHITE);
        }
        if (vars instanceof String[][]) {
            printPrivateText(text, typingWaitGlobal, maxLineCharsGlobal,
                    newLineLimit, processMultiArrays2((String[][]) vars));
        } else {
            for (int i = 0; i < vars.length; i++) {
                var variable = vars[i];
                if (variable instanceof Exception) {
                    final StringWriter out = new StringWriter();
                    ((Exception) variable).printStackTrace(new PrintWriter(out));
                    vars[i] = out.toString();
                }
                if (variable instanceof Error) {
                    var e = (Throwable) variable;
                    var stackTrace = e.getStackTrace();
                    var sb = new StringBuilder(e.getClass()
                            .getCanonicalName());
                    if (Objects.nonNull(e.getMessage())) {
                        sb.append("\n\t");
                        sb.append(e.getMessage());
                    }
                    Arrays.stream(stackTrace)
                            .forEach(stackTraceElement -> {
                                sb.append("\n\t");
                                sb.append(stackTraceElement.toString());
                            });
                    if (variable instanceof Error) {
                        Throwable cause = e.getCause();
                        if (Objects.nonNull(cause)) {
                            sb.append("\n");
                            sb.append(cause.getClass()
                                    .getCanonicalName());
                            if (Objects.nonNull(cause.getMessage())) {
                                sb.append("\n\t");
                                sb.append(cause.getMessage());
                            }
                            Arrays.stream(cause.getStackTrace())
                                    .forEach(stackTraceElement -> {
                                        sb.append("\n\t");
                                        sb.append(stackTraceElement.toString());
                                    });
                        }
                    }
                    vars[i] = sb.toString();
                } else if (variable instanceof String[][]) {
                    vars[i] = processMultiArrays2((String[][]) vars[i]);
                } else if (variable instanceof String[]) {
                    vars[i] = "[" .concat(String.join(",", (String[]) variable))
                            .concat("]");
                } else if (variable instanceof int[]) {
                    vars[i] = "[" .concat(IntStream.of((int[]) variable)
                            .mapToObj(Integer::toString)
                            .collect(joining(","))
                            .concat("]"));
                }
            }
            printPrivateText(text, typingWaitGlobal, maxLineCharsGlobal, newLineLimit, vars);
        }
    }

    private static String processMultiArrays2(String[][] vars) {
        return "[" .concat(Arrays.stream(vars)
                .flatMap(x -> Stream.of("[" .concat(String.join(",", x))
                        .concat("]")))
                .collect(joining(",")))
                .concat("]");
    }

    private static void printPrivateText(String text, int typingWait, int maxLineChars, boolean newLineLimit) {
        var printText = text;
        if (maxLineChars > 0 && printText.length() > maxLineChars) {
            printPerLine(printText, typingWait, maxLineChars, newLineLimit);
        } else {
            printColor(currentColor);
            for (int i = 0; i < printText.length(); i++) {
                if (typingWait > 0) {
                    try {
                        sleep(typingWait);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                printColor(currentColor);
                final char c = printText.charAt(i);
                System.out.print(c);
                if (c == '\n') {
                    printColor(currentColor);
                }
            }
            if (!text.contains("\n")) {
                System.out.print(" ");
            }
            System.out.print(RESET.getConsoleColor());
        }
    }

    /**
     * @param printText
     * @param typingWait
     * @param maxLineChars
     * @param newLineLimit When true, it means that the last line that goes over the limit gets new line char.
     */
    private static void printPerLine(String printText, int typingWait, int maxLineChars, boolean newLineLimit) {
        final List<List<String>> collect = Arrays.stream(printText.split("\n"))
                .map(paragraph -> Arrays.stream(getSplit(maxLineChars, paragraph))
                        .map(ConsolerizerTexts::trim)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        final var maxListI = collect.size() - 1;
        for (int k = 0; k < collect.size(); k++) {
            final var list = collect.get(k);
            for (String line : list) {
                final var split = line.split("\n");
                for (int j = 0; j < split.length; j++) {
                    final int maxIndex = split.length - 1;
                    final var subLine = split[j];
                    for (int i = 0; i < subLine.length(); i++) {
                        if (typingWait > 0) {
                            try {
                                sleep(typingWait);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        printColor(currentColor);
                        final char c = subLine.charAt(i);
                        System.out.print(c);
                        if (c == '\n') {
                            printColor(currentColor);
                        }
                    }
                    if (newLineLimit && j == maxIndex && k == maxListI || j < maxIndex || k < maxListI) {
                        printNewLine();
                    }
                }
            }
        }
        if (printText.length() > 0 && printText.charAt(printText.length() - 1) == '\n') {
            printNewLine();
        }
    }

    private static void printPrivateText(String text, int typingWait, int maxLineChars, boolean newLineLimit, final Object... vars) {
        var newText = String.format(text, vars);
        var printText = newText;
        if (maxLineChars > 0) {
            printPerLine(printText, typingWait, maxLineChars, newLineLimit);
        } else {
            for (int i = 0; i < printText.length(); i++) {
                if (typingWait > 0) {
                    try {
                        sleep(typingWait);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                final char c = printText.charAt(i);
                System.out.print(c);
                if (c == '\n') {
                    printColor(currentColor);
                }
            }
            if (!text.contains("\n")) {
                System.out.print(" ");
            }
            System.out.print(RESET.getConsoleColor());
        }
    }

    private static String[] getSplit(int maxLineChars, String printText) {
        var offset = 0;
        if (Objects.nonNull(currentColor)) {
            offset = currentColor.getConsoleColor().length();
        }
        String[] split = ConsolerizerTexts.trim(printText).split("(?<=\\G.{" + maxLineChars + offset + "})");
        if (split.length > 1 && split[1].length() > maxLineChars) {
            String[] newSplit = getSplit(maxLineChars, split[1]);
            int newLength = newSplit.length + 1;
            String[] newStrings = new String[newLength];
            newStrings[0] = ConsolerizerTexts.trim(split[0]);
            System.arraycopy(newSplit, 0, newStrings, 1, newSplit.length);
            return newStrings;
        }
        return split;
    }

    public static void printRainbowTitleLn(final Object title) {
        printRainbowTitle(title.toString()
                .trim());
        System.out.print("\n");
        printColor(RESET);
    }

    public static void printRainbowTitleLn(final String title, final Object... objects) {
        printRainbowTitle(String.format(title, objects));
        System.out.print("\n");
        printColor(RESET);
    }

    public static void printRainbowTitle(final String title) {
        List<String> consoleRainbow = ConsolerizerColor.getConsoleRainbow();
        var k = 0;
        for (var i = 0; i < title.length(); i++) {
            if (k == consoleRainbow.size()) {
                k = 0;
            }
            System.out.print(consoleRainbow.get(k));
            System.out.print(title.charAt(i));
            if (title.charAt(i) != ' ') {
                k++;
            }
        }
        printColor(RESET);
    }

    public static void printRainbowLn(final char c, int nchars) {
        printRainbowLn(Stream.generate(((Character) c)::toString)
                .limit(nchars)
                .collect(joining()));
    }

    public static void printRainbowLn(final char c) {
        printRainbowLn(Stream.generate(((Character) c)::toString)
                .limit(rainbowLineChars)
                .collect(joining()));
    }

    public static void printRainbowLn(final String theme) {
        printRainbow(theme);
        System.out.print("\n");
    }

    public static void printRainbow(final String theme) {
        ConsolerizerColor.getConsoleRainbow()
                .forEach(color -> {
                    System.out.print(color);
                    System.out.print(theme);
                });
    }

    public static void printRainbowStack(final String theme) {
        ConsolerizerColor.getConsoleRainbow()
                .forEach(color -> {
                    System.out.print(color);
                    System.out.println(theme);
                });
    }

    public static void printSameLine(final String text, final Object... objects) {
        System.out.print("\r");
        System.out.printf(text, objects);
    }

    public static void printNewLine() {
        System.out.print("\n");
    }

    static void printColor(ConsolerizerColor consolerizerColor) {
        currentColor = consolerizerColor;
        if (Objects.nonNull(consolerizerColor)) {
            System.out.print(currentColor.getConsoleColor());
        }
    }

    static String createTitleLineLn(Object text, char limitingChar) {
        return ConsolerizerTexts.createTitleLineLn(text, limitingChar, true);
    }

    static String createTitleLine(Object text, char limitingChar) {
        return ConsolerizerTexts.createTitleLineLn(text, limitingChar, false);
    }

    public static void printRawGenericLn(Object text, boolean newLineLimit, Object... args) {
        currentColor = null;
        printPrivateText("" + text.toString().concat("\n"), newLineLimit, args);
    }

    public static void printRawGeneric(Object text, boolean newLineLimit, Object... args) {
        currentColor = null;
        printPrivateText("" + text.toString(), newLineLimit, args);
    }

    public void printGenericLn(Object text, boolean newLineLimit, Object... args) {
        printGeneric(text.toString().concat("\n"), newLineLimit, args);
    }

    public void printGenericLn(Object text) {
        printGeneric(("" + text).trim().concat("\n"));
    }

    public void printGeneric(Object text) {
        printColor(consolerizerColor);
        printPrivateText(text.toString());
    }

    public void printGeneric(Object text, boolean newLineLimit, Object... args) {
        printColor(consolerizerColor);
        printPrivateText(text.toString(), newLineLimit, args);
    }

    public void printGenericTitleLn(Object text, Object... args) {
        printColor(consolerizerColor);
        printGenericTitleLn(String.format("" + text, args));
    }

    public void printGenericTitleLn(Object text) {
        printColor(consolerizerColor);
        final String titleString = Consolerizer.createTitleLineLn(text, '=');
        printGeneric(titleString);
    }

    public void printThrowableAndExit(Throwable e) {
        printColor(consolerizerColor);
        printGenericLn("Ooops! This should not have happened. Check your system! -> %s", true, e);
        printGenericLn("Check if there is a prepare.sh script and if you ran it.", true, e);
        System.exit(1);
    }

    public void printInstanceLn(Object text) {
        printColor(consolerizerColor);
        printGenericLn("This is an instance of type %s with hash %s", true, text.getClass().getCanonicalName(), text.hashCode());
    }

    public static int getCalculatedStringSize(String test) {
        final var newTest = test.replaceAll(COLOR_REGEX, "");
        return newTest.length();
    }

    public static int getCalculatedOffSetSize(String test) {
        final var newTest = test.replaceAll(COLOR_REGEX, "");
        return test.length() - newTest.length();
    }
}
