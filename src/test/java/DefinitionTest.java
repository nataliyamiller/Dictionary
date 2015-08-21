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

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition firstDefinition = new Definition("a unit of language, consisting of one or more spoken sounds.");
    Definition secondDefinition = new Definition("a grammatical unit of one or more words that expresses an independent statement.");
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void newId_definitionsInstantiateWithAnID_true() {
    Definition testDefinition = new Definition ("a unit of language, consisting of one or more spoken sounds.");
    assertEquals(Definition.all().size(), testDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_secondDefinition() {
    Definition firstDefinition = new Definition("a unit of language, consisting of one or more spoken sounds.");
    Definition secondDefinition = new Definition("a grammatical unit of one or more words that expresses an independent statement.");
    assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
  }


  @Test
  public void find_returnsNullWhenNoDefinitionFound_null() {
    assertTrue(Definition.find(1000) == null);
  }

  @Test
  public void clear_emptiesAllDefinitionsFromArrayList() {
    Definition testDefinition = new Definition("a unit of language, consisting of one or more spoken sounds.n");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }
}
