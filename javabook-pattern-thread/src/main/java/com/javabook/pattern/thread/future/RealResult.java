package com.javabook.pattern.thread.future;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class RealResult extends ResultWithListener {
	
	/**
	 * 
	 */
	private final String content;

	public RealResult(String string) {

		content = string.toLowerCase();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
	}

	public String getContent() {
		return content;
	}
}
