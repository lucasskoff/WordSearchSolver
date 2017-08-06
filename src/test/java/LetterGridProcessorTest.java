import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

public class LetterGridProcessorTest
{
	private File threeByThreeInput;
	private File fourByFourInput;
	private char[][] threeByThreeSolutionArray = {{'D','O','G'},{'C','A','T'},{'R','A','T'}};
	private char[][] fourByFourSolutionArray = {{'F','O','R','K'},{'E','Y','W','Z'},{'H','D','A','E'}};

	@Before
	public void Init(){
		threeByThreeInput = new File("resources/horizontalWordsThreeByThreeGrid");
		fourByFourInput = new File("resources/horizontalWordsFourByFourGrid.txt");
	}

	@Test
	public void ThreeByThreeGridFromFileIsCorrectSize(){
		assertEquals(threeByThreeSolutionArray.length, LetterGridProcessor.parseGridFromFileAsCharArray(threeByThreeInput).length);
	}

	@Test
	public void FourByFourGridFromFileIsCorrectSize(){
		assertEquals(fourByFourSolutionArray.length, LetterGridProcessor.parseGridFromFileAsCharArray(fourByFourInput).length);
	}

	@Test
	public void ParseStringInto1DCharArray(){
		String inputLine = "D,O,G";
		char[] oneDSolutionArray = {'D','O','G'};
		assertArrayEquals(oneDSolutionArray, LetterGridProcessor.parseStringIntoCharArray(inputLine, 3));
	}
}