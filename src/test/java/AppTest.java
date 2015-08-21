import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;


public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Your Custom Dictionary!");
  }

  @Test
  public void word_isCreated_test() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a new word to your dictionary"));
    fill("#name").with("Sentence");
    submit(".btn");
    assertThat(pageSource().contains("Your word has been saved!"));
  }

  @Test
  public void word_isDisplayed_test() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Sentence");
    submit(".btn");
    click("a", withText("View your words"));
    assertThat(pageSource()).contains("View your words");
  }

  @Test
  public void wordDefinitionsForm_isDisplayed_test() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Sentence");
    submit(".btn");
    click("a", withText("View your words"));
    click("a", withText("Sentence"));
    click("a", withText("Add a definition"));
    assertThat(pageSource().contains("Add a definition"));
  }

  @Test
  public void definition_isAddedToWordAndDisplayed_test(){
    goTo("http://localhost:4567/words/new");
    fill("#name").with("Sentence");
    submit(".btn");
    click("a", withText("View your words"));
    click("a", withText("Sentence"));
    click("a", withText("Add a definition"));
    fill("#description").with("a grammatical unit of one or more words that expresses an independent statement.");
    submit(".btn");
    assertThat(pageSource()).contains("a grammatical unit of one or more words that expresses an independent statement.");
  }

}
