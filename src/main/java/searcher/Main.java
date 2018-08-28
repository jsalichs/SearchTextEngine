package searcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Take the words given on the command prompt and return a list with matching
 * filenames percentage.
 * 
 * @author juan.salichs
 *
 */
public class Main {

	private static Scanner keyboard;

	public static void main(String[] args) {

		// Validations
		if (args.length == 0) {
			throw new IllegalArgumentException("No directory given to index.");
		}

		final File indexableDirectory = new File(args[0]);
		if (!indexableDirectory.exists()) {
			throw new IllegalArgumentException(
					"Directory given doesn't exist: " + indexableDirectory.getAbsolutePath());
		}
		if (indexableDirectory.listFiles().length == 0) {
			throw new IllegalArgumentException("Directory given is empty.");
		}

		File[] fileArray = indexableDirectory.listFiles();

		System.out.println(fileArray.length + " files read in directory " + indexableDirectory);
		
		keyboard = new Scanner(System.in);

		while (true) {
			System.out.println("search> ");
			final String words = keyboard.nextLine();

			checkFiles(fileArray, words);
		}
	}

	/**
	 * check words into each file
	 * 
	 * @param fileArray
	 * @param words
	 */
	public static void checkFiles(File[] fileArray, final String words) {

		Main main = new Main();
		double[] fileRank = new double[fileArray.length];

		int currentFileIndex = 0;

		List<FileMatchLevel> list = new ArrayList<FileMatchLevel>();

		// Search indexed files for words in line and assign file name and match level to a list
		for (File file : fileArray) {
			fileRank[currentFileIndex] = main.findMatchLevel(file, words);
			FileMatchLevel currentObj = new FileMatchLevel();
			currentObj.setFileName(file.getName());
			currentObj.setMatch(fileRank[currentFileIndex]);
			list.add(currentObj);
			currentFileIndex++;
		}

		// Sort list by match value
		Collections.sort(list);

		// Print the first 10 text files with higher match level or the complete folder match level if the number of files is below 10
		currentFileIndex = 0;
		for (FileMatchLevel obj : list) {
			if (currentFileIndex < 10) {
				System.out.println(obj.getFileName() + ":" + obj.getMatch() + "%");
			}
			currentFileIndex++;
		}
	}

	/**
	 * Search a word into file and evaluate its match level
	 * 
	 * @param file
	 * @param words
	 * @return
	 */
	public double findMatchLevel(File file, String words) {

		double mathPctg = 0;

		Scanner fileScanner = null;
		try {

			double matchCounter = 0;

			// Divide "words" parameter into pieces and build an array with them.
			String[] wordsArr = words.split("\\s+");

			// Check file for each word
			for (String word : wordsArr) {
				fileScanner = new Scanner(file);

				while (fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();

					// If word exists into file, increase matchCouter and stop searching
					if (line != null && line.toLowerCase().matches(".*\\b" + word.toLowerCase() + "\\b.*")) {
						matchCounter++;
						break;
					}
				}

			}

			// This formula defines the match level
			mathPctg = (matchCounter / wordsArr.length) * 100;
			// Round to 2 decimals the match level
			mathPctg = Math.round(mathPctg*100.0)/100.0;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fileScanner != null) {
				fileScanner.close();
			}
		}

		return mathPctg;
	}

}
