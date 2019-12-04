import java.util.Arrays;
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

        // "input" is list of string deliminated with comma (,)
        // Example:
        //   a,d,b,e,c
        //   dog,cat,bear
        //
        // It returns sorted list of "input"
        // Example:
        //   a,b,c,d,e
        //   bear,cat,dog
        get("/sort/:input", (req, res) -> {
            var input = req.params(":input");
            var words = input.split(",");

            // NOTE: Intentionally written in poor bubble sort to test Amazon CodeGuru
            var len = words.length;
            for (var i = 0; i < len-1; i++) {
                for (var j = 0; j < len-i-1; j++) {
                    if (words[j].compareTo(words[j+1]) > 0) {
                        var tmp = words[j];
                        words[j] = words[j+1];
                        words[j+1] = tmp;
                    }
                }
            }

            return String.join(",", words);
        });

        System.out.println("\n\nSee \u001B[33mhttp://localhost:4567\u001B[0m\n\n");
    }
}
