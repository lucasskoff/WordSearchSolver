import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class LetterGridProcessor
{
	static char[][] parseGridFromFileAsCharArray(File file) {
		try {
			Scanner scanner = new Scanner(file);
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
			System.out.println("parseGridFromFileAsCharArray caught FileNotFoundException on filename: " + file.getPath());
			return new char[0][0];
		}
	}

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
