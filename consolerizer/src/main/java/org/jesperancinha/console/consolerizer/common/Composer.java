package org.jesperancinha.console.consolerizer.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RESET;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerEmoji.RAINBOW;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerEmoji.UNICORN;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs.getEmoji;

public abstract class Composer<T> {

    private static ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

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

    public abstract Composer<T> out(ConsolerizerColor consolerizerColor, Object text);

    public Composer<T> out(Object text) {
        sb.append(text);
        return this;
    }

    public Composer<T> file(final String fileName) {
        this.file = new File(fileName);
        return this;
    }

    public Composer<T> file() {
        this.file = null;
        return this;
    }

    public Composer<T> autoWrite() {
        this.autoWrite = true;
        return this;
    }

    public Composer<T> endWrite() {
        this.autoWrite = false;
        return this;
    }

    public Composer<T> reset() {
        processText(RESET, new String[]{""});
        return this;
    }

    public Composer<T> white(Object... args) {
        processText(ConsolerizerColor.WHITE, args);
        return this;
    }

    public Composer<T> black(Object... args) {
        processText(ConsolerizerColor.BLACK, args);
        return this;
    }

    public Composer<T> blue(Object... args) {
        processText(ConsolerizerColor.BLUE, args);
        return this;
    }

    public Composer<T> green(Object... args) {
        processText(ConsolerizerColor.GREEN, args);
        return this;
    }

    public Composer<T> cyan(Object... args) {
        processText(ConsolerizerColor.CYAN, args);
        return this;
    }

    public Composer<T> red(Object... args) {
        processText(ConsolerizerColor.RED, args);
        return this;
    }

    public Composer<T> orange(Object... args) {
        processText(ConsolerizerColor.ORANGE, args);
        return this;
    }

    public Composer<T> magenta(Object... args) {
        processText(ConsolerizerColor.MAGENTA, args);
        return this;
    }

    public Composer<T> brown(Object... args) {
        processText(ConsolerizerColor.BROWN, args);
        return this;
    }

    public Composer<T> yellow(Object... args) {
        processText(ConsolerizerColor.YELLOW, args);
        return this;
    }

    public Composer<T> lightGrey(Object... args) {
        processText(ConsolerizerColor.LIGHT_GREY, args);
        return this;
    }

    public Composer<T> darkGrey(Object... args) {
        processText(ConsolerizerColor.DARK_GREY, args);
        return this;
    }

    public Composer<T> brightBlue(Object... args) {
        processText(ConsolerizerColor.BRIGHT_BLUE, args);
        return this;
    }

    public Composer<T> brightGreen(Object... args) {
        processText(ConsolerizerColor.BRIGHT_GREEN, args);
        return this;
    }

    public Composer<T> brightCyan(Object... args) {
        processText(ConsolerizerColor.BRIGHT_CYAN, args);
        return this;
    }

    public Composer<T> brightRed(Object... args) {
        processText(ConsolerizerColor.BRIGHT_RED, args);
        return this;
    }

    public Composer<T> brightMagenta(Object... args) {
        processText(ConsolerizerColor.BRIGHT_MAGENTA, args);
        return this;
    }

    public Composer<T> brightWhite(Object... args) {
        processText(ConsolerizerColor.BRIGHT_WHITE, args);
        return this;
    }

    public Composer<T> bgOrange(Object... args) {
        processText(ConsolerizerColor.BG_ORANGE, args);
        return this;
    }

    public Composer<T> bgYellow(Object... args) {
        processText(ConsolerizerColor.BG_YELLOW, args);
        return this;
    }

    public Composer<T> bgMagenta(Object... args) {
        processText(ConsolerizerColor.BG_MAGENTA, args);
        return this;
    }

    public Composer<T> bgGreen(Object... args) {
        processText(ConsolerizerColor.BG_GREEN, args);
        return this;
    }

    public Composer<T> bgRed(Object... args) {
        processText(ConsolerizerColor.BG_RED, args);
        return this;
    }

    public Composer<T> bgBlue(Object... args) {
        processText(ConsolerizerColor.BG_BLUE, args);
        return this;
    }

    public Composer<T> bgCyan(Object... args) {
        processText(ConsolerizerColor.BG_CYAN, args);
        return this;
    }

    public Composer<T> random(Object... args) {
        processText(ConsolerizerColor.getRandomColor(), args);
        return this;
    }

