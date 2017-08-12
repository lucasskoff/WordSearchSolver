import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

class LetterGridProcessor
{
	/**
	 * Takes in an already initialized hash map of the first letters and scans the grid to determine where each of those letters resides.
	 * This method will allow us to be a lot more efficient when we actually go hunt down the words.
	 * Based off a common human strategy to solve word search puzzles.
	 */
	static HashMap<Character, List<Point>> populateHashMapListOfPointsFirstLetter(HashMap<Character, List<Point>> hMap, char[][] letterGrid){
		for(int i = 0; i < letterGrid.length; i++){
			for(int j = 0; j < letterGrid[i].length; j++){
				if(hMap.containsKey(letterGrid[i][j])){
					hMap.get(letterGrid[i][j]).add(new Point(j, i));
				}
			}
		}
		return hMap;
	}

	/**
	 * Uses the java scanner to turn a text file of comma seperated characters into a two dimensional char array.
	 * Created as a char array will be much easier to use than multiple scanners.
	 */
	static char[][] parseGridFromFileAsCharArray(String fileName) {
		File wordSearchFile = new File(fileName);
		try {
			Scanner scanner = new Scanner(wordSearchFile);
			scanner.nextLine(); //Throw away top line as it is only words.
			String topLineOfGrid = scanner.nextLine(); //Need to scan in top line outside of loop to determine size of char array.
			int widthHeight = Integer.divideUnsigned(topLineOfGrid.length(),2) + 1; //Removing commas from count.
			char[][] letterGrid = new char[widthHeight][widthHeight];
			letterGrid[0] = parseStringIntoCharArray(topLineOfGrid, widthHeight);
			int rowIndex = 1;
			while(scanner.hasNextLine()){
				if(rowIndex < widthHeight) {
					letterGrid[rowIndex] = parseStringIntoCharArray(scanner.nextLine(), widthHeight);
					rowIndex++;
				}else
				{
					return letterGrid;
				}
			}
			return letterGrid;
		}catch(FileNotFoundException e){
			System.out.println("parseGridFromFileAsCharArray caught FileNotFoundException on filename: " + wordSearchFile.getPath());
			return new char[0][0];
		}
	}

	/**
	 * Creates a one dimensional char array from a String. Used as a helper method for above, only set to package-private
	 * for testing purposes.
	 */
	static char[] parseStringIntoCharArray(String inputLine, int width){
		Scanner scanner = new Scanner(inputLine);
		scanner.useDelimiter(WordSearchLiterals.LETTER_GRID_DELIMITER);
		char[] outputLine = new char[width];
		int index = 0;
		while(scanner.hasNext()){
			if(index < width) {
				outputLine[index] = scanner.next().charAt(0);
				index++;
			}else{
				scanner.close();
				return outputLine;
			}
		}
		scanner.close();
		return outputLine;
	}
}
