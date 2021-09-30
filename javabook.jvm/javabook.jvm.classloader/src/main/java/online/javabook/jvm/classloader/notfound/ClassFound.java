package online.javabook.jvm.classloader.notfound;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-10-30
 *
 */
public class ClassFound {

	public static void main(String[] args) {
		try {
			Class.forName("online.javabook.jvm.classload1.MyClass1");
			System.out.println("MyClass1 is found: is OK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
