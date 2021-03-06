package org.jesperancinha.console.consolerizer.spring.boot.tester.consolerizerspringboottester;

import org.jesperancinha.console.consolerizer.ConsolerizerColor;
import org.jesperancinha.console.consolerizer.ConsolerizerGraphs;
import org.jesperancinha.console.consolerizer.HtmlComposer;
import org.jesperancinha.console.consolerizer.HtmlPWriter;
import org.jesperancinha.console.consolerizer.HtmlizerLinks;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class TestControllerJava8 {
    @RequestMapping("/java8")
    public  void writeHTMLTestsJava8(HttpServletResponse httpServletResponse) throws IOException {
        final PrintWriter writer = httpServletResponse.getWriter();
        writer.println(ConsolerizerColor.BLUE.getPBText("You are now testing Java 8"));
        writer.println(ConsolerizerColor.GREEN.getPBText("This is a test page for Consolerizer!"));
        writer.println(HtmlizerLinks.getYouTubeFrame("QPWUyAZZfK0"));
        writer.println(ConsolerizerColor.DARK_GREY.getPBEscapedText("This is a wonderfull day!"));
        writer.println(HtmlizerLinks.getYouTubeFrame("rnHVIuBlAUo", 100,100));
        final HtmlPWriter consolerizerWriter = new HtmlPWriter(writer);
        HtmlComposer.out(" ").black("This").red("is").green("how").orange("we").yellow("do").cyan("it").magenta(".").writeLineToHtml(consolerizerWriter);
        writer.println(org.jesperancinha.console.consolerizer8.HtmlizerLinks.getYouTubeFrame("0hiUuL5uTKc", 500,100));
        ConsolerizerGraphs.printRainbowFlag("!!WELCOME!!", consolerizerWriter);
    }
}
