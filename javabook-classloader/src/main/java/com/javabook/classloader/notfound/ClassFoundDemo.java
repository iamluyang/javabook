package com.javabook.classloader.notfound;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-10-30
 *
 */
public class ClassFoundDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.javabook.classloader.found.MyClass1");
			System.out.println("MainClassFound: is OK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
