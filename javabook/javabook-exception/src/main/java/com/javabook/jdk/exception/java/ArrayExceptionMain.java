package com.javabook.jdk.exception.java;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-21
 *
 */
public class ArrayExceptionMain {

	public static void main(String[] args) {
						
		// java.lang.ArrayIndexOutOfBoundsException
		try {
			Integer[] arrayIndexOutOfBounds = new Integer[10];
			System.out.println( arrayIndexOutOfBounds[11] );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// java.lang.NegativeArraySizeException
		try {
			Integer[] negativeArraySize = new Integer[-1];
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// java.lang.ArrayStoreException
		try {
			Object[] arrayStore = new Integer[10];
			arrayStore[0] = new String();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
