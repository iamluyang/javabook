package com.javabook.pattern.thread.threadspecificstorage2;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * 
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2015年7月19日
 *
 */
public class TSLog {
	
	/**
	 * writer
	 */
	private PrintWriter writer = null;

	/**
	 * @param filename
	 */
	public TSLog(String filename) {
		try {
			writer = new PrintWriter(new FileWriter(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param s
	 */
	public void println(String s) {
		System.out.println(s);
		writer.println(s);
	}

	/**
	 * 
	 */
	public void close() {
		writer.println("==== End of log ====");
		writer.close();
	}
}
