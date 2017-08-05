import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * A utility class to parse comma separated words and store data in approriate data structures.
 */
class WordListProcessor
{
    HashMap<Character, List<Point>> createHashMapFromFile(File file){
        List<String> wordList = createArrayListOfWordsFromFile(file);
        return createHashMapOfWordFirstLetters(wordList);
    }

    List<String> createArrayListOfWordsFromFile(File file){
        String wordList = readTopLineFromFileIntoString(file);
        return parseStringAsArrayList(wordList);
    }

    /**
     * Takes in text file as input and outputs a string containing the first line of the input file.
     * Handles FileNotFound by returning empty string.
     */
    String readTopLineFromFileIntoString(File file){
        try {
            Scanner scanner = new Scanner(file);
            return scanner.nextLine();
        }catch(FileNotFoundException e){
            return StringUtils.EMPTY;
        }

    }

    /**
     * Creates a hashmap where key is first letter of each word in the word list and
     * value is an empty List of points to be later filled with the position of each letter in grid.
     * @return HashMap where Character -> empty List<Point>
     */
    HashMap<Character, List<Point>> createHashMapOfWordFirstLetters(List<String> wordList){
        HashMap<Character, List<Point>> firstLetterPositions = new HashMap<>();
        for(String word : wordList){
            firstLetterPositions.put(word.charAt(0), new ArrayList<>());
        }
        return firstLetterPositions;
    }

    /**
     * Parses a string of comma separated words into an ArrayList<String>
     * @return ArrayList<String> containing each word
     */
    List<String> parseStringAsArrayList(String inputString){
        Scanner scanner = new Scanner(inputString);
        scanner.useDelimiter(",");
        List<String> wordList = new ArrayList<>();
        while(scanner.hasNext()){
            wordList.add(scanner.next());
        }
        scanner.close();
        return wordList;
    }
}
