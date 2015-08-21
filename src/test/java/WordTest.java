import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void WordObjectConstructor_instantiatesCorrectly_true() {
    Word testWord = new Word ("Word");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getWord_returnsWord_true() {
    Word testWord = new Word ("Word");
    assertEquals("Word", testWord.getWord());
  }

  @Test
  public void getId_returnsWordId_true() {
    Word testWord = new Word ("Word");
    assertTrue(testWord.all().size() == testWord.getId());
  }
}
