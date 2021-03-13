package org.jesperancinha.console.consolerizer.console;

import org.jesperancinha.console.consolerizer.common.Composer;
import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RESET;
import static org.jesperancinha.console.consolerizer.console.Consolerizer.COLOR_REGEX;
import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRawGeneric;
import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRawGenericLn;

public class ConsolerizerComposer extends Composer<ConsolerizerComposer> {

    ConsolerizerComposer() {
        super();
        resetConsole();
    }

    ConsolerizerComposer(String splitter) {
        super(splitter);
        resetConsole();
    }

    private void resetConsole() {
        System.out.print("");
        System.out.print(RESET.getConsoleColor());
        System.out.print("");
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

    public ConsolerizerComposer ln() {
        this.appender = "\n";
        return this;
    }

    public ConsolerizerComposer none() {
        this.appender = "";
        return this;
    }


    @Override
    public ConsolerizerComposer out(ConsolerizerColor consolerizerColor, Object text) {
        sb.append(consolerizerColor.getConsoleColor()).append(text);
        if (!text.toString().endsWith("\n")) {
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

    public void toConsole() {
        Consolerizer.currentColor = null;
        printRawGeneric(toString(), false);
    }

    public void toConsoleLn() {
        Consolerizer.currentColor = null;
        final String text = toString();
        printRawGenericLn(text, false);
    }
}
