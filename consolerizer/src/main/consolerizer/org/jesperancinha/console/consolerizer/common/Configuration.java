package org.jesperancinha.console.consolerizer.common;

import java.util.Objects;
import java.util.Properties;

public class Configuration {
    public static boolean showConsolerizer() {
        Properties p = System.getProperties();
        final var test = System.getenv().get("consolerizer.show");
        if (Objects.isNull(test)) {
            final var sysBoolean = (Boolean) p.get("consolerizer.show");
            if (Objects.isNull(sysBoolean)) {
                return true;
            }
            return sysBoolean;
        }
        return Boolean.parseBoolean(test);
    }
}
