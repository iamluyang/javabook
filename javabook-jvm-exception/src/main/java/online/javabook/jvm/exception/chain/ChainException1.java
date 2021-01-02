/**
 * 
 */
package online.javabook.jvm.exception.chain;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class ChainException1 extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5363510938434907339L;

	/**
	 * @param string
	 * @param e
	 */
	public ChainException1(String string) {
		super(string);
	}

	/**
	 * @param string
	 * @param e
	 */
	public ChainException1(String string, Exception e) {
		super(string, e);
	}

}
