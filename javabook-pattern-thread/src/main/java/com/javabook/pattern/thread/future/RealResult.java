package com.javabook.pattern.thread.future;


/**
 * 
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2015年7月19日
 *
 */
public class RealResult implements Result {
	
	/**
	 * 
	 */
	private final String content;

	/**
	 * @param count
	 * @param c
	 */
	public RealResult(int count, char c) {
		
		System.out.println("        making RealData(" + count + ", " + c + ") BEGIN");
		char[] buffer = new char[count];
		for (int index = 0; index < count; index++) {
			buffer[index] = c;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("        making RealData(" + count + ", " + c + ") END");
		this.content = new String(buffer);
	}

	public String getContent() {
		return content;
	}
}
