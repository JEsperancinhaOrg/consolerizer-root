package org.jesperancinha.console.consolerizer.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLACK;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.console.Consolerizer.getCalculatedOffSetSize;
import static org.jesperancinha.console.consolerizer.console.Consolerizer.getCalculatedStringSize;

public class ConsolerizerColorTest {

    @Test
    public void testPrintGenericTitleLn_whenDefaultTitle_thenGoodTitle() {
        RED.printGenericTitleLn("This is a great title");
    }

    @Test
    public void testPrintGenericTitleLn2_whenDefaultTitle_thenGoodTitle() {
        GREEN.printGenericTitleLn("Eating leafy greens is awesome.");
    }

    @Test
    public void testCalculateLength_whenColorMixed_rightLength() {
        for (int i = 0; i < ConsolerizerColor.values().length; i++) {
            final int calculatedSize = getCalculatedStringSize(ConsolerizerColor.values()[i].getConsoleColor().concat("A very long string"));
            assertThat(calculatedSize).isEqualTo(18);
        }
    }
    @Test
    public void testCalculateOffSet_whenColorMixed_rightLength() {
        for (int i = 0; i < ConsolerizerColor.values().length; i++) {
            final ConsolerizerColor value = ConsolerizerColor.values()[i];
            final int calculatedSize = getCalculatedOffSetSize(value.getConsoleColor().concat("A very long string"));
            assertThat(calculatedSize).isEqualTo(value.getConsoleColor().length());
        }
    }

    @Test
    public void testColors_whenIterating_thenShowGoodColors(){
        for (int i = 0; i < ConsolerizerColor.values().length; i++) {
            final ConsolerizerColor value = ConsolerizerColor.values()[i];
            System.out.print(BLACK.getConsoleColor());
            System.out.print(value.getConsoleColor());
            System.out.println(value.name());
        }
    }
}