import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

public class LetterGridProcessorTest
{
	private File threeByThreeInput;
	private File fourByFourInput;
	private char[][] threeByThreeInputArray = {{'D','O','G'},{'C','A','T'},{'R','A','T'}};
	private char[][] fourByFourInputArray = {{'F','O','R','K'},{'E','Y','W','Z'},{'H','D','A','E'}};

	@Before
	public void Init(){
		threeByThreeInput = new File("resources/horizontalWordsThreeByThreeGrid");
		fourByFourInput = new File("resources/horizontalWordsFourByFourGrid.txt");
	}

	@Test
	public void ThreeByThreeGridFromFileIsCorrectSize(){
		assertEquals(threeByThreeInputArray.length, LetterGridProcessor.parseGridFromFileAsCharArray(threeByThreeInput).length);
	}

	@Test
	public void FourByFourGridFromFileIsCorrectSize(){
		assertEquals(fourByFourInputArray.length, LetterGridProcessor.parseGridFromFileAsCharArray(fourByFourInput).length);
	}
}