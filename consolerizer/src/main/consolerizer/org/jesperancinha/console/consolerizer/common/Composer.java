package org.jesperancinha.console.consolerizer.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Arrays.stream;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RESET;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerEmoji.RAINBOW;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerEmoji.UNICORN;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs.getEmoji;

public abstract class Composer<T> implements Cloneable {

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

    public T reset() {
        processText(RESET, new String[]{""});
        return (T) this;
    }

    public T white(Object... args) {
        processText(ConsolerizerColor.WHITE, args);
        return (T) this;
    }

    public T black(Object... args) {
        processText(ConsolerizerColor.BLACK, args);
        return (T) this;
    }

    public T blue(Object... args) {
        processText(ConsolerizerColor.BLUE, args);
        return (T) this;
    }

    public T green(Object... args) {
        processText(ConsolerizerColor.GREEN, args);
        return (T) this;
    }

    public T cyan(Object... args) {
        processText(ConsolerizerColor.CYAN, args);
        return (T) this;
    }

    public T red(Object... args) {
        processText(ConsolerizerColor.RED, args);
        return (T) this;
    }

    public T orange(Object... args) {
        processText(ConsolerizerColor.ORANGE, args);
        return (T) this;
    }

    public T magenta(Object... args) {
        processText(ConsolerizerColor.MAGENTA, args);
        return (T) this;
    }

    public T brown(Object... args) {
        processText(ConsolerizerColor.BROWN, args);
        return (T) this;
    }

    public T yellow(Object... args) {
        processText(ConsolerizerColor.YELLOW, args);
        return (T) this;
    }

    public T lightGrey(Object... args) {
        processText(ConsolerizerColor.LIGHT_GREY, args);
        return (T) this;
    }

    public T darkGrey(Object... args) {
        processText(ConsolerizerColor.DARK_GREY, args);
        return (T) this;
    }

    public T brightBlue(Object... args) {
        processText(ConsolerizerColor.BRIGHT_BLUE, args);
        return (T) this;
    }

    public T brightGreen(Object... args) {
        processText(ConsolerizerColor.BRIGHT_GREEN, args);
        return (T) this;
    }

    public T brightCyan(Object... args) {
        processText(ConsolerizerColor.BRIGHT_CYAN, args);
        return (T) this;
    }

    public T brightRed(Object... args) {
        processText(ConsolerizerColor.BRIGHT_RED, args);
        return (T) this;
    }

    public T brightMagenta(Object... args) {
        processText(ConsolerizerColor.BRIGHT_MAGENTA, args);
        return (T) this;
    }

    public T brightWhite(Object... args) {
        processText(ConsolerizerColor.BRIGHT_WHITE, args);
        return (T) this;
    }

    public T bgOrange(Object... args) {
        processText(ConsolerizerColor.BG_ORANGE, args);
        return (T) this;
    }

    public T bgYellow(Object... args) {
        processText(ConsolerizerColor.BG_YELLOW, args);
        return (T) this;
    }

    public T bgMagenta(Object... args) {
        processText(ConsolerizerColor.BG_MAGENTA, args);
        return (T) this;
    }

    public T bgGreen(Object... args) {
        processText(ConsolerizerColor.BG_GREEN, args);
        return (T) this;
    }

    public T bgRed(Object... args) {
        processText(ConsolerizerColor.BG_RED, args);
        return (T) this;
    }

    public T bgBlue(Object... args) {
        processText(ConsolerizerColor.BG_BLUE, args);
        return (T) this;
    }

    public T bgCyan(Object... args) {
        processText(ConsolerizerColor.BG_CYAN, args);
        return (T) this;
    }

    public T random(Object... args) {
        processText(ConsolerizerColor.getRandomColor(), args);
        return (T) this;
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
        if (args.length == 1 && "".equals(args[0])) {
            out(args[0]);
        } else {
            Object text = args[0];
            final Object[] objects = Arrays.copyOfRange(args, 1, args.length);
            out(String.format(("" + text).concat(appender), objects));
        }
    }

    public T newLine() {
        out("\n");
        return (T) this;
    }

    public T unicorns(int n) {
        processText(ConsolerizerGraphs.getUnicorns(n));
        return (T) this;
    }

    public T unicorn() {
        processText(UNICORN);
        return (T) this;
    }

    public T rainbow(int n) {
        processText(getEmoji(RAINBOW, n));
        return (T) this;
    }

    public T rainbow() {
        processText(RAINBOW);
        return (T) this;
    }

    public T emoji(ConsolerizerEmoji emoji) {
        processText(emoji);
        return (T) this;
    }

    public T emoji(ConsolerizerEmoji emoji, int n) {
        processText(getEmoji(emoji, n));
        return (T) this;
    }

    public T build() {
        return (T) this;
    }

    public T outList(String sentence, ConsolerizerVars... consolerizerVars) {
        stream(consolerizerVars).forEach
                (getConsolerizerVarsConsumer(sentence));
        return (T) this;
    }

    public T outList(String sentence, List<ConsolerizerVars> consolerizerVars) {
        consolerizerVars.forEach
                (getConsolerizerVarsConsumer(sentence));
        return (T) this;
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
    public T jsonPrettyPrint(Object jsonText) {
        try {
            processText(objectMapper.writeValueAsString(jsonText));
        } catch (JsonProcessingException e) {
            RED.printGenericLn("%s cannot be converted to JSON -> %s", jsonText, e);
        }
        return (T) this;
    }
    /**
     * Create JSON Text with pretty print format
     *
     * @param jsonText A raw json text
     * @return The pretty print formatted text
     */
    public T jsonPrettyPrint(String jsonText) {
        try {
            final var jsonNode = objectMapper.readValue(jsonText, JsonNode.class);
            processText(objectMapper.writeValueAsString(jsonNode));
        } catch (JsonProcessingException e) {
            RED.printGenericLn("%s cannot be converted to JSON -> %s", jsonText, e);
        }
        return (T) this;
    }

}
