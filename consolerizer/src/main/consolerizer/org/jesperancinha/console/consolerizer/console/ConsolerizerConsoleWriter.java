package org.jesperancinha.console.consolerizer.console;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.jesperancinha.console.consolerizer.common.ConsolerizerWriter;

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
