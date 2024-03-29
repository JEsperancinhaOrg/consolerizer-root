package org.jesperancinha.console.consolerizer.console;

import org.jesperancinha.console.consolerizer.common.Composer;
import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.jesperancinha.console.consolerizer.common.ConsolerizerWriter;
import org.jesperancinha.console.consolerizer.html.HtmlPWriter;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RESET;
import static org.jesperancinha.console.consolerizer.console.Consolerizer.*;
import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRawGeneric;

public class ConsolerizerComposer extends Composer {

    ConsolerizerComposer() {
        super();
        resetConsole();
    }

    ConsolerizerComposer(String splitter) {
        super(splitter);
        resetConsole();
    }

    /**
     * Defaults:
     * 1. Reset console color
     * 2. Work in ln mode
     * 3. Autowrite to save in cache
     */
    private void resetConsole() {
        System.out.print("");
        System.out.print(RESET.getConsoleColor());
        System.out.print("");
        ln();
        autoWrite();
    }

    public static ConsolerizerComposer out() {
        return new ConsolerizerComposer();
    }

    public static ConsolerizerComposer out(final String splitter) {
        return new ConsolerizerComposer(splitter);
    }

    public static ConsolerizerComposer outSpace() {
        return new ConsolerizerComposer(" ");
    }

    public static String title(Object text, Object... args) {
        return Consolerizer.createTitleLine(String.format("" + text, args), '=');
    }

    public static String quote(Object text, Object... args) {
        return String.format(("\"" + text).concat("\""), args);
    }

    /**
     * Sets the new line appender to a '\n' character
     *
     * @return The composer {@link ConsolerizerComposer}
     */
    public ConsolerizerComposer ln() {
        this.appender = "\n";
        return this;
    }

    /**
     * Sets the new line appender to an empty string
     *
     * @return The composer {@link ConsolerizerComposer}
     */
    public ConsolerizerComposer none() {
        this.appender = "";
        return this;
    }

    @Override
    public ConsolerizerComposer out(ConsolerizerColor consolerizerColor, Object text) {
        sb.append(consolerizerColor.getConsoleColor()).append(text);
        if (!"".equals(text) && !text.toString().endsWith("\n")) {
            sb.append(splitter);
        }
        if (Objects.nonNull(file)) {
            try (final var fos = new FileOutputStream(file, true);
                 final var oos = new BufferedOutputStream(fos)) {
                oos.write(sb.toString().replaceAll(COLOR_REGEX, "").getBytes(StandardCharsets.UTF_8));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (autoWrite) {
            toConsole();
            sb.setLength(0);
        }
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }

    @Override
    public ConsolerizerComposer toConsole() {
        Consolerizer.currentColor = null;
        printRawGeneric(toString(), false);
        return this;
    }

    @Override
    public void writeToHtml(ConsolerizerWriter htmlPWriter) {
    }

    @Override
    public void writeLineToHtml(ConsolerizerWriter consolerizerWriter) {

    }

    public ConsolerizerComposer toConsoleLn() {
        Consolerizer.currentColor = null;
        final String text = toString();
        printRawGenericLn(text, false);
        return this;
    }
}
