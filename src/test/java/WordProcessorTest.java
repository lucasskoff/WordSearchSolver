import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.text.RandomStringGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Test
    public void ReadAnyNumberOfWordsFromStringSeperatedByCommasAndStoreAsList(){
        Random rg = new Random();
        int numberOfWordsToRead = rg.nextInt(12);
        RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
        String inputLine = StringUtils.EMPTY;
        for(int i = 0; i < numberOfWordsToRead; i++){
            String randomWord = randomStringGenerator.generate(5);
            inputLine = inputLine.concat(randomWord + ",");
            wordList.add(randomWord);
        }

        assertEquals(wordList, wordProcessor.parseStringAsArrayList(inputLine));
    }
}
