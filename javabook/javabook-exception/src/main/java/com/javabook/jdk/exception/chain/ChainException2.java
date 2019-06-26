/**
 * 
 */
package com.javabook.jdk.exception.chain;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-21
 *
 */
public class ChainException2 extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5363510938434907339L;

	/**
	 * @param string
	 * @param e
	 */
	public ChainException2(String string, Exception e) {
		super(string, e);
	}

}
