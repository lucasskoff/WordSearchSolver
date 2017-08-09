import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class WordSearchSolverTest
{
	private char[][] threeByThreeSolutionArray = {{'D','O','G'},{'C','A','T'},{'R','A','T'}};
	@Test
	public void ReturnPointsOfHorizontalWordDogInSimpleThreeByThree(){
		Point[] correctPointsDogArray = {new Point(0,0), new Point(1,0), new Point(2,0)};
		List<Point> correctPointsList = Arrays.asList(correctPointsDogArray);
		//public boolean wordFinder(Direction direction, Point firstLetterPoint, String wordToFind, char[][] letterGrid, List<Point> populatedList)
		List<Point> pointsToTest = new ArrayList<Point>();
		if(WordSearchSolver.wordFinder(Direction.Horizontal, new Point(0,0), "Dog", threeByThreeSolutionArray, pointsToTest))
		{
			assertEquals(correctPointsList, pointsToTest);
		}else {
			Assert.fail("Incapable of finding word in test ReturnPointsOfHorizontalWordDogInSimpleThreeByThree.");
		}
	}
}
