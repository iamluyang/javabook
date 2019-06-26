package com.javabook.classloader.found;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-10-30
 *
 */
public class MainClassNotFoundException {

	public static void main(String[] args) {

		try {
			Class.forName("com.javabook.classloader.found.NotExistingClass");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
