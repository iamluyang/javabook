package com.javabook.concurrent.cas.unsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

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
