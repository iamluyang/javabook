/**
 * 
 */
package online.javabook.jvm.exception.subclass;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class ClassChild extends ClassParent {

	@Override
	public void throwParentException1() throws ExceptionParent1/*, ExceptionParent2*/ {

	}
	
	@Override
	public void throwParentException2() throws ExceptionChild2ExtendsExceptionParent2 {

	}
}
