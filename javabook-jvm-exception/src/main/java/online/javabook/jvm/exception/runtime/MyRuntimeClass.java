package online.javabook.jvm.exception.runtime;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class MyRuntimeClass {

	/**
	 * 
	 */
	public void throwRuntimeException() {		
		throw new MyRuntimeException("Hi i am MyRuntimeException.");
	}		
	
	/**
	 * @throws MyNotRuntimeException
	 */
	public void throwNotRuntimeException() throws MyNotRuntimeException {		
		throw new MyNotRuntimeException("Hi i am MyNotRuntimeException.");
	}	

}
