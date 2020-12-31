package com.javabook.classloader.notfound;


import com.javabook.classloader.found.MyClass2;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-10-30
 *
 */
public class NoClassDefFoundErrorDemo {

	public static void main(String[] args) {
		try{
			MyClass2 class2 = new MyClass2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
