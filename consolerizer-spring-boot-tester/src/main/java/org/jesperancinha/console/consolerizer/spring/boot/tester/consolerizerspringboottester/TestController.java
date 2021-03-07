package org.jesperancinha.console.consolerizer.spring.boot.tester.consolerizerspringboottester;

import org.jesperancinha.console.consolerizer.html.HtmlComposer;
import org.jesperancinha.console.consolerizer.html.HtmlPWriter;
import org.jesperancinha.console.consolerizer8.common.ConsolerizerColor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.DARK_GREY;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs.printRainbowFlag;
import static org.jesperancinha.console.consolerizer.html.HtmlizerLinks.getYouTubeFrame;
import static org.jesperancinha.console.consolerizer8.common.ConsolerizerColor.MAGENTA;

@RestController
public class TestController {

    @RequestMapping("/")
    public void writeHTMLTests(HttpServletResponse httpServletResponse) throws IOException {
        final PrintWriter writer = httpServletResponse.getWriter();
        writer.println(BLUE.getPBText("You are now testing Java 11 and above"));
        writer.println(GREEN.getPBText("This is a test page for Consolerizer!"));
        writer.println(getYouTubeFrame("QPWUyAZZfK0"));
        writer.println(DARK_GREY.getPBEscapedText("This is a wonderfull day!"));
        writer.println(getYouTubeFrame("rnHVIuBlAUo", 100, 100));
        final HtmlPWriter consolerizerWriter = new HtmlPWriter(writer);
        HtmlComposer.out(" ").black("This").red("is").green("how").orange("we").yellow("do").cyan("it").magenta(".").writeLineToHtml(consolerizerWriter);
        writer.println(getYouTubeFrame("0hiUuL5uTKc", 500, 100));
        printRainbowFlag("!!WELCOME!!", consolerizerWriter);
        writer.println(GREEN.getAnchorLink("Maine Coons", "https://www.youtube.com/watch?v=weebcQPRGUE"));
        writer.println(ConsolerizerColor.BLUE.getAnchorLink("Maine Coons", "https://www.youtube.com/watch?v=weebcQPRGUE"));
        writer.println(MAGENTA.getAnchorLink("Maine Coons", "https://www.youtube.com/watch?v=weebcQPRGUE"));
    }
}
