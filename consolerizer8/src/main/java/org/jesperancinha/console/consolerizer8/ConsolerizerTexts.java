package org.jesperancinha.console.consolerizer8;

public class ConsolerizerTexts {

    static String createTitleLineLn(Object text, char limitingChar, boolean newLine) {
        final String fullText = text.toString();
        int remaining = Consolerizer.titleSpread - fullText.length() - 2;
        int padding = (int) Math.ceil(remaining / 2f);
        final String substring = new String(new char[padding]).replace('\0', limitingChar)
                .concat(" ")
                .concat(fullText)
                .concat(" ")
                .concat(new String(new char[padding]).replace('\0', limitingChar))
                .substring(0, Consolerizer.titleSpread);
        if (newLine) {
            return substring.concat("\n");
        }
        return substring;
    }

    static String trim(String string) {
        return string.replaceAll("^[\n]+|[\n]+$", "");
    }
}
