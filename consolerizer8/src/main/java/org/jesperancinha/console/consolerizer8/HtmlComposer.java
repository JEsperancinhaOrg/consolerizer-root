package org.jesperancinha.console.consolerizer8;

public class HtmlComposer extends Composer<HtmlComposer> {

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
    public HtmlComposer out(ConsolerizerColor consolerizerColor, String text) {
        sb.append(String.format("<span style=\"color: %s\">%s</span>", consolerizerColor.getHexColor(), text));
        sb.append(splitter);
        return this;
    }

    @Override
    public String toString() {
        return sb.toString();
    }

    public void writeToHtml(HtmlPWriter htmlPWriter) {
        htmlPWriter.printRawPrivateText(toString());
    }

    public void writeLineToHtml(HtmlPWriter htmlPWriter) {
        htmlPWriter.printRawPrivateText("<p>".concat(toString()).concat("</p>"));
    }
}
