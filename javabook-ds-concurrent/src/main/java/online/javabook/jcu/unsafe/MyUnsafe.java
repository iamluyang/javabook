package online.javabook.jcu.unsafe;

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
	private static final Object unsafeObject;

	static {
		try {
			Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
			theUnsafeField.setAccessible(true);
			unsafeObject = theUnsafeField.get(Unsafe.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return
	 */
	public static Unsafe getUnsafe() {
		return ((Unsafe) unsafeObject);
	}

}
