package online.javabook.jvm.exception.profile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class ExceptionProfile {

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
	public void start() {		
		start = System.currentTimeMillis();
	}

	/**
	 * @return the start
	 */
	public void stop(String name, long total) {
		finish = System.currentTimeMillis();
		time = finish-start;
		
		float avg = (float)time / total;
		System.out.println( name + " - total:" + sdf.format(new Date(time)).toString() + " avg:" + avg + " Millis" );
	}

}
