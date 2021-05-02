package org.jesperancinha.console.consolerizer.system;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.junit.jupiter.api.Test;

import java.util.Properties;

public class PropertiesTest {

    @Test
    void testSystemProperties(){
        Properties p = System.getProperties();
        p.setProperty("test","tested");
        testExtracted(p);

        Properties p2 = System.getProperties();
        final var keys = p2.keys();
        while (keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            String value = (String)p.get(key);
            ConsolerizerComposer.outSpace().none().cyan(key).blue(value).newLine().reset();
        }

    }

    private void testExtracted(Properties p) {
        final var keys = p.keys();
        while (keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            String value = (String) p.get(key);
            ConsolerizerComposer.outSpace().none().cyan(key).blue(value).newLine().reset();
        }
    }
}
