import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.text.RandomStringGenerator;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordProcessorTest
{
    private WordProcessor wordProcessor;
    private List<String> wordList;
    private RandomStringGenerator randomStringGenerator;
    private Random rg;
    private String firstInputWord;
    private String secondInputWord;

    @Before
    public void init(){
        wordProcessor = new WordProcessor();
        wordList = new ArrayList<>();
        randomStringGenerator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
        rg = new Random();
        firstInputWord = "Bones";
        secondInputWord = "Spock";
    }

    @Test
    public void ReadSingleWordFromStringAndStoreAsList(){
        wordList.add(firstInputWord);
        assertEquals(wordList, wordProcessor.parseStringAsArrayList("Bones"));
    }

    @Test
    public void ReadTwoWordsFromStringSeparatedByCommaAndStoreAsList(){
        wordList.add(firstInputWord);
        wordList.add(secondInputWord);
        assertEquals(wordList, wordProcessor.parseStringAsArrayList("Bones,Spock"));
    }

    @Test
    public void ReadAnyNumberOfWordsFromStringSeparatedByCommasAndStoreAsList(){
        int numberOfWordsToRead = rg.nextInt(12);
        String inputLine = StringUtils.EMPTY;
        for(int i = 0; i < numberOfWordsToRead; i++){
            String randomWord = randomStringGenerator.generate(5);
            inputLine = inputLine.concat(randomWord + ",");
            wordList.add(randomWord);
        }

        assertEquals(wordList, wordProcessor.parseStringAsArrayList(inputLine));
    }

    @Test
    public void CreateHashMapWithCorrectNumberOfKeysFromWordListNoDuplicateWords(){
        wordList.add(firstInputWord);
        wordList.add(secondInputWord);
        assertEquals(wordList.size(), wordProcessor.createHashMapOfWordFirstLetters(wordList).size());
    }
}
