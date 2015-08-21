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

  @Test
  public void getDefinitions_initiallyReturnsEmptyArrayList_true() {
    Word testWord = new Word ("Word");
    assertTrue(testWord.getDefinitions() instanceof ArrayList);
  }

  @Test
  public void all_returnsAllInstancesofDefinitions_true() {
    Word firstWord = new Word ("Word");
    Word secondWord = new Word ("Sentence");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void clear_removesAllInstancesOfWordFromMemory_true() {
    Word testWord = new Word ("Word");
    Word.clear();
    assertTrue(Word.all().size() == 0);
  }

  @Test
  public void find_returnsWordWithSameId() {
    Word testWord = new Word ("Word");
    assertEquals(Word.find(testWord.getId()), testWord);
  }

  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    Word testWord = new Word ("Word");
    assertTrue(Word.find(1000) == null);
  }

}
