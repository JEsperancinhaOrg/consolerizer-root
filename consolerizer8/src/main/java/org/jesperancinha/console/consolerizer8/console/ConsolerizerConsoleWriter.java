package org.jesperancinha.console.consolerizer8.console;

import org.jesperancinha.console.consolerizer8.common.ConsolerizerColor;
import org.jesperancinha.console.consolerizer8.common.ConsolerizerWriter;

public class ConsolerizerConsoleWriter implements ConsolerizerWriter {

    @Override
    public void printPrivateText(String text) {
        Consolerizer.printPrivateText(text);
    }

    @Override
    public void printRawPrivateText(String text) {
        Consolerizer.printPrivateText(text);
    }

    @Override
    public void printNewLine() {
        Consolerizer.printNewLine();
    }

    @Override
    public void printColor(ConsolerizerColor color) {
        Consolerizer.printColor(color);
    }
}
