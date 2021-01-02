package online.javabook.reference;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class ReferenceTarget {

	public ReferenceTarget() {
	}

	protected void finalize() {
		System.out.println(">>>>>>>>>>当前引用目标[ " + this + " ]的finalize()方法被" + Thread.currentThread().getName() + "守护线程执行\n");
	}
}
