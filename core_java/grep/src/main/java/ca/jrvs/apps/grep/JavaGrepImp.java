/**
 * @Author Braikhna Yousafzai
 * Java Grep Implementation
 */
package ca.jrvs.apps.grep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.BasicConfigurator;

public class JavaGrepImp implements JavaGrep {

	private final Logger logger = LoggerFactory.getLogger(JavaGrepImp.class);
	private String regex;
	private String rootPath;
	private String outFile;

	@Override
	public void process() throws IOException {
		List<String> matchedLines = new ArrayList<>();
		String rootDir = getRootPath();
		for (File file : listFiles(rootDir)){
			for (String line : readLines(file)){
				if (containsPattern(line))
					matchedLines.add(line);
			}
		}
		writeToFile(matchedLines);

	}

	@Override
	public List<File> listFiles(String rootDir) {
		
		List<File> files = new ArrayList<>();
		File dir = new File(rootDir);
		
		File[] children;
		
		if (dir.isDirectory()) {
			children = dir.listFiles();
			if (children != null) {
				for (File file : children) {
					if (file.isDirectory()) { 
						String newDir = file.getName();
						files = listFiles(dir + "/" + newDir);
					}
					else {
						files.add(file);
					}
				}
			}
		}
		else {
			files.add(dir);
		}
		
		return files;
	}

	@Override
	public List<String> readLines(File inputFile) {
		List<String> lines = new ArrayList<>();
		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
			while (reader.ready()){
				line = reader.readLine();
				lines.add(line);
			}
		} catch (IOException ex){
			logger.error(ex.getMessage());
		}
		return lines;
	}

	@Override
	public boolean containsPattern(String line) {
		String regex = getRegex();
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(line);
		return match.find();
	}

	@Override
	public void writeToFile(List<String> lines) throws IOException {
		String outfile = getOutFile();
		FileWriter writer = new FileWriter(outfile);
			for (String line : lines) {
				try {
					writer.write(line + "\n");
				}catch (IOException ex) {
					logger.error(ex.getMessage());
				}
			}
			writer.close();

	}
	/**
	 * @return the regex
	 */
	public String getRegex() {
		return regex;
	}

	/**
	 * @param regex the regex to set
	 */
	public void setRegex(String regex) {
		this.regex = regex;
	}

	/**
	 * @return the rootPath
	 */
	public String getRootPath() {
		return rootPath;
	}

	/**
	 * @param rootPath the rootPath to set
	 */
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	/**
	 * @return the outFile
	 */
	public String getOutFile() {
		return outFile;
	}

	/**
	 * @param outFile the outFile to set
	 */
	public void setOutFile(String outFile) {
		this.outFile = outFile;
	}

	public static void main(String[] args) {

		BasicConfigurator.configure();

		if (args.length != 3)
			throw new IllegalArgumentException("Usage: regex root_directory outfile");
		JavaGrepImp javaGrep = new JavaGrepImp();
		javaGrep.setRegex(args[0]);
		javaGrep.setRootPath(args[1]);
		javaGrep.setOutFile(args[2]);

		try {
			javaGrep.process();
		} catch(IOException ex){
			javaGrep.logger.error(ex.getMessage());
		}


	}
}
