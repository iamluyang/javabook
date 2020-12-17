/**
 * 
 */
package com.javabook.jdk.exception.subclass;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015-1-28
 *
 */
public class ExceptionChild2ExtendsExceptionParent2 extends ExceptionParent2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1708312175678602946L;
	
	/**
	 * @param string
	 */
	public ExceptionChild2ExtendsExceptionParent2(String string) {
		super(string);
	}
	
	/**
	 * @param string
	 * @param e
	 */
	public ExceptionChild2ExtendsExceptionParent2(String string, Exception e) {
		super(string, e);
	}
}
