package com.javabook.pattern.thread.readwritelock2;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class ReaderThread extends Thread {
	
	/**
	 * resource
	 */
	private final Resource resource;

	/**
	 * @param data
	 */
	public ReaderThread(Resource resource) {
		this.resource = resource;
	}

	public void run() {
		
		long beg = System.currentTimeMillis();
		
		try {
			while (true) {
				char[] readbuf = resource.read();
				System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readbuf));
				
				if(readbuf[0]=='z' || readbuf[0]=='Z') {
					long end = System.currentTimeMillis();
					System.out.println(end - beg);
					return;
				}
			}
		} catch (InterruptedException e) {
			
		}

	}
}
