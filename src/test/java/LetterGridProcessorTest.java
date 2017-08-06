import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

public class LetterGridProcessorTest
{
	private File threeByThreeFile;
	private File fourByFourFile;
	private File bigGridFromKataFile;
	private String inputLine = "D,O,G";
	private char[][] threeByThreeSolutionArray = {{'D','O','G'},{'C','A','T'},{'R','A','T'}};
	private char[][] fourByFourSolutionArray = {{'F','O','R','K'},{'E','Y','W','Z'},{'G','O','T','O'},{'H','D','A','E'}};
	private char[] oneDSolutionArray = {'D','O','G'};
	private char[][] bigGridFromKata = {
			{'U','M','K','H','U','L','K','I','N','V','J','O','C','W','E'},
			{'L','L','S','H','K','Z','Z','W','Z','C','G','J','U','Y','G'},
			{'H','S','U','P','J','P','R','J','D','H','S','B','X','T','G'},
			{'B','R','J','S','O','E','Q','E','T','I','K','K','G','L','E'},
			{'A','Y','O','A','G','C','I','R','D','Q','H','R','T','C','D'},
			{'S','C','O','T','T','Y','K','Z','R','E','P','P','X','P','F'},
			{'B','L','Q','S','L','N','E','E','E','V','U','L','F','M','Z'},
			{'O','K','R','I','K','A','M','M','R','M','F','B','A','P','P'},
			{'N','U','I','I','Y','H','Q','M','E','M','Q','R','Y','F','S'},
			{'E','Y','Z','Y','G','K','Q','J','P','C','Q','W','Y','A','K'},
			{'S','J','F','Z','M','Q','I','B','D','B','E','M','K','W','D'},
			{'T','G','L','B','H','C','B','E','C','H','T','O','Y','I','K'},
			{'O','J','Y','E','U','L','N','C','C','L','Y','B','Z','U','H'},
			{'W','Z','M','I','S','U','K','U','R','B','I','D','U','X','S'},
			{'K','Y','L','B','Q','Q','P','M','D','F','C','K','E','A','B'}};

	@Before
	public void Init(){
		threeByThreeFile = new File("resources/horizontalWordsThreeByThreeGrid");
		fourByFourFile = new File("resources/horizontalWordsFourByFourGrid.txt");
		bigGridFromKataFile = new File("resources/bigGridFromKata");
	}

	@Test
	public void ThreeByThreeGridFromFileOutputs2DArrayOfCorrectSize(){
		assertEquals(threeByThreeSolutionArray.length, LetterGridProcessor.parseGridFromFileAsCharArray(threeByThreeFile).length);
	}

	@Test
	public void FourByFourGridFromFileOutputs2DArrayOfCorrectSize(){
		assertEquals(fourByFourSolutionArray.length, LetterGridProcessor.parseGridFromFileAsCharArray(fourByFourFile).length);
	}

	@Test
	public void BigGridFromKataOutputs2DArrayOfCorrectSize(){
		assertEquals(bigGridFromKata.length, LetterGridProcessor.parseGridFromFileAsCharArray(bigGridFromKataFile).length);
	}

	@Test
	public void ParseStringInto1DCharArray(){
		assertArrayEquals(oneDSolutionArray, LetterGridProcessor.parseStringIntoCharArray(inputLine, 3));
	}

	@Test
	public void ParseStringWithMoreLettersThanWidthIntoCharArray(){
		inputLine += ",O";
		assertArrayEquals(oneDSolutionArray, LetterGridProcessor.parseStringIntoCharArray(inputLine, 3));
	}

	@Test
	public void ThreeByThreeGridFromFileOutputsCorrect2DCharArray(){
		assertArrayEquals(threeByThreeSolutionArray, LetterGridProcessor.parseGridFromFileAsCharArray(threeByThreeFile));
	}

	@Test
	public void FourByFourGridFromFileOutputsCorrect2DCharArray(){
		assertArrayEquals(fourByFourSolutionArray, LetterGridProcessor.parseGridFromFileAsCharArray(fourByFourFile));
	}

	@Test
	public void BigGridFromKataFileOutputsCorrect2DCharArray(){
		assertArrayEquals(bigGridFromKata, LetterGridProcessor.parseGridFromFileAsCharArray(bigGridFromKataFile));
	}
}