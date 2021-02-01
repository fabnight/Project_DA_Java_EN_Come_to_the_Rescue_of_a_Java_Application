package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Reading a list of symptoms, counting and writing occurrences for each symptom
 * sorted in a new file
 * 
 * @author Fabrice Garnier
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	/**
	 * 1st step reading symptoms from symptoms.txt file
	 * 
	 * @throws Exception FileNotFoundException if impossible to find source folder
	 *                   symptoms.txt
	 * 
	 * @param filePathSymptoms
	 * 
	 * @return resultSymptom
	 */

	@Override
	public void getSymptoms(String filePathSymptoms) throws Exception {

		readFileTxt(filePathSymptoms);
	}

	TreeMap<String, Integer> readFileTxt(String filePathSymptoms) throws IOException {
		TreeMap<String, Integer> resultSymptom = new TreeMap<String, Integer>();

		try {
			BufferedReader readerSymptom = new BufferedReader(new FileReader(filePathSymptoms));
			// Counting occurrences for each symptom of the file "symptoms.txt",
			// alphabetical sorting
			String line = null;
			try {
				line = readerSymptom.readLine();
				while (line != null && !line.isEmpty()) {

					if (resultSymptom.containsKey(line)) {
						resultSymptom.put(line, (resultSymptom.get(line)) + 1);
					} else {
						resultSymptom.put(line, 1);
					}
					line = readerSymptom.readLine();
				}
			} finally {
				readerSymptom.close();
			}

		} catch (

		FileNotFoundException e) {
			System.out.println("File symptoms.txt unreachable");
			System.exit(-1);
		}
		return resultSymptom;
	}

	/**
	 * 2nd Step Put the result to a file "results.out.txt". <b>Generate a list</b>
	 * counting occurrences of each symptom string in it, <b>one per line</b>. If no
	 * data is available, return an empty List
	 * 
	 * @param filepathresults
	 * 
	 * @throws Exception FileNotFoundException if impossible to find folder to
	 *                   export results.out.txt
	 */

	@Override
	public void writeFileToTxt(String filePathSymptoms, String filePathResults) throws Exception {
		TreeMap<String, Integer> resultSymptom = readFileTxt(filePathSymptoms);
		writeFile(filePathResults, resultSymptom);
	}

	private void writeFile(String filePathResults, TreeMap<String, Integer> resultSymptom) throws Exception {

		try {

			FileWriter file = new FileWriter(filePathResults);
			BufferedWriter out = new BufferedWriter(file);

			for (Map.Entry<String, Integer> entry : resultSymptom.entrySet()) {
				out.write(entry.getKey() + "=" + entry.getValue());
				out.newLine();
			}
			out.flush();

			out.close();

		} catch (

		FileNotFoundException e) {
			System.out.println("Directory to create results.out.txt not found");
			System.exit(-1);
		}
		System.out.println("Finished");
	}

}