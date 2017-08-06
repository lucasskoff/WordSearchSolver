import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

public class LetterGridProcessorTest
{
	private File threeByThreeInput;
	private char[][] threeByThreeInputSolutionArray = {{'D','O','G'},{'C','A','T'},{'R','A','T'}};

	@Before
	public void Init(){
		threeByThreeInput = new File("resources/horizontalWordsThreeByThreeGrid");
	}

	@Test
	public void ThreeByThreeGridFromFileIsCorrectSize(){
		try {
			assertEquals(threeByThreeInputSolutionArray.length, LetterGridProcessor.parseGridFromFileAsCharArray(threeByThreeInput).length);
		}catch(NullPointerException e){
			Assert.fail("NullPointerException thrown. FileNotFound in LetterGridProcessor.parseGridFromFileAsCharArray.");
		}
	}

}