package ca.jrvs.practice.dataStructure; 

public interface RegexExc{
	/**
	 * return true if filename extension is jpg or jpeg (case insensitive)
	 * @param filename
	 * @return
	 */
	public boolean matchJpeg(String filename);
	
	/**
	 * return true if IP is valid 
	 * IP address range is 0.0.0.0 to 999.999.999.999
	 * @param ip 
	 * @return
	 */
	public boolean matchIp(String ip);
	
	/**
	 * return true if line is empty (eg: empty, white space, tabs, etc)
	 * @param line 
	 * @return
	 */
	public boolean isEmptyLine(String line);
}