package org.jesperancinha.console.consolerizer.html;

import org.jesperancinha.console.consolerizer.common.Composer;
import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.jesperancinha.console.consolerizer.common.ConsolerizerWriter;

public class HtmlComposer extends Composer {

    HtmlComposer() {
        super();
    }

    HtmlComposer(String splitter) {
        super(splitter);
    }

    public static HtmlComposer out() {
        return new HtmlComposer();
    }

    public static HtmlComposer out(final String splitter) {
        return new HtmlComposer(String.format("<span>%s</span>", splitter));
    }

    @Override
    public HtmlComposer out(ConsolerizerColor consolerizerColor, Object text) {
        sb.append(String.format("<span style=\"color: %s\">%s</span>", consolerizerColor.getHexColor(), text));
        sb.append(splitter);
        return this;
    }

    @Override
    public HtmlComposer ln() {
        return this;
    }

    @Override
    public HtmlComposer none() {
        return this;
    }

    @Override
    public HtmlComposer toConsoleLn() {
        return this;
    }

    @Override
    public HtmlComposer toConsole() {
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }

    @Override
    public void writeToHtml(ConsolerizerWriter htmlPWriter) {
        htmlPWriter.printRawPrivateText(toString());
    }

    @Override
    public void writeLineToHtml(ConsolerizerWriter htmlPWriter) {
        htmlPWriter.printRawPrivateText("<p>".concat(toString()).concat("</p>"));
    }
}
