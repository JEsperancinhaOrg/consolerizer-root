package org.jesperancinha.console.consolerizer.console;

public class LeafyGreen {
    private final String name;

    public LeafyGreen() {
        this.name = null;
    }

    public LeafyGreen(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "LeafyGreen{" +
                "name='" + name + '\'' +
                '}';
    }
}
