package org.jesperancinha.console.consolerizer.common;

import java.util.List;
import java.util.stream.Collectors;

public class ConsolerizerVars {

    private ConsolerizerVars(Object[] values) {
        this.values = values;
    }

    public static ConsolerizerVars create(Object... values) {
        return new ConsolerizerVars(values);
    }

    public static List<ConsolerizerVars> createListFromStrings(List<String> values) {
        return values.stream()
                .map(ConsolerizerVars::create)
                .collect(Collectors.toList());
    }

    public static List<ConsolerizerVars> createListFromObjects(List<Object[]> values) {
        return values.stream()
                .map(ConsolerizerVars::create)
                .collect(Collectors.toList());
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }

    private Object[] values;
}
