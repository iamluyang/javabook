package com.javabook.pattern.thread.threadpermessage;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Host {
	
	/**
	 * action
	 */
	private final Request request = new Request();

	/**
	 * @param count
	 * @param c
	 */
	public void request(final int count, final char c) {
		
		System.out.println("	request(" + count + ", " + c + ") BEGIN");
		
		new Thread() {
			public void run() {
				request.handle(count, c);
			}
		}.start();

		System.out.println("	request(" + count + ", " + c + ") END");
	}
}
