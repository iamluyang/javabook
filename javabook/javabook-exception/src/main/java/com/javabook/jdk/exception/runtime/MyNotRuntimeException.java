/**
 * 
 */
package com.javabook.jdk.exception.runtime;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-21
 *
 */
public class MyNotRuntimeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5363510938434907339L;

	/**
	 * @param string
	 */
	public MyNotRuntimeException(String string) {
		super(string);
	}

}
