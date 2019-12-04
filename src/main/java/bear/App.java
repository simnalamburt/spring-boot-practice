package bear;

import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

@RestController
class MainController {
    private static int counter = 0;

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index", Map.of("counter", counter));
    }

    @PostMapping("/roar")
    public String roar() {
        return String.format("%d", ++counter);
    }
}
