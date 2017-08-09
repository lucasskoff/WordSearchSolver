import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.List;

class WordSearchSolver
{
	/**
	 * Determines if the word in question can fit in the grid from the starting character to the word length in the direction provided.
	 * Is primarily used to avoid ArrayIndexOutOfBoundsException. Also cuts out many potential directions at a lower cost than the for loop.
	 */
	static boolean canWordFitInDirection(Direction direction, Point firstLetterPoint, int wordLength, int gridLength)
	{
		int XIndexOfLastLetter = (int)firstLetterPoint.getX() + (wordLength - 1) * direction.xDir();
		int YIndexOfLastLetter = (int)firstLetterPoint.getY() + (wordLength - 1) * direction.yDir();
		return XIndexOfLastLetter >= 0 && XIndexOfLastLetter <= gridLength - 1 && YIndexOfLastLetter >= 0 && YIndexOfLastLetter <= gridLength - 1;
	}

	/**
	 * Returns the string that is created by using a starting point, the direction to head, and the number of letters to go.
	 * Does not inform user if word was correct.
	 */
	static String wordFinder(Direction direction, Point firstLetterPoint, int wordLength, char[][] letterGrid)
	{
		String buildWord = StringUtils.EMPTY;
		for(int i = 0; i < wordLength; i++){
			int xIndex = (int)firstLetterPoint.getX() + i * direction.xDir();
			int yIndex = (int)firstLetterPoint.getY() + i * direction.yDir();
			buildWord += letterGrid[yIndex][xIndex];
		}
		return buildWord;
	}
}
