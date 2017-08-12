import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ControllerTest
{
	private HashMap<String, List<Point>> correctHashMap;
	@Before
	public void init(){
		correctHashMap = new HashMap<>();
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

	@Test
	public void CorrectHashMapLargeKata() {
		String filename = "resources/bigGridFromKata";
		Point[] correctPointsBones = {new Point(0, 6), new Point(0, 7), new Point(0, 8), new Point(0, 9), new Point(0, 10)};
		Point[] correctPointsKhan = {new Point(5, 9), new Point(5, 8), new Point(5, 7), new Point(5, 6)};
		Point[] correctPointsKirk = {new Point(4, 7), new Point(3, 7), new Point(2, 7), new Point(1, 7)};
		Point[] correctPointsScotty = {new Point(0, 5), new Point(1, 5), new Point(2, 5), new Point(3, 5), new Point(4, 5), new Point(5, 5)};
		Point[] correctPointsSpock = {new Point(2, 1), new Point(3,2), new Point(4, 3), new Point(5, 4), new Point(6,5)};
		Point[] correctPointsSulu = {new Point(3, 3), new Point(2, 2), new Point(1, 1), new Point(0, 0)};
		Point[] correctPointsUhura = {new Point(4, 0), new Point(3, 1), new Point(2, 2), new Point(1, 3), new Point(0, 4)};
		HashMap<String, List<Point>> kataHashMap = new HashMap<String, List<Point>>();
		kataHashMap.put("BONES", Arrays.asList(correctPointsBones));
		kataHashMap.put("KHAN", Arrays.asList(correctPointsKhan));
		kataHashMap.put("KIRK", Arrays.asList(correctPointsKirk));
		kataHashMap.put("SCOTTY", Arrays.asList(correctPointsScotty));
		kataHashMap.put("SPOCK", Arrays.asList(correctPointsSpock));
		kataHashMap.put("SULU", Arrays.asList(correctPointsSulu));
		kataHashMap.put("UHURA", Arrays.asList(correctPointsUhura));
		assertEquals(kataHashMap, Controller.wordSearchSolutionFromFile(filename));
	}
}
