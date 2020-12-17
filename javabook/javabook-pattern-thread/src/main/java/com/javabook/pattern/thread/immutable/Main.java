package com.javabook.pattern.thread.immutable;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		Person alice = new Person("Alice", "Alaska");
		
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
		new PrintPersonThread(alice).start();
	}
}
