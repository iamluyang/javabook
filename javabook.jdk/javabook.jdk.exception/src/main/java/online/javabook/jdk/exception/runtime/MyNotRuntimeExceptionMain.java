package online.javabook.jdk.exception.runtime;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
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
