import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void DefinitionObjectConstructor_instantiatesCorrectly_true() {
    Definition testDefinition = new Definition ("a unit of language, consisting of one or more spoken sounds");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void Definition_instantiatesWithDescription_true() {
    Definition testDefinition = new Definition("a unit of language, consisting of one or more spoken sounds");
    assertEquals("a unit of language, consisting of one or more spoken sounds", testDefinition.getDescription());
  }


}
