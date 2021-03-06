package org.jesperancinha.console.consolerizer.spring.boot.tester.consolerizerspringboottester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class ConsolerizerSpringBootTesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsolerizerSpringBootTesterApplication.class, args);
    }
}
