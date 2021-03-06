package org.jesperancinha.console.consolerizer8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.RED;

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

    @AfterEach
    void tearDown() {
    }
}