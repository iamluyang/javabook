package online.javabook.jvm.classloader.notfound;

import online.javabook.jvm.classload1.MyClassA;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-10-30
 *
 */
public class NoClassDefFoundErrorDemo2 {

	public static void main(String[] args) {
		try{
			MyClassA myClassA = new MyClassA();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
