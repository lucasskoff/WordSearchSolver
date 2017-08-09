import java.awt.*;
import java.util.List;

class WordSearchSolver
{
	static boolean wordFinder(Direction direction, Point firstLetterPoint, String wordToFind, char[][] letterGrid, List<Point> populatedList)
	{
		StringBuilder buildWord = new StringBuilder();
		for(int i = 0; i < wordToFind.length(); i++){
			int xIndex = (int)firstLetterPoint.getX() + i * direction.xDir();
			int yIndex = (int)firstLetterPoint.getY() + i * direction.yDir();
			buildWord.append(letterGrid[yIndex][xIndex]);
			populatedList.add(new Point(xIndex, yIndex));
		}
		return true;
	}
}
