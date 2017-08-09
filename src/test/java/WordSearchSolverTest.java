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
	public void ReturnPointsOfHorizontalForwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Horizontal_Forward, new Point(0,0), "Dog", threeByThreeHorizontalForwardArray));
	}

	@Test
	public void ReturnPointsOfDiagonalForwardDownwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Diagonal_Forward_Downward, new Point(0,0), "Dog", threeByThreeDiagonalForwardDownwardArray));
	}

	@Test
	public void ReturnPointsOfVerticalDownwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Vertical_Downward, new Point(1,0), "Dog", threeByThreeVerticalDownwardArray));
	}

	@Test
	public void ReturnPointsOfDiagonalBackwardDownwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Diagonal_Backward_Downward, new Point(2,0), "Dog", threeByThreeDiagonalBackwardDownwardArray));
	}

	@Test
	public void ReturnPointsOfHorizontalBackwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Horizontal_Backward, new Point(2,0), "Dog", threeByThreeHorizontalBackwardArray));
	}

	@Test
	public void ReturnPointsOfDiagonalBackwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Diagonal_Backward_Upward, new Point(2,2), "Dog", threeByThreeDiagonalBackwardUpwardArray));
	}

	@Test
	public void ReturnPointsOfVerticalUpwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Vertical_Upward, new Point(1,2), "Dog", threeByThreeVerticalUpwardArray));
	}

	@Test
	public void ReturnPointsOfDiagonalForwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Diagonal_Forward_Upward, new Point(0,2), "Dog", threeByThreeDiagonalForwardUpwardArray));
	}
}
