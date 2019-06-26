package com.javabook.pattern.thread.threadspecificstorage2;


/**
 * 
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2015年7月19日
 *
 */
public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new ClientThread("Alice").start();
		new ClientThread("Bobby").start();
		new ClientThread("Chris").start();
	}
}