    private void processText(ConsolerizerColor consolerizerColor, Object... args) {
        if (args.length == 0) {
            out(consolerizerColor);
        } else if (args.length == 1 && "".equals(args[0])) {
            out(consolerizerColor, args[0]);
        } else {
            Object text = args[0];
            final Object[] objects = Arrays.copyOfRange(args, 1, args.length);
            out(consolerizerColor, String.format(("" + text).concat(appender), objects));
        }
    }

    private void processText(Object... args) {
        if (Configuration.showConsolerizer()) {
            if (args.length == 1 && "".equals(args[0])) {
                out(args[0]);
            } else {
                Object text = args[0];
                final Object[] objects = Arrays.copyOfRange(args, 1, args.length);
                out(String.format(("" + text).concat(appender), objects));
            }
        }
    }

    public Composer<T> newLine() {
        out("\n");
        return this;
    }

    public Composer<T> unicorns(int n) {
        processText(ConsolerizerGraphs.getUnicorns(n));
        return this;
    }

    public Composer<T> unicorn() {
        processText(UNICORN);
        return this;
    }

    public Composer<T> rainbow(int n) {
        processText(getEmoji(RAINBOW, n));
        return this;
    }

    public Composer<T> rainbow() {
        processText(RAINBOW);
        return this;
    }

    public Composer<T> emoji(ConsolerizerEmoji emoji) {
        processText(emoji);
        return this;
    }

    public Composer<T> emoji(ConsolerizerEmoji emoji, int n) {
        processText(getEmoji(emoji, n));
        return this;
    }

    public Composer<T> build() {
        return this;
    }

    public Composer<T> outList(String sentence, ConsolerizerVars... consolerizerVars) {
        stream(consolerizerVars).forEach
                (getConsolerizerVarsConsumer(sentence));
        return this;
    }

    public Composer<T> outList(String sentence, List<ConsolerizerVars> consolerizerVars) {
        consolerizerVars.forEach
                (getConsolerizerVarsConsumer(sentence));
        return this;
    }

    private Consumer<ConsolerizerVars> getConsolerizerVarsConsumer(String sentence) {
        return consolerizerVar -> processText(String.format(sentence, consolerizerVar.getValues()));
    }

    /**
     * Create JSON Text with pretty print format
     *
     * @param jsonText A raw json text
     * @return The pretty print formatted text
     */
    public Composer<T> jsonPrettyPrint(Object jsonText) {
        try {
            processText(objectMapper.writeValueAsString(jsonText));
        } catch (JsonProcessingException e) {
            RED.printGenericLn("%s cannot be converted to JSON -> %s", jsonText, e);
        }
        return this;
    }

    /**
     * Create JSON Text with pretty print format
     *
     * @param jsonText A raw json text
     * @return The pretty print formatted text
     */
    public Composer<T> jsonPrettyPrint(String jsonText) {
        try {
            final var jsonNode = objectMapper.readValue(jsonText, JsonNode.class);
            processText(objectMapper.writeValueAsString(jsonNode));
        } catch (JsonProcessingException e) {
            RED.printGenericLn("%s cannot be converted to JSON -> %s", jsonText, e);
        }
        return this;
    }

    public Composer<T> simpleFrame(String text) {
        var charCount = stream(text.split("\n")).map(String::length).mapToInt(i->i).max().orElse(0) + 2;
        var middle = "─".repeat(charCount);
        processText("┌".concat(middle.concat("┐")));
        processText(stream(text.split("\n"))
                .map(t -> "│ ".concat(String.format("%-" + (charCount - 2) + "s", t)).concat(" │"))
                .collect(Collectors.joining("\n")));
        processText("└".concat(middle).concat("┘"));
        return this;
    }

    public Composer<T> doubleFrame(String text) {
        var charCount = stream(text.split("\n")).map(String::length).mapToInt(i->i).max().orElse(0) + 2;
        var middle = "═".repeat(charCount);
        processText("╔".concat(middle.concat("╗")));
        processText(stream(text.split("\n"))
                .map(t -> "║ ".concat(String.format("%-" + (charCount - 2) + "s", t)).concat(" ║"))
                .collect(Collectors.joining("\n")));
        processText("╚".concat(middle).concat("╝"));
        return this;
    }

    public abstract Composer<T> ln();

    public abstract Composer<T> none();

    public abstract Composer<T> toConsoleLn();

    public abstract Composer<T> toConsole();
}
