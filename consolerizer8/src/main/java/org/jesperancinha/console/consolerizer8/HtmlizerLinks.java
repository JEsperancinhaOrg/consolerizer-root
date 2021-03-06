package org.jesperancinha.console.consolerizer8;

public class HtmlizerLinks {

    public static final String YOUTUBE_FRAME = "<iframe width=\"%d\" height=\"%d\" src=\"https://www.youtube.com/embed/%s\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";

    public static String getYouTubeFrame(final String reference) {
        return String.format(YOUTUBE_FRAME,560, 315, reference);
    }
    public static String getYouTubeFrame(final String reference, final long width, final long height) {
        return String.format(YOUTUBE_FRAME, width, height, reference);
    }
}
