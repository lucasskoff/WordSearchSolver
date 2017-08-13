import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class Application
{
	public static void main(String[] args){
		System.out.print("Please enter the file path for a word search: ");
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.next();

		File file = new File(filename);
		if(!file.canRead()){
			System.out.println("Cannot read file. Please check file path and try again.");
			System.exit(1);
		}
		scanner.close();
		HashMap<String, List<Point>> wordSearchCorrectHashMap = Controller.wordSearchSolutionFromFile(filename);
		printHashMap(wordSearchCorrectHashMap);
		System.out.println("Thank you.");
	}

	private static void printHashMap(HashMap<String, List<Point>> hashMapToPrint){
		for(Map.Entry<String, List<Point>> entry : hashMapToPrint.entrySet()){
			System.out.println(entry.getKey() + ": " + getStringFromPoints(entry.getValue()));
		}
	}

	private static String getStringFromPoints(List<Point> points){
		String returnable = StringUtils.EMPTY;
		for(Point point : points){
			returnable = returnable.concat("(" + Integer.toString((int)point.getX()) + "," + Integer.toString((int)point.getY()) + "),");
		}
		return returnable.substring(0, returnable.length() - 1);
	}
}
