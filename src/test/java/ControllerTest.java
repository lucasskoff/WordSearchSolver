import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ControllerTest
{
	@Test
	public void CorrectHashMapFromSimpleThreeByThreeWithOneWord(){
		String filename = "resources/horizontalWordThreeByThreeGrid.txt";
		HashMap<String, List<Point>> correctHashMap = new HashMap<String, List<Point>>();
		Point[] correctPoints = {new Point(0,0), new Point(1,0), new Point(2,0)};
		correctHashMap.put("DOG", Arrays.asList(correctPoints));
		assertEquals(correctHashMap, Controller.wordSearchSolutionFromFile(filename));
	}

}
