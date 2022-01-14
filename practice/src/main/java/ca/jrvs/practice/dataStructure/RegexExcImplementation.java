package ca.jrvs.practice.dataStructure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExcImplementation implements RegexExc {

	@Override
	public boolean matchJpeg(String filename) {
		
		Pattern patternJpeg = Pattern.compile(".+\\.(jpg|jpeg)$", Pattern.CASE_INSENSITIVE);
		Matcher matchJpeg = patternJpeg.matcher(filename);
		boolean matchFound = matchJpeg.find();
		return matchFound;
	}

	@Override
	public boolean matchIp(String ip) {
		// TODO Auto-generated method stub
		Pattern patternIP = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
		Matcher matchIP = patternIP.matcher(ip);
		boolean matchFound = matchIP.find();
		return matchFound;
	}

	@Override
	public boolean isEmptyLine(String line) {
		// TODO Auto-generated method stub
		Pattern patternEmptyLine = Pattern.compile("\n");
		Matcher matchEmptyLine = patternEmptyLine.matcher(line);
		boolean matchFound = matchEmptyLine.find();
		return matchFound;
	}

}
