package org.jesperancinha.console.consolerizer8;

public interface ConsolerizerWriter {

    void printPrivateText(String text);

    void printRawPrivateText(String text);

    void printNewLine();

    void printColor(ConsolerizerColor color);

}
