package online.javabook.pattern.thread.threadspecificstorage2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
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
