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
			int widthHeight = (currentLine.length() / 2); //Removing commas from count.
			char[][] letterGrid = new char[widthHeight][widthHeight];
			return letterGrid;
		}catch(FileNotFoundException e){
			e.printStackTrace();
			return null;
		}
	}
}
