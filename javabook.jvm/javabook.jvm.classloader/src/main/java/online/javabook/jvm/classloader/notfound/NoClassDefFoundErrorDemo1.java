package online.javabook.jvm.classloader.notfound;

import online.javabook.jvm.classload1.MyClassA;
import online.javabook.jvm.classload1.MyClassB;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-10-30
 *
 */
public class NoClassDefFoundErrorDemo1 {

	public static void main(String[] args) {
		try{
			Class.forName("online.javabook.jvm.classload1.MyClassA").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
