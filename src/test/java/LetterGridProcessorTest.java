import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterGridProcessorTest
{
	private String inputLine = "D,O,G";
	private char[][] threeByThreeSolutionArray = {{'D','O','G'},{'C','A','T'},{'R','A','T'}};
	private char[][] fourByFourSolutionArray = {{'F','O','R','K'},{'E','Y','W','Z'},{'G','O','T','O'},{'H','D','A','E'}};
	private char[][] allLettersDArray = {{'D','D','D'},{'D','D','D'},{'D','D','D'}};
	private char[] oneDSolutionArray = {'D','O','G'};
	private char[][] bigGridFromKata = {
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
	private HashMap<Character, java.util.List<Point>> threeByThreeMap;
	private HashMap<Character, java.util.List<Point>> fourByFourMap;
	private HashMap<Character, List<Point>> allLettersDMap;
	private String threeByThreeFileName;
	private String fourByFourFileName;
	private String bigKataFileName;

	@Before
	public void Init(){
		threeByThreeFileName = "resources/horizontalWordsThreeByThreeGrid";
		fourByFourFileName = "resources/horizontalWordsFourByFourGrid.txt";
		bigKataFileName = "resources/bigGridFromKata";
		threeByThreeMap = WordListProcessor.createHashMapOfWordFirstLetters(WordListProcessor.createArrayListOfWordsFromFileName(threeByThreeFileName));
		fourByFourMap = WordListProcessor.createHashMapOfWordFirstLetters(WordListProcessor.createArrayListOfWordsFromFileName(fourByFourFileName));
		allLettersDMap = WordListProcessor.createHashMapOfWordFirstLetters(WordListProcessor.createArrayListOfWordsFromFileName("resources/threeByThreegridWhereEveryLetterIsD"));
	}

	@Test
	public void ThreeByThreeGridFromFileOutputs2DArrayOfCorrectSize(){
		assertEquals(threeByThreeSolutionArray.length, LetterGridProcessor.parseGridFromFileAsCharArray("resources/horizontalWordsThreeByThreeGrid").length);
	}

	@Test
	public void FourByFourGridFromFileOutputs2DArrayOfCorrectSize(){
		assertEquals(fourByFourSolutionArray.length, LetterGridProcessor.parseGridFromFileAsCharArray(fourByFourFileName).length);
	}

	@Test
	public void BigGridFromKataOutputs2DArrayOfCorrectSize(){
		assertEquals(bigGridFromKata.length, LetterGridProcessor.parseGridFromFileAsCharArray(bigKataFileName).length);
	}

	@Test
	public void InvalidFileCreates2DArrayOfLengthZero(){
		assertEquals(0, LetterGridProcessor.parseGridFromFileAsCharArray("invalidFile").length);
	}

	@Test
	public void InvalidNumberOfRowsAreIgnored(){
		assertArrayEquals(threeByThreeSolutionArray, LetterGridProcessor.parseGridFromFileAsCharArray("resources/3x4GridWithMoreColumnsThanRows"));
	}

	@Test
	public void ParseStringInto1DCharArray(){
		assertArrayEquals(oneDSolutionArray, LetterGridProcessor.parseStringIntoCharArray(inputLine, 3));
	}

	@Test
	public void ParseStringWithMoreLettersThanWidthIntoCharArray(){
		inputLine += ",O";
		assertArrayEquals(oneDSolutionArray, LetterGridProcessor.parseStringIntoCharArray(inputLine, 3));
	}

	@Test
	public void ThreeByThreeGridFromFileOutputsCorrect2DCharArray(){
		assertArrayEquals(threeByThreeSolutionArray, LetterGridProcessor.parseGridFromFileAsCharArray(threeByThreeFileName));
	}

	@Test
	public void FourByFourGridFromFileOutputsCorrect2DCharArray(){
		assertArrayEquals(fourByFourSolutionArray, LetterGridProcessor.parseGridFromFileAsCharArray(fourByFourFileName));
	}

	@Test
	public void BigGridFromKataFileOutputsCorrect2DCharArray(){
		assertArrayEquals(bigGridFromKata, LetterGridProcessor.parseGridFromFileAsCharArray(bigKataFileName));
	}

	@Test
	public void SizeOfHashMapValueListForLetterDFromSimple3x3Grid(){
		assertEquals(1, LetterGridProcessor.populateHashMapListOfPointsFirstLetter(threeByThreeMap, threeByThreeSolutionArray).get('D').size());
	}

	@Test
	public void PointsInHashMapValueListAreCorrectForSimple3x3Grid(){
		List<Point> correctPoints = new ArrayList<>();
		correctPoints.add(new Point(0,0));
		assertEquals(correctPoints, LetterGridProcessor.populateHashMapListOfPointsFirstLetter(threeByThreeMap, threeByThreeSolutionArray).get('D'));
	}

	@Test
	public void SizeOfHashMapValueListFor4x4Grid(){
		HashMap<Character, List<Point>> defendantMap = LetterGridProcessor.populateHashMapListOfPointsFirstLetter(fourByFourMap, fourByFourSolutionArray);
		assertEquals(2, defendantMap.get('F').size() + defendantMap.get('G').size());
	}

	@Test
	public void PointsInHashMapAreCorrectFor4x4Grid(){
		assertEquals(initializeFourByFourHashMap(), LetterGridProcessor.populateHashMapListOfPointsFirstLetter(fourByFourMap, fourByFourSolutionArray));
	}

	@Test
	public void PointsInHashMapAreCorrectWhenAllLettersAreD(){
		HashMap<Character, List<Point>> correctHashMap = new HashMap<>();
		Point[] correctPoints = {new Point(0,0), new Point(1,0), new Point(2, 0),
								 new Point(0, 1), new Point(1, 1), new Point(2, 1),
								 new Point(0, 2), new Point(1, 2), new Point(2, 2)};
		correctHashMap.put('D', Arrays.asList(correctPoints));
		assertEquals(correctHashMap, LetterGridProcessor.populateHashMapListOfPointsFirstLetter(allLettersDMap, allLettersDArray));
	}

	private HashMap<Character, List<Point>> initializeFourByFourHashMap(){
		HashMap<Character, List<Point>> correctHashMap = new HashMap<>();
		List<Point> pointsForFork = new ArrayList<>();
		pointsForFork.add(new Point(0, 0));
		List<Point> pointsForGoto = new ArrayList<>();
		pointsForGoto.add(new Point(0, 2));
		correctHashMap.put('F', pointsForFork);
		correctHashMap.put('G', pointsForGoto);
		return correctHashMap;
	}
}