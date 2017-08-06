import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class LetterGridProcessor
{
	static char[][] parseGridFromFileAsCharArray(File file) {
		try {
			Scanner scanner = new Scanner(file);
			scanner.nextLine(); //Throw away top line as it is only words.
			String currentLine = scanner.nextLine();
			int widthHeight = Integer.divideUnsigned(currentLine.length(),2); //Removing commas from count.
			char[][] letterGrid = new char[widthHeight][widthHeight];
			return letterGrid;
		}catch(FileNotFoundException e){
			e.printStackTrace();
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
