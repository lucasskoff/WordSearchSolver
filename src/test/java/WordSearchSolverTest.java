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
	char[][] twoBytwoGrid = {{'D','O'},{'C','A'}};
	private char[][] threeByThreeSolutionArray = {{'D','O','G'},{'C','A','T'},{'R','A','T'}};
	private char[][] threeByThreeVerticalSolutionArray = {{'D', 'C', 'R'}, {'O', 'A', 'A'}, {'G', 'T', 'T'}};
	List<Point> pointsToTest;
	@Before
	public void init(){
		pointsToTest = new ArrayList<>();
	}
	@Test
	public void ReturnPointsOfHorizontalWordDogInSimpleThreeByThreeGrid(){
		Point[] correctPointsHorizontalArray = {new Point(0,0), new Point(1,0), new Point(2,0)};
		List<Point> correctPointsList = Arrays.asList(correctPointsHorizontalArray);
		if(WordSearchSolver.wordFinder(Direction.Horizontal, new Point(0,0), "Dog", threeByThreeSolutionArray, pointsToTest))
		{
			assertEquals(correctPointsList, pointsToTest);
		}else {
			Assert.fail("Incapable of finding word in test ReturnPointsOfHorizontalWordDogInSimpleThreeByThree.");
		}
	}

	@Test
	public void ReturnPointsOfVerticalWordDogInSimpleThreeByThreeGrid()
	{
		Point[] correctPointsVerticalArray = {new Point(0,0), new Point(0, 1), new Point(0, 2)};
		List<Point> correctPointsList = Arrays.asList(correctPointsVerticalArray);
		if(WordSearchSolver.wordFinder(Direction.Vertical, new Point(0,0), "Dog", threeByThreeSolutionArray, pointsToTest)){
			assertEquals(correctPointsList, pointsToTest);
		}else {
			Assert.fail("Incapable of finding word in test ReturnPointsOfVerticalWordDogInSimpleThreeByThreeGrid.");
		}
	}

	@Test
	public void ReturnFalseIfGridIsTooSmallInHorizontalDirectionForWordFromStartingPoint(){
		char[][] twoBytwoGrid = {{'D','O'},{'C','A'}};
		assertEquals(false, WordSearchSolver.wordFinder(Direction.Horizontal, new Point(0,0), "Dog", twoBytwoGrid, new ArrayList<Point>()));
	}

	@Test
	public void ReturnFalseIfGridIsTooSmallInVerticalDirectionForWordFromStartingPoint(){
		assertEquals(false, WordSearchSolver.wordFinder(Direction.Vertical, new Point(0,0), "Dog", twoBytwoGrid, new ArrayList<Point>()));
	}
}
