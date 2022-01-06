package ca.jrvs.apps.grep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface JavaGrep { 
	
	/**
	 * Top level search workflow
	 * @throws IOException
	 */
	void process() throws IOException;
	
	/**
	 * Traverse a given directory and return all files
	 * @param rootDir input directory
	 * @return files under the rootDir
	 */
	List<File> listFiles(String rootDir);
	
	/**
	 * Read a file and return all lines
	 * @param inputFile file to be read 
	 * @return lines all lines in the file
	 * @throws FileNotFoundException if a given inputFile is not a file
	 */
	List<String> readLines(File inputFile) throws FileNotFoundException;
	
	/**
	 * check if a line contains the regex pattern specified by user
	 * @param line input string
	 * @return true if there is a match
	 */
	boolean containsPattern(String line);
	
	/**
	 * Write lines with a match to the regex pattern to a file 
	 * @param lines matched strings to be written 
	 * @throws IOException if write failed
	 */
	void writeToFile(List<String> lines) throws IOException;
	
	String getRootPath();
	
	void setRootPath(String rootPath);
	
	String getRegex();
	
	void setRegex(String regex);
	
	String getOutFile();
	
	void setOutFile(String outFile);
}