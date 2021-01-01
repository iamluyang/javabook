/**
 * 
 */
package online.javabook.exception.subclass;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class ExceptionParent1 extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5944780109632917073L;

	/**
	 * @param string
	 */
	public ExceptionParent1(String string) {
		super(string);
	}

	/**
	 * @param string
	 * @param e
	 */
	public ExceptionParent1(String string, Exception e) {
		super(string, e);
	}

}
