import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.List;

class WordSearchSolver
{
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
