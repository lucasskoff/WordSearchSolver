import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class WordSearchSolverTest
{
	private char[][] twoBytwoGrid = {{'D','O'},{'C','A'}};
	private char[][] threeByThreeHorizontalForwardArray = {{'D','O','G'},{'C','A','T'},{'R','A','T'}};
	private char[][] threeByThreeDiagonalForwardDownwardArray = {{'D', 'A', 'A'}, {'A', 'O', 'A'}, {'A', 'A', 'G'}};
	private char[][] threeByThreeVerticalDownwardArray = {{'A', 'D', 'A'}, {'A', 'O', 'A'}, {'A', 'G', 'A'}};
	private char[][] threeByThreeDiagonalBackwardDownwardArray = {{'A', 'A', 'D'}, {'A', 'O', 'A'}, {'G', 'A', 'A'}};
	private char[][] threeByThreeHorizontalBackwardArray = {{'G', 'O', 'D'}, {'A', 'A', 'A'}, {'A', 'A', 'A'}};
	private char[][] threeByThreeDiagonalBackwardUpwardArray = {{'G', 'A', 'A'}, {'A', 'O', 'A'}, {'A', 'A', 'D'}};
	private char[][] threeByThreeVerticalUpwardArray = {{'A', 'G', 'A'}, {'A', 'O', 'A'}, {'A', 'D', 'A'}};
	private char[][] threeByThreeDiagonalForwardUpwardArray = {{'A', 'A', 'G'}, {'A', 'O', 'A'}, {'D', 'A', 'A'}};
	private List<Point> pointsToTest;

	@Before
	public void init(){
		pointsToTest = new ArrayList<>();
	}
	@Test
	public void ReturnPointsOfHorizontalForwardWordDogInSimpleThreeByThreeGrid(){
		Point[] correctPointsHorizontalArray = {new Point(0,0), new Point(1,0), new Point(2,0)};
		List<Point> correctPointsList = Arrays.asList(correctPointsHorizontalArray);
		if(WordSearchSolver.wordFinder(Direction.Horizontal_Forward, new Point(0,0), "Dog", threeByThreeHorizontalForwardArray , pointsToTest))
		{
			assertEquals(correctPointsList, pointsToTest);
		}else {
			Assert.fail("Incapable of finding word in test ReturnPointsOfHorizontalWordDogInSimpleThreeByThree.");
		}
	}

	@Test
	public void ReturnPointsOfDiagonalForwardDownwardWordDogInSimpleThreeByThreeGrid()
	{
		Point[] correctPointsVerticalArray = {new Point(0,0), new Point(1, 1), new Point(2, 2)};
		List<Point> correctPointsList = Arrays.asList(correctPointsVerticalArray);
		if(WordSearchSolver.wordFinder(Direction.Diagonal_Forward_Downward, new Point(0,0), "Dog", threeByThreeDiagonalForwardDownwardArray , pointsToTest)){
			assertEquals(correctPointsList, pointsToTest);
		}else {
			Assert.fail("Incapable of finding word in test ReturnPointsOfVerticalWordDogInSimpleThreeByThreeGrid.");
		}
	}

	@Test
	public void ReturnPointsOfVerticalDownwardWordDogInSimpleThreeByThreeGrid()
	{
		Point[] correctPointsVerticalArray = {new Point(1,0), new Point(1, 1), new Point(1, 2)};
		List<Point> correctPointsList = Arrays.asList(correctPointsVerticalArray);
		if(WordSearchSolver.wordFinder(Direction.Vertical_Downward, new Point(1,0), "Dog", threeByThreeVerticalDownwardArray , pointsToTest)){
			assertEquals(correctPointsList, pointsToTest);
		}else {
			Assert.fail("Incapable of finding word in test ReturnPointsOfVerticalWordDogInSimpleThreeByThreeGrid.");
		}
	}

	@Test
	public void ReturnPointsOfDiagonalBackwardDownwardWordDogInSimpleThreeByThreeGrid()
	{
		Point[] correctPointsVerticalArray = {new Point(2,0), new Point(1, 1), new Point(0, 2)};
		List<Point> correctPointsList = Arrays.asList(correctPointsVerticalArray);
		if(WordSearchSolver.wordFinder(Direction.Diagonal_Backward_Downward, new Point(2,0), "Dog", threeByThreeDiagonalBackwardDownwardArray , pointsToTest)){
			assertEquals(correctPointsList, pointsToTest);
		}else {
			Assert.fail("Incapable of finding word in test ReturnPointsOfVerticalWordDogInSimpleThreeByThreeGrid.");
		}
	}

	@Test
	public void ReturnPointsOfHorizontalBackwardWordDogInSimpleThreeByThreeGrid()
	{
		Point[] correctPointsVerticalArray = {new Point(2,0), new Point(1, 0), new Point(0, 0)};
		List<Point> correctPointsList = Arrays.asList(correctPointsVerticalArray);
		if(WordSearchSolver.wordFinder(Direction.Horizontal_Backward, new Point(2,0), "Dog", threeByThreeHorizontalBackwardArray , pointsToTest)){
			assertEquals(correctPointsList, pointsToTest);
		}else {
			Assert.fail("Incapable of finding word in test ReturnPointsOfVerticalWordDogInSimpleThreeByThreeGrid.");
		}
	}

	@Test
	public void ReturnPointsOfDiagonalBackwardWordDogInSimpleThreeByThreeGrid()
	{
		Point[] correctPointsVerticalArray = {new Point(2,2), new Point(1, 1), new Point(0, 0)};
		List<Point> correctPointsList = Arrays.asList(correctPointsVerticalArray);
		if(WordSearchSolver.wordFinder(Direction.Diagonal_Backward_Upward, new Point(2,2), "Dog", threeByThreeDiagonalBackwardUpwardArray , pointsToTest)){
			assertEquals(correctPointsList, pointsToTest);
		}else {
			Assert.fail("Incapable of finding word in test ReturnPointsOfVerticalWordDogInSimpleThreeByThreeGrid.");
		}
	}

	@Test
	public void ReturnPointsOfVerticalUpwardWordDogInSimpleThreeByThreeGrid()
	{
		Point[] correctPointsVerticalArray = {new Point(1,2), new Point(1, 1), new Point(1, 0)};
		List<Point> correctPointsList = Arrays.asList(correctPointsVerticalArray);
		if(WordSearchSolver.wordFinder(Direction.Vertical_Upward, new Point(1,2), "Dog", threeByThreeVerticalUpwardArray , pointsToTest)){
			assertEquals(correctPointsList, pointsToTest);
		}else {
			Assert.fail("Incapable of finding word in test ReturnPointsOfVerticalWordDogInSimpleThreeByThreeGrid.");
		}
	}

	@Test
	public void ReturnPointsOfDiagonalForwardWordDogInSimpleThreeByThreeGrid()
	{
		Point[] correctPointsVerticalArray = {new Point(0,2), new Point(1, 1), new Point(2, 0)};
		List<Point> correctPointsList = Arrays.asList(correctPointsVerticalArray);
		if(WordSearchSolver.wordFinder(Direction.Diagonal_Forward_Upward, new Point(0,2), "Dog", threeByThreeDiagonalForwardUpwardArray , pointsToTest)){
			assertEquals(correctPointsList, pointsToTest);
		}else {
			Assert.fail("Incapable of finding word in test ReturnPointsOfVerticalWordDogInSimpleThreeByThreeGrid.");
		}
	}

	/*@Test
	public void ReturnFalseIfGridIsTooSmallInHorizontalDirectionForWordFromStartingPoint(){
		assertEquals(false, WordSearchSolver.wordFinder(Direction.Horizontal_Forward, new Point(0,0), "Dog", twoBytwoGrid, new ArrayList<>()));
	}

	@Test
	public void ReturnFalseIfGridIsTooSmallInVerticalDirectionForWordFromStartingPoint(){
		assertEquals(false, WordSearchSolver.wordFinder(Direction.Vertical_Downward, new Point(0,0), "Dog", twoBytwoGrid, new ArrayList<>()));
	}*/
}
