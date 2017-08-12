import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ControllerTest
{
	HashMap<String, List<Point>> correctHashMap;
	@Before
	public void init(){
		correctHashMap = new HashMap<String, List<Point>>();
		Point[] correctPoints = {new Point(0,0), new Point(1,0), new Point(2,0)};
		correctHashMap.put("DOG", Arrays.asList(correctPoints));
	}

	@Test
	public void CorrectHashMapFromSimpleThreeByThreeWithOneWord(){
		String filename = "resources/horizontalWordThreeByThreeGrid.txt";
		assertEquals(correctHashMap, Controller.wordSearchSolutionFromFile(filename));
	}

	@Test
	public void CorrectHashMapForTwoHorizontalWords(){
		String filename = "resources/horizontalWordsThreeByThreeGrid";
		Point[] correctPointsCat = {new Point(0, 1), new Point(1,1), new Point(2,1)};
		correctHashMap.put("CAT", Arrays.asList(correctPointsCat));
		assertEquals(correctHashMap, Controller.wordSearchSolutionFromFile(filename));
	}

	@Test
	public void CorrectHashMapForTwoWordHorizontalAndVertical(){
		String filename = "resources/horizontalAndVerticalWordsFourByFour.txt";
		Point[] correctPointsCat = {new Point(0,1), new Point(0,2), new Point(0, 3)};
		correctHashMap.put("CAT", Arrays.asList(correctPointsCat));
		assertEquals(correctHashMap, Controller.wordSearchSolutionFromFile(filename));
	}

	@Test
	public void CorrectHashMapForGridWithTwoLettersOutOfOneLetter(){
		String filename = "resources/horizontalAndVerticalWordComingFromSameLetter.txt";
		Point[] correctPointsDonut = {new Point(0,0), new Point(0, 1), new Point(0, 2), new Point(0,3), new Point(0,4)};
		correctHashMap.put("DONUT", Arrays.asList(correctPointsDonut));
		assertEquals(correctHashMap, Controller.wordSearchSolutionFromFile(filename));
	}
}
