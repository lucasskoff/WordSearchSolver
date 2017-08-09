import java.awt.*;
import java.util.List;

class WordSearchSolver
{
	static boolean wordFinder(Direction direction, Point firstLetterPoint, String wordToFind, char[][] letterGrid, List<Point> populatedList)
	{
		int indexOfLastLetterHorizontalDirection = direction.xDir() * wordToFind.length();
		int indexOfLastLetterVerticalDirection = direction.yDir() * wordToFind.length();
		if(indexOfLastLetterHorizontalDirection < 0 || indexOfLastLetterHorizontalDirection > letterGrid.length){
			return false;
		}
		if(indexOfLastLetterVerticalDirection < 0 || indexOfLastLetterVerticalDirection > letterGrid.length){
			return false;
		}
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
