package com.javabook.jdk.exception.java;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class CloneableExceptionMain {

	public static void main(String[] args) {
		
		CloneableObject orig  = new CloneableObject(new String("luyang"));
		
		// java.lang.CloneNotSupportedException
		CloneableObject copy = (CloneableObject) orig.shallowCopy();
		
		System.out.println("orig:"+orig);
		System.out.println("copy:"+copy);
	}		
} 
