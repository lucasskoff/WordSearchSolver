import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A utility class to parse comma separated words and store data in approriate data structures.
 */
public class WordProcessor
{
    public List<String> parseStringAsArrayList(String inputString){
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
