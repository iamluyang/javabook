package online.javabook.design.thread.threadspecificstorage1;

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
public class Log {
	
	/**
	 * writer
	 */
	private static PrintWriter writer = null;

	static {
		try {
			writer = new PrintWriter(new FileWriter("log.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param s
	 */
	public static void println(String s) {
		System.out.println(s);
		writer.println(s);
	}

	/**
	 * 
	 */
	public static void close() {
		writer.println("==== End of log ====");
		writer.close();
	}
}
