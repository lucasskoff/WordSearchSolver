import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Controller {
	/*
		Uses all utility methods to turn a file name into a HashMap of solutions.
	 */
	static HashMap<String, List<Point>> wordSearchSolutionFromFile(String filename) {
		List<Direction> directionsList = getCompleteListOfDirections(); //List of all 8 possible directions
		char[][] letterGrid = LetterGridProcessor.parseGridFromFileAsCharArray(filename); //The grid turned into a 2D array
		List<String> wordList = WordListProcessor.createArrayListOfWordsFromFileName(filename); //The list of words at the top
		HashMap<Character, List<Point>> firstLetterMap = WordListProcessor.createHashMapOfWordFirstLetters(wordList); //Goes through each of the words and extracts the first letter into a the keys of a map
		firstLetterMap = LetterGridProcessor.populateHashMapListOfPointsFirstLetter(firstLetterMap, letterGrid); //Goes through the grid and adds the point into its corresponding value of the map.
		HashMap<String, List<Point>> completeMapOfSolutions = new HashMap<>(); //A new map to return to Main

		for (String currentWord : wordList) { //Go through each word
			for (Point currentPoint : firstLetterMap.get(currentWord.charAt(0))) { //Go through each of the points corresponding to its first letter
				for (Direction currentDirection : directionsList) { //Try each of the 8 directions

					if (WordSearchSolver.canWordFitInDirection(currentDirection, currentPoint, currentWord.length(), letterGrid.length)
							&& WordSearchSolver.wordFinder(currentDirection, currentPoint, currentWord.length(), letterGrid).equalsIgnoreCase(currentWord)) {

						completeMapOfSolutions.put(currentWord.toUpperCase(), WordSearchSolver.getPointsForWordFromDirection(currentDirection, currentPoint, currentWord.length()));
					}
				}
			}
		}
		return completeMapOfSolutions;
	}

	/**
	 * A helper method returning a list of each of the 8 possible directions.
	 */
	private static List<Direction> getCompleteListOfDirections(){
		Direction[] directions = {Direction.Horizontal_Forward, Direction.Diagonal_Forward_Downward,
				Direction.Vertical_Downward, Direction.Diagonal_Backward_Downward,
				Direction.Horizontal_Backward, Direction.Diagonal_Backward_Upward,
				Direction.Vertical_Upward, Direction.Diagonal_Forward_Upward};
		return Arrays.asList(directions);
	}
}
