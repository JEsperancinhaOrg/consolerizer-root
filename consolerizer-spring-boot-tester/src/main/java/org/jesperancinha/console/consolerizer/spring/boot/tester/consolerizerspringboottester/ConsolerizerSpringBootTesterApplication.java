package org.jesperancinha.console.consolerizer.spring.boot.tester.consolerizerspringboottester;

import org.jesperancinha.console.consolerizer.ConsolerizerColor;
import org.jesperancinha.console.consolerizer.ConsolerizerGraphs;
import org.jesperancinha.console.consolerizer.HtmlPWriter;
import org.jesperancinha.console.consolerizer.HtmlizerLinks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SpringBootApplication
@Controller
public class ConsolerizerSpringBootTesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsolerizerSpringBootTesterApplication.class, args);
    }

    @RequestMapping("/")
    public  void writeHTMLTests(HttpServletResponse httpServletResponse) throws IOException {
        final PrintWriter writer = httpServletResponse.getWriter();
        writer.println(ConsolerizerColor.GREEN.getPBText("This is a test page for Consolerizer!"));
        writer.println(HtmlizerLinks.getYouTubeFrame("QPWUyAZZfK0"));
        writer.println(ConsolerizerColor.DARK_GREY.getPBEscapedText("This is a wonderfull day!"));
        writer.println(HtmlizerLinks.getYouTubeFrame("rnHVIuBlAUo", 100,100));
        ConsolerizerGraphs.printRainbowFlag("!!WELCOME!!", new HtmlPWriter(writer));
    }
}
