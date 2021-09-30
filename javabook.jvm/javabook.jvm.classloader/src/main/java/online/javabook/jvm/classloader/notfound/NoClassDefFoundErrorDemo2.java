package online.javabook.jvm.classloader.notfound;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-10-30
 *
 */
public class NoClassDefFoundErrorDemo2 {

	public static void main(String[] args) {
		try{
			//MyClassA myClassA = new MyClassA();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
