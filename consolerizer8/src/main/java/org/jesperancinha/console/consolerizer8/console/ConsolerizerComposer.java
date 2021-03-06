package org.jesperancinha.console.consolerizer8.console;

import org.jesperancinha.console.consolerizer8.common.Composer;
import org.jesperancinha.console.consolerizer8.common.ConsolerizerColor;

import static org.jesperancinha.console.consolerizer8.common.ConsolerizerColor.RESET;

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

    @Override
    public ConsolerizerComposer out(ConsolerizerColor consolerizerColor, Object text) {
        sb.append(consolerizerColor.getConsoleColor()).append(text).append(splitter);
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }

    public void toConsole() {
        Consolerizer.currentColor = null;
        Consolerizer.printRawGeneric(toString());
    }

    public void toConsoleLn() {
        Consolerizer.currentColor = null;
        Consolerizer.printRawGenericLn(toString());
    }
}
