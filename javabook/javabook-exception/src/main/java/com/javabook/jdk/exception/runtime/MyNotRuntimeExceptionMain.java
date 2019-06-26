package com.javabook.jdk.exception.runtime;


/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-21
 *
 */
public class MyNotRuntimeExceptionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyRuntimeClass myRuntimeClass = new MyRuntimeClass();
						
		try {
			myRuntimeClass.throwNotRuntimeException();
		} catch (MyNotRuntimeException e) {
			e.printStackTrace();
		}
	}
}
