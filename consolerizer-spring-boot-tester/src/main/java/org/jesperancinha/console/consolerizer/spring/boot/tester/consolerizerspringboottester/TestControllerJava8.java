package org.jesperancinha.console.consolerizer.spring.boot.tester.consolerizerspringboottester;

import jakarta.servlet.http.HttpServletResponse;
import org.jesperancinha.console.consolerizer8.common.ConsolerizerColor;
import org.jesperancinha.console.consolerizer8.console.ConsolerizerGraphs;
import org.jesperancinha.console.consolerizer8.html.HtmlComposer;
import org.jesperancinha.console.consolerizer8.html.HtmlPWriter;
import org.jesperancinha.console.consolerizer8.html.HtmlizerLinks;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer8.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer8.common.ConsolerizerColor.DARK_GREY;
import static org.jesperancinha.console.consolerizer8.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer8.common.ConsolerizerColor.MAGENTA;

@RestController
public class TestControllerJava8 {
    @RequestMapping("/java8")
    public void writeHTMLTestsJava8(HttpServletResponse httpServletResponse) throws IOException {
        final PrintWriter writer = httpServletResponse.getWriter();
        writer.println(BLUE.getPBText("You are now testing Java 8"));
        writer.println(ConsolerizerColor.GREEN.getPBText("This is a test page for Consolerizer!"));
        writer.println(HtmlizerLinks.getYouTubeFrame("QPWUyAZZfK0"));
        writer.println(DARK_GREY.getPBEscapedText("This is a wonderfull day!"));
        writer.println(HtmlizerLinks.getYouTubeFrame("rnHVIuBlAUo", 100, 100));
        final HtmlPWriter consolerizerWriter = new HtmlPWriter(writer);
        HtmlComposer.out(" ").black("This").red("is").green("how").orange("we").yellow("do").cyan("it").magenta(".").writeLineToHtml(consolerizerWriter);
        writer.println(HtmlizerLinks.getYouTubeFrame("0hiUuL5uTKc", 500, 100));
        ConsolerizerGraphs.printRainbowFlag("!!WELCOME!!", consolerizerWriter);
        writer.println(GREEN.getAnchorLink("Maine Coons", "https://www.youtube.com/watch?v=weebcQPRGUE"));
        writer.println(BLUE.getAnchorLink("Maine Coons", "https://www.youtube.com/watch?v=weebcQPRGUE"));
        writer.println(MAGENTA.getAnchorLink("Maine Coons", "https://www.youtube.com/watch?v=weebcQPRGUE"));

    }
}
