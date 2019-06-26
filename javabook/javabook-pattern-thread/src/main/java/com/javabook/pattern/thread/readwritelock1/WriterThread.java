package com.javabook.pattern.thread.readwritelock1;

import java.util.Random;


/**
 * 
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2015年7月19日
 *
 */
public class WriterThread extends Thread {
	
	/**
	 * random
	 */
	private static final Random random = new Random();
	
	/**
	 * resource
	 */
	private final Resource resource;
	
	/**
	 * filler
	 */
	private final String filler;

	/**
	 * @param resource
	 * @param filler
	 */
	public WriterThread(Resource resource, String filler) {
		this.resource = resource;
		this.filler   = filler;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		try {
			for(int index=0; index<filler.length(); index++){
				char c = nextchar(index);
				resource.write(c);
				Thread.sleep(random.nextInt(3000));
			}
		} catch (InterruptedException e) {
		}
	}

	/**
	 * @return
	 */
	private char nextchar(int index) {
		char c = filler.charAt(index);
		index++;
		if (index >= filler.length()) {
			index = 0;
		}
		return c;
	}
}
