package online.javabook.jvm.classloader.notfound;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-10-30
 *
 */
public class ClassNotFoundExceptionDemo {

	public static void main(String[] args) {
		try {
			Class.forName("online.javabook.jvm.classload4.MyClass4");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
