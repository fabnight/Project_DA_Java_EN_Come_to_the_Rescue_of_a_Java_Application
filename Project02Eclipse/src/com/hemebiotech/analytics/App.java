package com.hemebiotech.analytics;

/**
 * 
 * Contains the main method
 *
 */
public class App {

	private static final String filePathSymptoms = "Project02Eclipse/symptoms.txt";
	private static final String filePathResults = "Project02Eclipse/results.out.txt";

	public static void main(String[] args) throws Exception {
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile();
		readSymptomDataFromFile.getSymptoms(filePathSymptoms);
		readSymptomDataFromFile.writeFileToTxt(filePathSymptoms, filePathResults);
	}

}
