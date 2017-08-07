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
	private PublicTestObjects publicTestObjects;

	@Before
	public void Init(){
		publicTestObjects = new PublicTestObjects();
	}

	@Test
	public void ThreeByThreeGridFromFileOutputs2DArrayOfCorrectSize(){
		assertEquals(publicTestObjects.threeByThreeSolutionArray.length, LetterGridProcessor.parseGridFromFileAsCharArray(publicTestObjects.threeByThreeFile).length);
	}

	@Test
	public void FourByFourGridFromFileOutputs2DArrayOfCorrectSize(){
		assertEquals(publicTestObjects.fourByFourSolutionArray.length, LetterGridProcessor.parseGridFromFileAsCharArray(publicTestObjects.fourByFourFile).length);
	}

	@Test
	public void BigGridFromKataOutputs2DArrayOfCorrectSize(){
		assertEquals(publicTestObjects.bigGridFromKata.length, LetterGridProcessor.parseGridFromFileAsCharArray(publicTestObjects.bigGridFromKataFile).length);
	}

	@Test
	public void InvalidFileCreates2DArrayOfLengthZero(){
		assertEquals(0, LetterGridProcessor.parseGridFromFileAsCharArray(new File("invalidFile")).length);
	}

	@Test
	public void InvalidNumberOfRowsAreIgnored(){
		File invalidNumberOfRows = new File("resources/3x4GridWithMoreColumnsThanRows");
		assertEquals(publicTestObjects.threeByThreeSolutionArray, LetterGridProcessor.parseGridFromFileAsCharArray(invalidNumberOfRows));
	}

	@Test
	public void ParseStringInto1DCharArray(){
		assertArrayEquals(publicTestObjects.oneDSolutionArray, LetterGridProcessor.parseStringIntoCharArray(publicTestObjects.inputLine, 3));
	}

	@Test
	public void ParseStringWithMoreLettersThanWidthIntoCharArray(){
		publicTestObjects.inputLine += ",O";
		assertArrayEquals(publicTestObjects.oneDSolutionArray, LetterGridProcessor.parseStringIntoCharArray(publicTestObjects.inputLine, 3));
	}

	@Test
	public void ThreeByThreeGridFromFileOutputsCorrect2DCharArray(){
		assertArrayEquals(publicTestObjects.threeByThreeSolutionArray, LetterGridProcessor.parseGridFromFileAsCharArray(publicTestObjects.threeByThreeFile));
	}

	@Test
	public void FourByFourGridFromFileOutputsCorrect2DCharArray(){
		assertArrayEquals(publicTestObjects.fourByFourSolutionArray, LetterGridProcessor.parseGridFromFileAsCharArray(publicTestObjects.fourByFourFile));
	}

	@Test
	public void BigGridFromKataFileOutputsCorrect2DCharArray(){
		assertArrayEquals(publicTestObjects.bigGridFromKata, LetterGridProcessor.parseGridFromFileAsCharArray(publicTestObjects.bigGridFromKataFile));
	}

	@Test
	public void SizeOfHashMapValueListForLetterDFromSimple3x3Grid(){
		assertEquals(1, LetterGridProcessor.populateHashMapListOfPointsFirstLetter(publicTestObjects.threeByThreeMap, publicTestObjects.threeByThreeSolutionArray).get('D').size());
	}

	@Test
	public void PointsInHashMapValueListAreCorrectForSimple3x3Grid(){
		List<Point> correctPoints = new ArrayList<>();
		correctPoints.add(new Point(0,0));
		assertEquals(correctPoints, LetterGridProcessor.populateHashMapListOfPointsFirstLetter(publicTestObjects.threeByThreeMap, publicTestObjects.threeByThreeSolutionArray).get('D'));
	}

	@Test
	public void SizeOfHashMapValueListFor4x4Grid(){
		HashMap<Character, List<Point>> defendantMap = LetterGridProcessor.populateHashMapListOfPointsFirstLetter(publicTestObjects.fourByFourMap, publicTestObjects.fourByFourSolutionArray);
		assertEquals(2, defendantMap.get('F').size() + defendantMap.get('G').size());
	}

	@Test
	public void PointsInHashMapAreCorrectFor4x4Grid(){
		assertEquals(initializeFourByFourHashMap(), LetterGridProcessor.populateHashMapListOfPointsFirstLetter(publicTestObjects.fourByFourMap, publicTestObjects.fourByFourSolutionArray));
	}

	@Test
	public void PointsInHashMapAreCorrectWhenAllLettersAreD(){
		HashMap<Character, List<Point>> correctHashMap = new HashMap<>();
		Point[] correctPoints = {new Point(0,0), new Point(1,0), new Point(2, 0),
								 new Point(0, 1), new Point(1, 1), new Point(2, 1),
								 new Point(0, 2), new Point(1, 2), new Point(2, 2)};
		correctHashMap.put('D', Arrays.asList(correctPoints));
		assertEquals(correctHashMap, LetterGridProcessor.populateHashMapListOfPointsFirstLetter(publicTestObjects.allLettersDMap, publicTestObjects.allLettersDArray));
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