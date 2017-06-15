import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        get("/", (req, res) -> "Hello World");

        System.out.println("\n\nSee \u001B[33mhttp://localhost:4567\u001B[0m\n\n");
    }
}
