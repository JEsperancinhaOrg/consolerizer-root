package org.jesperancinha.console.consolerizer.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.console.Consolerizer.getCalculatedOffSetSize;
import static org.jesperancinha.console.consolerizer.console.Consolerizer.getCalculatedStringSize;

class ConsolerizerColorTest {

    @Test
    void testPrintGenericTitleLn_whenDefaultTitle_thenGoodTitle() {
        RED.printGenericTitleLn("This is a great title");
    }

    @Test
    void testPrintGenericTitleLn2_whenDefaultTitle_thenGoodTitle() {
        GREEN.printGenericTitleLn("Eating leafy greens is awesome.");
    }

    @Test
    void testCalculateLength_whenColorMixed_rightLength() {
        for (int i = 0; i < ConsolerizerColor.values().length; i++) {
            final int calculatedSize = getCalculatedStringSize(ConsolerizerColor.values()[i].getConsoleColor().concat("A very long string"));
            assertThat(calculatedSize).isEqualTo(18);
        }
    }
    @Test
    void testCalculateOffSet_whenColorMixed_rightLength() {
        for (int i = 0; i < ConsolerizerColor.values().length; i++) {
            final ConsolerizerColor value = ConsolerizerColor.values()[i];
            final int calculatedSize = getCalculatedOffSetSize(value.getConsoleColor().concat("A very long string"));
            assertThat(calculatedSize).isEqualTo(value.getConsoleColor().length());
        }
    }
}