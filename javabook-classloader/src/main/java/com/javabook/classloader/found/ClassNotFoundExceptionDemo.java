package com.javabook.classloader.found;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-10-30
 *
 */
public class ClassNotFoundExceptionDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.javabook.classloader.found.NotExistingClass");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
