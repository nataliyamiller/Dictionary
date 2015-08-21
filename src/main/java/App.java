import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
   staticFileLocation("/public");
    String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("definitions", request.session().attribute("definitions"));
    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("words/new", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/word-form.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/words", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("words", Word.all());
    model.put("template", "templates/words.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/words/:id/definitions/new", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    Word word = Word.find(Integer.parseInt(request.params(":id")));
    ArrayList<Definition> definitions = word.getDefinitions();
    model.put("word", word);
    model.put("definitions", definitions);
    model.put("template", "templates/word-definitions-form.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/words/:id", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    Word word = Word.find(Integer.parseInt(request.params(":id")));
    model.put("word", word);
    model.put("template", "templates/word.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("definitions/new", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/definition-form.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/definitions", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("definitions", Definition.all());
    model.put("template", "templates/definitions.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/definitions/:id", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    Definition definition = Definition.find(Integer.parseInt(request.params(":id")));
    model.put("definition", definition);
    model.put("template", "templates/definition.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());


  post("/definitions", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
    ArrayList<Definition> definitions = word.getDefinitions();

    if (definitions == null) {
      definitions = new ArrayList<Definition>();
      request.session().attribute("definitions", definitions);
    }

    String description = request.queryParams("description");
    Definition myDefinition = new Definition(description);
    word.addDefinition(myDefinition);

    model.put("word", word);
    model.put("template", "templates/word.vtl");
    return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  post("/words", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    String cName = request.queryParams("name");
    Word myWord = new Word(cName);
    model.put("word", myWord);
    model.put("template", "templates/success.vtl");
    return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
