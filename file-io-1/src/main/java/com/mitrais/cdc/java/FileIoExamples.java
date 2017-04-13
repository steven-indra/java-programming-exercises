package com.mitrais.cdc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileIoExamples {

	public static String nLetterWord(String inputFile, int wordLength) throws Exception {

		/*
		 * TO DO Print the first 10-letter word found in the file.
		 * 
		 */

		return Files.lines(Paths.get(inputFile)).filter(e -> e.length() == wordLength).findFirst().orElse(null);
	}

	public static String abcWord(String inputFile) throws Exception {

		/*
		 * TO DO Print the first 8-letter word that contains “a”, “b”, and “c”.
		 * 
		 */
		return Files.lines(Paths.get(inputFile)).filter(e -> e.length() == 8)
				.filter(e -> e.contains("a") && e.contains("b") && e.contains("c")).findFirst().orElse(null);
	}

	public static String abcWordMixedCase(String inputFile) throws Exception {

		/*
		 * TO DO Repeat the previous problem, but handle the possibility of
		 * mixed-case words in the file. Hint: do something shorter than merely
		 * modifying your filter tests to include “A”, “B”, and “C”.
		 * 
		 */
		return Files.lines(Paths.get(inputFile)).filter(e -> e.length() == 8).filter(
				e -> e.toLowerCase().contains("a") && e.toLowerCase().contains("b") && e.toLowerCase().contains("c"))
				.findFirst().orElse(null);
	}

	public static String longestWordWithout(String inputFile, String letter1, String letter2) throws Exception {

		/*
		 * TO DO Print the longest English word that contains neither “a” nor
		 * “e”.
		 * 
		 */
		return Files.lines(Paths.get(inputFile))
				.filter(e -> !e.toLowerCase().contains("a") && !e.toLowerCase().contains("e"))
				.max((a, b) -> a.length() - b.length()).get();
	}

	public static String shortestWordWith(String inputFile, String letter) throws Exception {

		/*
		 * TO DO Print the shortest English word that contains a “q”
		 * 
		 */
		return Files.lines(Paths.get(inputFile)).filter(e -> e.toLowerCase().contains("q"))
				.min((a, b) -> a.length() - b.length()).get();
	}

	public static void storeTwitterList(String inputFile, String outputFile) throws Exception {

		/*
		 * TO DO Make a file called “twitter-words.txt” that contains all words
		 * from the enable1-word-list.txt list that contain “wow” or “cool”. The
		 * words should be sorted, in uppercase, and have an exclamation point
		 * at the end. (E.g., “COOLER!”).
		 * 
		 */
		Charset characterSet = Charset.defaultCharset();
		Path path = Paths.get(outputFile);
		List<String> lines = Files.lines(Paths.get(inputFile))
				.map(e -> e.toUpperCase() + "!")
				.filter(e -> e.toLowerCase().contains("wow") || e.toLowerCase().contains("cool"))
				.sorted()
				.collect(Collectors.toList());
		Files.write(path, lines, characterSet);
	}

	public static long numPathsInProject() throws Exception {

		/*
		 * TO DO Print out the number of files in your Eclipse project. Folders
		 * count as files.
		 * 
		 */
		long num = Files.list(Paths.get("./")).count();
		return num;
	}

	public static void storeNums(int n, int range, String outputFile) {

		/*
		 * TO DO Create a file containing 17 random doubles between 0 and 100,
		 * each with exactly three digits after the decimal point. Note that the
		 * file will not actually be written until you close the PrintWriter.
		 * So, although you probably have mostly been ignoring exceptions, for
		 * this problem you might as well declare the PrintStream using the
		 * try-with-resources approach shown in the lecture. Not only will this
		 * handle the exceptions explicitly, but it will also automatically
		 * close the PrintStream at the end.
		 * 
		 */
		Charset characterSet = Charset.defaultCharset();
	    Path path = Paths.get(outputFile);
	    try (PrintWriter out =
	      new PrintWriter(Files.newBufferedWriter(path, characterSet))) {
	        for(int i=0; i<n; i++) {
	          out.printf("Number is %5.3f%n", range * Math.random());
	        }
	    } catch (IOException ioe) {
	      System.err.printf("IOException: %s%n", ioe);
	    }
	}

	private FileIoExamples() {
	} // Uninstantiatable class
}
