package online.javabook.jvm.classloader.notfound;

import online.javabook.a.ClassA;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-10-30
 *
 */
public class NoClassDefFoundErrorDemo {

	public static void main(String[] args) {
		try{
			ClassA a = new ClassA();
			Class clazz = Class.forName("online.javabook.a.ClassA");

			System.out.println(clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
