package org.jesperancinha.console.consolerizer.console;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

public class ConsolerizerTest {

    @BeforeEach
    public void setUp() {
        Consolerizer.setupFastDefault();
    }

    @Test
    public void testPrintRainbowFlag_whenText_thenTextInMiddle() {
        ConsolerizerGraphs.printRainbowFlag("Happy PRIDE Everyone!");
    }

    @Test
    public void testPrintDifferentColorPerSentence() {
        Consolerizer.currentColor=null;
        Consolerizer.printRawGenericLn("%sThis is green %sand this is red %sand this is green again", true, GREEN, RED, GREEN);
    }

    @Test
    public void testPrintRainbowLn_whenDefault_then10Chars() {
        Consolerizer.printRainbowLn('@');
    }

    @AfterEach
    public void tearDown() {
    }
}