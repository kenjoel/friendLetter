import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;

import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String girlfriend = request.queryParams("girlfriend");
            String message = request.queryParams("message");

            model.put("name", name);
            model.put("girlfriend", girlfriend);
            model.put("message", message);

            return new ModelAndView(model, "hello.hbs");

        }, new HandlebarsTemplateEngine());

        get("/photo", (request, response) -> {
            return new ModelAndView(new HashMap(), "photos.hbs");
        }, new HandlebarsTemplateEngine());

        get("/chlorine", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "chlorine.hbs");
        }, new HandlebarsTemplateEngine());

        get("/rectangles", (req, res) -> {
            //just for testing - make two new objects so we have something to retrieve
            Rectangle rectangle = new Rectangle(3,2);
            Rectangle otherRectangle = new Rectangle(12, 12);

            Map<String, ArrayList<Rectangle>> model = new HashMap<>();
            ArrayList myRectangleArrayList = rectangles.Rectangle.getAll();
            model.put("myRectangles", myRectangleArrayList);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }



}
