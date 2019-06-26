/**
 * 
 */
package com.javabook.jdk.exception.subclass;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-21
 *
 */
public class ExceptionParent2 extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7141293280806633333L;

	/**
	 * @param string
	 */
	public ExceptionParent2(String string) {
		super(string);
	}

	/**
	 * @param string
	 * @param e
	 */
	public ExceptionParent2(String string, Exception e) {
		super(string, e);
	}

}
