package online.javabook.jvm.thread.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author LuYang
 * 
 */
@SuppressWarnings("restriction")
public class MyUnsafe {

	/**
	 * unsafeObject
	 */
	private static final Unsafe unsafeObject;

	static {
		try {
			Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
			theUnsafeField.setAccessible(true);
			unsafeObject = (Unsafe)theUnsafeField.get(Unsafe.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return
	 */
	public static Unsafe getUnsafe() {
		return unsafeObject;
	}

}
