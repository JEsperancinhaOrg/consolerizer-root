package org.jesperancinha.console.consolerizer.common;

import java.util.Objects;

import static java.lang.Boolean.parseBoolean;

public class Configuration {
    public static boolean showConsolerizer() {
        final var test = System.getenv().get("consolerizer.show");
        if (Objects.isNull(test)) {
            final var p = System.getProperties();
            final var sysBoolean = p.get("consolerizer.show");
            if (Objects.isNull(sysBoolean)) {
                return true;
            }
            return parseBoolean(sysBoolean.toString());
        }
        return parseBoolean(test);
    }
}
