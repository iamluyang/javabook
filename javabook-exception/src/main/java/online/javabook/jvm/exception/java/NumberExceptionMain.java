package online.javabook.exception.java;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class NumberExceptionMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// java.lang.NumberFormatException
		try {
			Integer integer = new Integer("A");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
