package online.javabook.jvm.classloader.notfound;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-10-30
 *
 */
public class NoClassDefFoundErrorDemo4 {

	public static void main(String[] args) {
		try {
			// The following line would throw ExceptionInInitializerError
			BadClass badClass = new BadClass();
		} catch (Throwable t) {
			System.out.println(t);
		}
		// The following line would cause NoClassDefFoundError
		BadClass badClass = new BadClass();
	}
}
