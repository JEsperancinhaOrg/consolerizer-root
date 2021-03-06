package org.jesperancinha.console.consolerizer8;

import org.jesperancinha.console.consolerizer8.console.Consolerizer;
import org.jesperancinha.console.consolerizer8.console.ConsolerizerGraphs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.jesperancinha.console.consolerizer8.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer8.common.ConsolerizerColor.RED;

class ConsolerizerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testPrintRainbowFlag_whenText_thenTextInMiddle() {
        ConsolerizerGraphs.printRainbowFlag("Happy PRIDE Everyone!");
    }

    @Test
    void testPrintDifferentColorPerSentence() {
        Consolerizer.printRawGenericLn("%sThis is green %sand this is red %sand this is green again", GREEN, RED, GREEN);
    }


    @Test
    void testPrintRainbowLn_whenDefault_then10Chars() {
        Consolerizer.printRainbowLn('@');
    }

    @AfterEach
    void tearDown() {
    }
}