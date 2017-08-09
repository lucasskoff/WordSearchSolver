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
	@Test
	public void ReturnPointsOfHorizontalForwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Horizontal_Forward, new Point(2,2), "Dog", fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfDiagonalForwardDownwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Diagonal_Forward_Downward, new Point(2,2), "Dog", fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfVerticalDownwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Vertical_Downward, new Point(2,2), "Dog", fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfDiagonalBackwardDownwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Diagonal_Backward_Downward, new Point(2,2), "Dog", fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfHorizontalBackwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Horizontal_Backward, new Point(2,2), "Dog", fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfDiagonalBackwardUpwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Diagonal_Backward_Upward, new Point(2,2), "Dog", fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfVerticalUpwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Vertical_Upward, new Point(2,2), "Dog", fiveByFiveGridForAllDirections));
	}

	@Test
	public void ReturnPointsOfDiagonalForwardWordDogInSimpleThreeByThreeGrid()
	{
		assertEquals("DOG", WordSearchSolver.wordFinder(Direction.Diagonal_Forward_Upward, new Point(2,2), "Dog", fiveByFiveGridForAllDirections));
	}

	@Test
	public void HorizontalForwardWordCanFitInThreeLetterGrid()
	{
		assertTrue(WordSearchSolver.canWordFitInDirection(Direction.Horizontal_Forward, new Point(0,0),3, threeByThreeGrid.length));
	}

	@Test
	public void DiagonalForwardDownwardWordCanFitInThreeLetterGrid()
	{
		assertTrue(WordSearchSolver.canWordFitInDirection(Direction.Diagonal_Forward_Downward, new Point(0,0),3, threeByThreeGrid.length));
	}

	@Test
	public void VerticalDownwardWordCanFitInThreeLetterGrid()
	{
		assertTrue(WordSearchSolver.canWordFitInDirection(Direction.Vertical_Downward, new Point(0,0),3, threeByThreeGrid.length));
	}

	@Test
	public void DiagonalBackwardDownwardWordCanFitInThreeLetterGrid()
	{
		assertTrue(WordSearchSolver.canWordFitInDirection(Direction.Diagonal_Backward_Downward, new Point(2,0),3, threeByThreeGrid.length));
	}

	@Test
	public void HorizontalBackwardWordCanFitInThreeLetterGrid()
	{
		assertEquals(true, WordSearchSolver.canWordFitInDirection(Direction.Horizontal_Backward, new Point(2,0),3, threeByThreeGrid.length));
	}

	@Test
	public void DiagonalBackwardUpwardWordCanFitInThreeLetterGrid()
	{
		assertEquals(true, WordSearchSolver.canWordFitInDirection(Direction.Diagonal_Backward_Upward, new Point(2,2),3, threeByThreeGrid.length));
	}

	@Test
	public void VerticalUpwardWordCanFitInThreeLetterGrid()
	{
		assertEquals(true, WordSearchSolver.canWordFitInDirection(Direction.Vertical_Upward, new Point(0,2),3, threeByThreeGrid.length));
	}

	@Test
	public void DiagonalForwardUpwardWordCanFitInThreeLetterGrid()
	{
		assertEquals(true, WordSearchSolver.canWordFitInDirection(Direction.Diagonal_Forward_Upward, new Point(0,2),3, threeByThreeGrid.length));
	}
}
