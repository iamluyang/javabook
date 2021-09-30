/**
 * 
 */
package online.javabook.jdk.exception.runtime;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class MyRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5260866014949691964L;

	/**
	 * @param string
	 */
	public MyRuntimeException(String string) {
		super(string);
	}

}
