package org.jesperancinha.console.consolerizer;

public class HtmlizerLinks {

    public static final String TWITTER_IFRAME = "<iframe width=\"%d\" height=\"%d\" src=\"https://www.youtube.com/embed/%s\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";

    public static String getTwitterLink(final String reference) {
        return String.format(TWITTER_IFRAME,560, 315, reference);
    }
    public static String getTwitterLink(final String reference, final long width, final long height) {
        return String.format(TWITTER_IFRAME, width, height, reference);
    }
}
