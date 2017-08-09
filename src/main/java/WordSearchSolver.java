import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.List;

class WordSearchSolver
{
	static boolean canWordFitInDirection(Direction direction, Point firstLetterPoint, int wordLength, int gridLength)
	{
		int XIndexOfLastLetter = (int)firstLetterPoint.getX() + (wordLength - 1) * direction.xDir();
		int YIndexOfLastLetter = (int)firstLetterPoint.getY() + (wordLength - 1) * direction.yDir();
		return XIndexOfLastLetter >= 0 && XIndexOfLastLetter <= gridLength - 1 && YIndexOfLastLetter >= 0 && YIndexOfLastLetter <= gridLength - 1;
	}

	static String wordFinder(Direction direction, Point firstLetterPoint, String wordToFind, char[][] letterGrid)
	{
		String buildWord = StringUtils.EMPTY;
		for(int i = 0; i < wordToFind.length(); i++){
			int xIndex = (int)firstLetterPoint.getX() + i * direction.xDir();
			int yIndex = (int)firstLetterPoint.getY() + i * direction.yDir();
			buildWord += letterGrid[yIndex][xIndex];
		}
		return buildWord;
	}
}
