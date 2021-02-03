package com.hemebiotech.analytics;

/**
 * Anything that will read symptom data from a source The important part is, the
 * return value from the operation, which is a list of strings, that may contain
 * many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {

	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 * 
	 * @param filePathSymptoms
	 *
	 */
	void getSymptoms(String filePathSymptoms) throws Exception;

	/**
	 * @param filePathSymptoms
	 * @param filePathResults
	 * @throws Exception
	 */
	void writeFileToTxt(String filePathSymptoms, String filePathResults) throws Exception;
}
