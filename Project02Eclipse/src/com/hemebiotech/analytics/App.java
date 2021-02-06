package com.hemebiotech.analytics;

import java.util.TreeMap;

/**
 * 
 * Contains the main method
 * 
 * @see ReadSymptomDataFromFile
 * @param filePathSymptoms
 * @param filePathResults
 */
public class App {

	private static final String filePathSymptoms = "Project02Eclipse/symptoms.txt";
	private static final String filePathResults = "Project02Eclipse/results.out.txt";

	public static void main(String[] args) throws Exception {
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile();
		readSymptomDataFromFile.getSymptoms(filePathSymptoms);
		TreeMap<String, Integer> resultSymptom = readSymptomDataFromFile.getSymptoms(filePathSymptoms);
		readSymptomDataFromFile.writeFileToTxt(filePathResults, resultSymptom);
	}
}
