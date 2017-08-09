import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;

import static org.junit.Assert.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class WordSearchSolverTest
{
	private char[][] threeByThreeGrid = {{'D','O','G'},{'C','A','T'},{'R','A','T'}};
	private char[][] twoBytwoGrid = {{'D','O'},{'C','A'}};
	private char[][] fiveByFiveGridForAllDirections = {
			{'G','A','G','A','G'},
			{'A','O','O','O','A'},
			{'G','O','D','O','G'},
			{'A','O','O','O','A'},
			{'G','A','G','A','G'}
	};

	private Point pointZeroZero;
	private int dogStringLength;

	@Before
	public void init()
	{
		pointZeroZero = new Point(0, 0);
		dogStringLength = "DOG".length();
	}

	@Test
	public void ReturnPointsOfHorizontalForwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Horizontal_Forward, new Point(2,2), dogStringLength, fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfDiagonalForwardDownwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Diagonal_Forward_Downward, new Point(2,2), dogStringLength, fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfVerticalDownwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Vertical_Downward, new Point(2,2), dogStringLength, fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfDiagonalBackwardDownwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Diagonal_Backward_Downward, new Point(2,2), dogStringLength, fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfHorizontalBackwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Horizontal_Backward, new Point(2,2), dogStringLength, fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfDiagonalBackwardUpwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Diagonal_Backward_Upward, new Point(2,2), dogStringLength, fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfVerticalUpwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Vertical_Upward, new Point(2,2), dogStringLength, fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfDiagonalForwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Diagonal_Forward_Upward, new Point(2,2), dogStringLength, fiveByFiveGridForAllDirections));
	}

	@Test
	public void ThreeLetterHorizontalForwardWordCanFitInThreeLetterGrid()
	{
	assertTrue(WordSearchSolver.canWordFitInDirection(Direction.Horizontal_Forward, new Point(0,0), dogStringLength, threeByThreeGrid.length));
	}

	@Test
	public void ThreeLetterDiagonalForwardDownwardWordCanFitInThreeLetterGrid()
	{
		assertTrue(WordSearchSolver.canWordFitInDirection(Direction.Diagonal_Forward_Downward, new Point(0,0), dogStringLength, threeByThreeGrid.length));
	}

	@Test
	public void ThreeLetterVerticalDownwardWordCanFitInThreeLetterGrid()
	{
		assertTrue(WordSearchSolver.canWordFitInDirection(Direction.Vertical_Downward, new Point(0,0), dogStringLength, threeByThreeGrid.length));
	}

	@Test
	public void ThreeLetterDiagonalBackwardDownwardWordCanFitInThreeLetterGrid()
	{
		assertTrue(WordSearchSolver.canWordFitInDirection(Direction.Diagonal_Backward_Downward, new Point(2,0), dogStringLength, threeByThreeGrid.length));
	}

	@Test
	public void ThreeLetterHorizontalBackwardWordCanFitInThreeLetterGrid()
	{
		assertTrue(WordSearchSolver.canWordFitInDirection(Direction.Horizontal_Backward, new Point(2,0), dogStringLength, threeByThreeGrid.length));
	}

	@Test
	public void ThreeLetterDiagonalBackwardUpwardWordCanFitInThreeLetterGrid()
	{
		assertTrue(WordSearchSolver.canWordFitInDirection(Direction.Diagonal_Backward_Upward, new Point(2,2), dogStringLength, threeByThreeGrid.length));
	}

	@Test
	public void ThreeLetterVerticalUpwardWordCanFitInThreeLetterGrid()
	{
		assertTrue(WordSearchSolver.canWordFitInDirection(Direction.Vertical_Upward, new Point(0,2), dogStringLength, threeByThreeGrid.length));
	}

	@Test
	public void ThreeLetterDiagonalForwardUpwardWordCanFitInThreeLetterGrid()
	{
		assertTrue(WordSearchSolver.canWordFitInDirection(Direction.Diagonal_Forward_Upward, new Point(0,2), dogStringLength, threeByThreeGrid.length));
	}

	@Test
	public void ThreeLetterHorizontalForwardWordCanNotFitInTwoLetterGrid()
	{
		assertFalse(WordSearchSolver.canWordFitInDirection(Direction.Horizontal_Forward, pointZeroZero, dogStringLength, twoBytwoGrid.length));
	}

	@Test
	public void ThreeLetterDiagonalForwardDownwardWordCanNotFitInTwoLetterGrid()
	{
		assertFalse(WordSearchSolver.canWordFitInDirection(Direction.Diagonal_Forward_Downward, pointZeroZero, dogStringLength, twoBytwoGrid.length));
	}

	@Test
	public void ThreeLetterVerticalDownwardWordCanNotFitInTwoLetterGrid()
	{
		assertFalse(WordSearchSolver.canWordFitInDirection(Direction.Vertical_Downward, pointZeroZero, dogStringLength, twoBytwoGrid.length));
	}

	@Test
	public void ThreeLetterDiagonalBackwardDownwardWordCanNotFitInTwoLetterGrid()
	{
		assertFalse(WordSearchSolver.canWordFitInDirection(Direction.Diagonal_Backward_Downward, pointZeroZero, dogStringLength, twoBytwoGrid.length));
	}

	@Test
	public void ThreeLetterHorizontalBackwardWordCanNotFitInTwoLetterGrid()
	{
		assertFalse(WordSearchSolver.canWordFitInDirection(Direction.Horizontal_Backward, pointZeroZero, dogStringLength, twoBytwoGrid.length));
	}

	@Test
	public void ThreeLetterDiagonalBackwardUpwardWordCanNotFitInTwoLetterGrid()
	{
		assertFalse(WordSearchSolver.canWordFitInDirection(Direction.Diagonal_Backward_Upward, pointZeroZero, dogStringLength, twoBytwoGrid.length));
	}

	@Test
	public void ThreeLetterVerticalUpwardWordCanFitInTwoLetterGrid()
	{
		assertFalse(WordSearchSolver.canWordFitInDirection(Direction.Vertical_Upward, pointZeroZero, dogStringLength, twoBytwoGrid.length));
	}

	@Test
	public void ThreeLetterDiagonalForwardUpwardWordCanNotFitInTwoLetterGrid()
	{
		assertFalse(WordSearchSolver.canWordFitInDirection(Direction.Diagonal_Forward_Upward, pointZeroZero, dogStringLength, twoBytwoGrid.length));
	}

}
