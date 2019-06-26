package com.javabook.bio.profile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-21
 *
 */
public class Profile {

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
	public long stop(String name, long total) {
		finish = System.currentTimeMillis();
		time = finish-start;
		start = finish;
		
		long avg = time / total;
		System.out.println( name + ":" + sdf.format(new Date(time)).toString() + "-avg:" + sdf.format(new Date(avg)).toString() );
		return time;
	}

}
