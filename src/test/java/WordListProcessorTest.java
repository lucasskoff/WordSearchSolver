import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.text.RandomStringGenerator;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordListProcessorTest
{
    private WordListProcessor wordListProcessor;
    private List<String> wordList;
    private RandomStringGenerator randomStringGenerator;
    private Random rg;
    private String firstInputWord;
    private String secondInputWord;
    private String firstFileInputWord;
    private String secondFileInputWord;
    private File inputFileSingleWordThreeByThreeGrid;
    private File inputFileTwoWordsThreeByThreeGrid;

    @Before
    public void init(){
        wordList = new ArrayList<>();
        randomStringGenerator = new RandomStringGenerator.Builder().withinRange('A', 'Z').build();
        rg = new Random();
        firstInputWord = "Bones";
        secondInputWord = "Spock";
        firstFileInputWord = "DOG";
        secondFileInputWord = "CAT";
        inputFileSingleWordThreeByThreeGrid = new File("./resources/horizontalWordThreeByThreeGrid.txt");
        inputFileTwoWordsThreeByThreeGrid = new File("resources/horizontalWordsThreeByThreeGrid");
    }

    @Test
    public void ReadSingleWordFromStringAndStoreAsList(){
        wordList.add(firstInputWord);
        assertEquals(wordList, WordListProcessor.parseStringAsArrayList("Bones"));
    }

    @Test
    public void ReadTwoWordsFromStringSeparatedByCommaAndStoreAsList(){
        wordList.add(firstInputWord);
        wordList.add(secondInputWord);
        assertEquals(wordList, WordListProcessor.parseStringAsArrayList("Bones,Spock"));
    }

    @Test
    public void ReadAnyNumberOfWordsFromStringSeparatedByCommasAndStoreAsList(){
        int numberOfWordsToRead = rg.nextInt(12);
        StringBuilder inputLine = new StringBuilder();
        for(int i = 0; i < numberOfWordsToRead; i++){
            String randomWord = randomStringGenerator.generate(5);
            inputLine.append(randomWord).append(',');
            wordList.add(randomWord);
        }

        assertEquals(wordList, WordListProcessor.parseStringAsArrayList(inputLine.toString()));
    }

    @Test
    public void CreateHashMapWithCorrectNumberOfKeysFromWordListNoDuplicateWords(){
        wordList.add(firstInputWord);
        wordList.add(secondInputWord);
        assertEquals(wordList.size(), WordListProcessor.createHashMapOfWordFirstLetters(wordList).size());
    }

    @Test
    public void CreateHashMapWithCorrectNumberOfKeysFromWordListWithDuplicateWords(){
        wordList.add(firstInputWord);
        wordList.add(firstInputWord);
        assertNotEquals(wordList.size(), WordListProcessor.createHashMapOfWordFirstLetters(wordList).size());
    }

    @Test
    public void CreateHashMapWithEmptyListAsValue(){
        wordList.add(firstInputWord);
        List<Point> points = new ArrayList<>();
        assertEquals(points, WordListProcessor.createHashMapOfWordFirstLetters(wordList).get(firstInputWord.charAt(0)));
    }

    @Test
    public void ReadTopLineFromFileSingleWordAndCreateString(){
        assertEquals("DOG", WordListProcessor.readTopLineFromFileIntoString(inputFileSingleWordThreeByThreeGrid));
    }

    @Test
    public void ReadTopLineFromFileMultipleWordsAndCreateString(){
        assertEquals("DOG,CAT",WordListProcessor.readTopLineFromFileIntoString(inputFileTwoWordsThreeByThreeGrid));
    }

    @Test
    public void ReadTopLineFromFileAndReturnEmptyStringIfFileIsInvalid(){
        assertEquals(StringUtils.EMPTY, WordListProcessor.readTopLineFromFileIntoString(new File("notReal.txt")));
    }

    @Test
    public void ReadTopLineFromFileContainingSingleWordAndCreateList(){
        wordList.add("DOG");
        assertEquals(wordList, WordListProcessor.createArrayListOfWordsFromFileName("./resources/horizontalWordThreeByThreeGrid.txt"));
    }

    @Test
    public void ReadTopLineFromFileContainingMultipleWordsAndCreateList(){
        wordList.add("DOG");
        wordList.add("CAT");
        assertEquals(wordList, WordListProcessor.createArrayListOfWordsFromFileName("resources/horizontalWordsThreeByThreeGrid"));
    }
}
