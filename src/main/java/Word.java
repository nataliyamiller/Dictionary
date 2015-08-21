import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> instances = new ArrayList<Word>();

  public static void clear() {
    instances.clear();
  }

  private String mWord;
  private int mId;
  private ArrayList<Definition> mDefinitions; 

  public Word (String word) {
    mWord = word;
    instances.add(this);
    mDefinitions = new ArrayList<Definition>();
    mId = instances.size();
  }

  public String getWord() {
    return mWord;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Word> all() {
    return instances;
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }
}
