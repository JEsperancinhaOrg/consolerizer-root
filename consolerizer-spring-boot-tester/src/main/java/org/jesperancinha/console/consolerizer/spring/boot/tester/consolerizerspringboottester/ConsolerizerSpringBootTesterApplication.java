package org.jesperancinha.console.consolerizer.spring.boot.tester.consolerizerspringboottester;

import org.jesperancinha.console.consolerizer.ConsolerizerColor;
import org.jesperancinha.console.consolerizer.ConsolerizerGraphs;
import org.jesperancinha.console.consolerizer.HtmlComposer;
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
}
