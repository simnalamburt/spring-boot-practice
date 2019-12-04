import com.google.common.collect.ImmutableMap;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import static spark.Spark.*;

public class App {
    private static long counter = 0;

    public static void main(String[] args) {
        staticFileLocation("public");

        get("/", (req, res) -> {
            return new ModelAndView(ImmutableMap.of("counter", counter), "index.mustache");
        }, new MustacheTemplateEngine());

        post("/roar", (req, res) -> String.format("%d", ++counter));

        System.out.println("\n\nSee \u001B[33mhttp://localhost:4567\u001B[0m\n\n");
    }
}
