package online.javabook.io.bio;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class Perforamce {

	/**
	 * start
	 */
	private long start;
	
	/**
	 * finish
	 */
	private long finish;
	
	/**
	 * time
	 */
	private long time;
	
	/**
	 * sdf
	 */
	private SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSSS");

	/**
	 * @return the start
	 */
	public long start() {		
		start = System.currentTimeMillis();
		return start;
	}

	/**
	 * @return the start
	 */
	public long stop(String name) {
		finish = System.currentTimeMillis();
		time = finish-start;

		System.out.println( name + "total time: " + sdf.format(new Date(time)) );
		return time;
	}

}
