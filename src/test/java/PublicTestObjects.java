import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class PublicTestObjects
{
	public File threeByThreeFile;
	public File fourByFourFile;
	public File bigGridFromKataFile;
	public File gridWhereAllLettersAreDFile;
	public String inputLine = "D,O,G";
	public char[][] threeByThreeSolutionArray = {{'D','O','G'},{'C','A','T'},{'R','A','T'}};
	public char[][] fourByFourSolutionArray = {{'F','O','R','K'},{'E','Y','W','Z'},{'G','O','T','O'},{'H','D','A','E'}};
	public char[][] allLettersDArray = {{'D','D','D'},{'D','D','D'},{'D','D','D'}};
	public char[] oneDSolutionArray = {'D','O','G'};
	public char[][] bigGridFromKata = {
			{'U','M','K','H','U','L','K','I','N','V','J','O','C','W','E'},
			{'L','L','S','H','K','Z','Z','W','Z','C','G','J','U','Y','G'},
			{'H','S','U','P','J','P','R','J','D','H','S','B','X','T','G'},
			{'B','R','J','S','O','E','Q','E','T','I','K','K','G','L','E'},
			{'A','Y','O','A','G','C','I','R','D','Q','H','R','T','C','D'},
			{'S','C','O','T','T','Y','K','Z','R','E','P','P','X','P','F'},
			{'B','L','Q','S','L','N','E','E','E','V','U','L','F','M','Z'},
			{'O','K','R','I','K','A','M','M','R','M','F','B','A','P','P'},
			{'N','U','I','I','Y','H','Q','M','E','M','Q','R','Y','F','S'},
			{'E','Y','Z','Y','G','K','Q','J','P','C','Q','W','Y','A','K'},
			{'S','J','F','Z','M','Q','I','B','D','B','E','M','K','W','D'},
			{'T','G','L','B','H','C','B','E','C','H','T','O','Y','I','K'},
			{'O','J','Y','E','U','L','N','C','C','L','Y','B','Z','U','H'},
			{'W','Z','M','I','S','U','K','U','R','B','I','D','U','X','S'},
			{'K','Y','L','B','Q','Q','P','M','D','F','C','K','E','A','B'}};
	public HashMap<Character, java.util.List<Point>> threeByThreeMap;
	public HashMap<Character, java.util.List<Point>> fourByFourMap;
	public HashMap<Character, List<Point>> allLettersDMap;

	public PublicTestObjects(){
		threeByThreeFile = new File("resources/horizontalWordsThreeByThreeGrid");
		fourByFourFile = new File("resources/horizontalWordsFourByFourGrid.txt");
		bigGridFromKataFile = new File("resources/bigGridFromKata");
		gridWhereAllLettersAreDFile = new File("resources/threeByThreegridWhereEveryLetterIsD");
		threeByThreeMap = WordListProcessor.createHashMapOfWordFirstLetters(WordListProcessor.createArrayListOfWordsFromFile(threeByThreeFile));
		fourByFourMap = WordListProcessor.createHashMapOfWordFirstLetters(WordListProcessor.createArrayListOfWordsFromFile(fourByFourFile));
		allLettersDMap = WordListProcessor.createHashMapOfWordFirstLetters(WordListProcessor.createArrayListOfWordsFromFile(gridWhereAllLettersAreDFile));
	}
}
