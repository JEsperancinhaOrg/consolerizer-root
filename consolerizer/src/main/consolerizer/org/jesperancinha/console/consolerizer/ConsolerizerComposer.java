package org.jesperancinha.console.consolerizer;

public class ConsolerizerComposer extends Composer<ConsolerizerComposer> {

    ConsolerizerComposer() {
        super();
    }

    ConsolerizerComposer(String splitter) {
        super(splitter);
    }

    public static ConsolerizerComposer out() {
        return new ConsolerizerComposer();
    }

    public static ConsolerizerComposer out(final String splitter) {
        return new ConsolerizerComposer(splitter);
    }

    @Override
    public ConsolerizerComposer out(ConsolerizerColor consolerizerColor, String text) {
        sb.append(consolerizerColor).append(text).append(splitter);
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }

    public void toConsole() {
        Consolerizer.printRawGeneric(toString());
    }

    public void toConsoleLn() {
        Consolerizer.printRawGenericLn(toString());
    }
}
