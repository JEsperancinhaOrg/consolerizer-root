package org.jesperancinha.console.consolerizer.console;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.jesperancinha.console.consolerizer.common.ConsolerizerEmoji;
import org.jesperancinha.console.consolerizer.common.ConsolerizerWriter;

import java.util.List;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerEmoji.UNICORN;
import static org.jesperancinha.console.consolerizer.console.Consolerizer.titleSpread;

public class ConsolerizerGraphs {

    public static void printRainbowFlag(String flagText, Object... args) {
        printRainbowFlag(String.format(flagText, args));
    }

    /**
     * Follows the 19:10 rule for general flags
     *
     * @param flagText The text to be placed at the center of the flag
     */
    public static void printRainbowFlag(String flagText) {
        printRainbowFlag(flagText, new ConsolerizerConsoleWriter());

    }

    public static void printRainbowFlag(String flagText, ConsolerizerWriter consolerizerWriter) {
        int heightPerColorBar = (int) ((double) (titleSpread) * 10d / 19d) / 6 / 4;
        heightPerColorBar = heightPerColorBar <= 0 ?
                1 :
                heightPerColorBar;
        final List<ConsolerizerColor> consoleRainbow = ConsolerizerColor.getConsoleRainbowEnumList();
        final int rainbowColorSize = consoleRainbow.size();
        final int height = rainbowColorSize * heightPerColorBar;
        int iMiddle = height / 2;
        iMiddle = height % 2 == 0 ?
                iMiddle - 1 :
                iMiddle;
        for (int i = 0, k = 0; i < rainbowColorSize; i++) {
            consolerizerWriter.printColor(consoleRainbow.get(i));
            for (int j = 0; j < heightPerColorBar; j++, k++) {
                if (k == iMiddle || k == iMiddle + 1) {
                    consolerizerWriter.printPrivateText(Consolerizer.createTitleLine(flagText, '*'));
                } else {
                    consolerizerWriter.printPrivateText("*".repeat(titleSpread));
                }
                consolerizerWriter.printNewLine();
            }
        }
    }

    public static void printUnicornsLn(final int nUnicorns) {
        Consolerizer.printRainbowLn('-', nUnicorns / 4);
        for (int i = 0; i < nUnicorns; i++) {
            System.out.print(UNICORN);
        }
        Consolerizer.printNewLine();
        Consolerizer.printRainbowLn('-', nUnicorns / 4);
    }

    public static String getUnicorns(int i) {
        return getEmojiString(UNICORN, i);
    }

    public static String getEmoji(final ConsolerizerEmoji emoji, final int n) {
        return getEmojiString(emoji, n);
    }

    private static String getEmojiString(final ConsolerizerEmoji emoji, final int i) {
        return emoji.toString().repeat(Math.max(0, i));
    }
}
