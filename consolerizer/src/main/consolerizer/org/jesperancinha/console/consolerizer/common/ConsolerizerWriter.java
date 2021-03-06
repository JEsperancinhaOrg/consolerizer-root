package org.jesperancinha.console.consolerizer.common;

public interface ConsolerizerWriter {

    void printPrivateText(String text);

    void printRawPrivateText(String text);

    void printNewLine();

    void printColor(ConsolerizerColor color);

}
