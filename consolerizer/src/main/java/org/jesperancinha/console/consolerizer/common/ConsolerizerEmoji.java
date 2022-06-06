package org.jesperancinha.console.consolerizer.common;

public enum ConsolerizerEmoji {
    UNICORN("🦄"),
    RAINBOW("🌈"),
    TOMATO("🍅"),
    POTATO("🥔"),
    CORN("🌽");

    private String emoji;

    ConsolerizerEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }

    @Override
    public String toString() {
        return getEmoji();
    }
}
