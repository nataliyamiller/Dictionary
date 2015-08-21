import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void WordObjectConstructor_instantiatesCorrectly_true() {
    Word testWord = new Word ("Word");
    assertEquals(true, testWord instanceof Word);
  }



}
