import java.util.concurrent.ConcurrentHashMap;
import com.google.common.collect.ImmutableMap;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import static spark.Spark.*;

public class App {
    private static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(1);

    public static void main(String[] args) {
        staticFileLocation("public");

        get("/", (req, res) -> {
            // Intentionally wrote a poor code to test Amazon CodeGuru
            int counter;
            if (map.containsKey("counter")) {
                counter = map.get("counter");
            } else {
                map.put("counter", 0);
                counter = 0;
            }

            return new ModelAndView(ImmutableMap.of("counter", counter), "index.mustache");
        }, new MustacheTemplateEngine());

        post("/roar", (req, res) -> {
            // Intentionally wrote a poor code to test Amazon CodeGuru
            int counter;
            if (map.containsKey("counter")) {
                counter = map.get("counter");
                ++counter;
                map.put("counter", counter);
            } else {
                map.put("counter", 1);
                counter = 1;
            }

            return String.format("%d", counter);
        });

        System.out.println("\n\nSee \u001B[33mhttp://localhost:4567\u001B[0m\n\n");
    }
}
