package online.javabook.jvm.classloader.notfound;

import online.javabook.jvm.classload1.MyClassA;
import online.javabook.jvm.classload1.MyClassB;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-10-30
 *
 */
public class NoClassDefFoundErrorDemo3 {

	public static void main(String[] args) {
		try{
			MyClassB myClassB = new MyClassB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
