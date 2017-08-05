import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class WordProcessorTest
{
    @Test
    public void ReadSingleWordFromStringAndStoreAsList(){
        WordProcessor wordProcessor = new WordProcessor();
        List<String> wordList = new ArrayList<>();
        wordList.add("Bones");
        assertEquals(wordList, wordProcessor.parseStringAsArrayList("Bones"));
    }
}
