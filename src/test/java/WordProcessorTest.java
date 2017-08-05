import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class WordProcessorTest
{
    WordProcessor wordProcessor;
    List<String> wordList;
    @Before
    public void init(){
        wordProcessor = new WordProcessor();
        wordList = new ArrayList<>();
    }

    @Test
    public void ReadSingleWordFromStringAndStoreAsList(){
        wordList.add("Bones");
        assertEquals(wordList, wordProcessor.parseStringAsArrayList("Bones"));
    }

    @Test
    public void ReadTwoWordsFromStringSeparatedByCommaAndStoreAsList(){
        wordList.add("Bones");
        wordList.add("Spock");
        assertEquals(wordList, wordProcessor.parseStringAsArrayList("Bones,Spock"));
    }
}
