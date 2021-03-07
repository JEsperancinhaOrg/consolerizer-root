package org.jesperancinha.console.consolerizer.html;

import org.apache.commons.text.StringEscapeUtils;

public class Htmlizer {

    public static String getPTextEscapedColor(final String
                                                      hexColor, final String text) {
        return String.format("<p style=\"margin:0; font-family: monospace; color:#%s\">%s</p>", hexColor.toLowerCase(), StringEscapeUtils.escapeHtml4(text));
    }

    public static String getPBTextEscapedColor(final String
                                                       hexColor, final String text) {
        return String.format("<p style=\"margin:0; font-family: monospace; color:#%s\"><b>%s</b></p>", hexColor.toLowerCase(), StringEscapeUtils.escapeHtml4(text));
    }

    public static String getPTextColor(final String
                                               hexColor, final String text) {
        return String.format("<p style=\"margin:0; font-family: monospace; color:#%s\">%s</p>", hexColor.toLowerCase(), text);
    }

    public static String getPBTextColor(final String
                                                hexColor, final String text) {
        return String.format("<p style=\"margin:0; font-family: monospace; color:#%s\"><b>%s</b></p>", hexColor.toLowerCase(), text);
    }

    public static String getAnchorLink(String hexColor, String text, String url) {
        final String innerText = getPTextEscapedColor(hexColor, text);
        return String.format("<a href=\"%s\" target=\"_blank\">%s</a>",url,innerText);
    }
}
