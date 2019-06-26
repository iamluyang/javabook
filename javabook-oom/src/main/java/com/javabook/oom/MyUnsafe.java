package com.javabook.oom;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-22
 * 
 */
@SuppressWarnings("restriction")
public class MyUnsafe {

	/**
	 * unsafeObject
	 */
	private static final Object unsafeObject;
	
    /**
     * maxMemoryField
     */
    static Field maxMemoryField;
    
    /**
     * reservedMemoryField
     */
    static Field reservedMemoryField;
    
    /**
     * BASE
     */
    static long BASE;
    
    /**
     * SCALE
     */
    static int SCALE;
    
    /**
     * SHIFT
     */
    static int SHIFT;
    
	static {

		try {
			// unsafeField
			Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
			unsafeField.setAccessible(true);
			unsafeObject = unsafeField.get(Unsafe.class);
			
			// bits
			Class bits = Class.forName("java.nio.Bits");
			
			// maxMemoryField
			maxMemoryField = bits.getDeclaredField("maxMemory");
			maxMemoryField.setAccessible(true);
			
			// reservedMemoryField
			reservedMemoryField = bits.getDeclaredField("reservedMemory");
			reservedMemoryField.setAccessible(true);
			
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
	
	/**
	 * @return
	 */
	public static Long getMaxMemory() {
		try {
			return (Long) maxMemoryField.get(null);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return (long) 0;
	}
	
	
	/**
	 * @return
	 */
	public static Number getReservedMemory() {
		try {
			return (Number) reservedMemoryField.get(null);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return (long) 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(MyUnsafe.getReservedMemory());
	}
}
