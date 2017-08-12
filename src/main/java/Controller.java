import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Controller
{
	 static HashMap<String, List<Point>> wordSearchSolutionFromFile(String filename){
	 	//List<Direction> directionsList = getCompleteListOfDirections();
		char[][] letterGrid = LetterGridProcessor.parseGridFromFileAsCharArray(filename);
		List<String> wordList = WordListProcessor.createArrayListOfWordsFromFileName(filename);
		HashMap<Character, List<Point>> firstLetterMap = WordListProcessor.createHashMapOfWordFirstLetters(wordList);
		firstLetterMap = LetterGridProcessor.populateHashMapListOfPointsFirstLetter(firstLetterMap, letterGrid);
		HashMap<String, List<Point>> completeMapOfSolutions = new HashMap<>();

		for(String currentWord : wordList){
			for(Point currentPoint : firstLetterMap.get(currentWord.charAt(0))){

				if(WordSearchSolver.canWordFitInDirection(Direction.Horizontal_Forward, currentPoint, currentWord.length(), letterGrid.length)
						&& WordSearchSolver.wordFinder(Direction.Horizontal_Forward, currentPoint, currentWord.length(), letterGrid).equalsIgnoreCase(currentWord)){

					completeMapOfSolutions.put(currentWord.toUpperCase(), WordSearchSolver.getPointsForWordFromDirection(Direction.Horizontal_Forward, currentPoint, currentWord.length()));
				}
			}
		}
		return completeMapOfSolutions;
	}

	private static List<Direction> getCompleteListOfDirections(){
		Direction[] directions = {Direction.Horizontal_Forward, Direction.Diagonal_Forward_Downward,
				Direction.Vertical_Downward, Direction.Diagonal_Backward_Downward,
				Direction.Horizontal_Backward, Direction.Diagonal_Backward_Upward,
				Direction.Vertical_Upward, Direction.Diagonal_Forward_Upward};
		return Arrays.asList(directions);
	}
}
