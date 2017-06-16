import com.google.common.collect.ImmutableMap;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import static spark.Spark.*;

public class App {
    private static long counter = 0;

    public static void main(String[] args) {
        staticFileLocation("public");

        get("/", (req, res) -> {
            counter += 1;

            return new ModelAndView(ImmutableMap.of(
                        "counter", counter),
                    "index.mustache");
        }, new MustacheTemplateEngine());

        System.out.println("\n\nSee \u001B[33mhttp://localhost:4567\u001B[0m\n\n");
    }
}
