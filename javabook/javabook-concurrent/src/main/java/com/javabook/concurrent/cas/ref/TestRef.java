package com.javabook.concurrent.cas.ref;

public class TestRef {

	/**
	 * @param total
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void testSet(int total) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		
		long testReflect = 0;
		long testUnsafe = 0;
		
		for (int i = 0; i < total; i++) {
			testReflect = testReflect + testReflectSet(total);
			testUnsafe  = testUnsafe  + testUnsafeSet(total);
		}
		
		for (int i = 0; i < total; i++) {			
			testUnsafe  = testUnsafe  + testUnsafeSet(total);
			testReflect = testReflect + testReflectSet(total);
		}
		
		System.out.println("TestRS:" + testReflect);
		System.out.println("testUS:" + testUnsafe);
	}
	
	/**
	 * @param total
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void testGet(int total) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		
		long testReflect = 0;
		long testUnsafe = 0;
		
		for (int i = 0; i < total; i++) {
			testReflect = testReflect + testReflectGet(total);
			testUnsafe  = testUnsafe  + testUnsafeGet(total);
		}
		
		for (int i = 0; i < total; i++) {			
			testUnsafe  = testUnsafe  + testUnsafeGet(total);
			testReflect = testReflect + testReflectGet(total);
		}
		
		System.out.println("TestRG:" + testReflect);
		System.out.println("testUG:" + testUnsafe);
	}
	
	/**
	 * @param total
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static long testReflectSet(int total) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		
		ClassDemo classDemo = new ClassDemo();
		
		long start = System.nanoTime();
		for (int i = 0; i < total; i++) {			
			ReflectionUtils.setValue(classDemo, "booleanFiled", true);
			ReflectionUtils.setValue(classDemo, "byteFiled", (byte)1);
			ReflectionUtils.setValue(classDemo, "intFiled", 1);
			ReflectionUtils.setValue(classDemo, "longFiled", 1);
			ReflectionUtils.setValue(classDemo, "floatFiled", 1);
			ReflectionUtils.setValue(classDemo, "doubleFiled", 1);
			ReflectionUtils.setValue(classDemo, "stringFiled", "");
		}
		long finish = System.nanoTime();
		return finish-start;
	}
	
	/**
	 * @param total
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static long testUnsafeSet(int total) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		
		ClassDemo classDemo = new ClassDemo();
		
		long start = System.nanoTime();
		for (int i = 0; i < total; i++) {			
			ReflectionUtils.setUnsafeValue(classDemo, "booleanFiled", true);
			ReflectionUtils.setUnsafeValue(classDemo, "byteFiled", (byte)1);
			ReflectionUtils.setUnsafeValue(classDemo, "intFiled", 1);
			ReflectionUtils.setUnsafeValue(classDemo, "longFiled", 1);
			ReflectionUtils.setUnsafeValue(classDemo, "floatFiled", 1);
			ReflectionUtils.setUnsafeValue(classDemo, "doubleFiled", 1);
			ReflectionUtils.setUnsafeValue(classDemo, "stringFiled", "");
		}
		long finish = System.nanoTime();
		return finish-start;				
	}
	
	/**
	 * @param total
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static long testReflectGet(int total) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		
		ClassDemo classDemo = new ClassDemo();
		
		long start = System.nanoTime();
		for (int i = 0; i < total; i++) {			
			ReflectionUtils.getValue(classDemo, "booleanFiled");
			ReflectionUtils.getValue(classDemo, "byteFiled");
			ReflectionUtils.getValue(classDemo, "intFiled");
			ReflectionUtils.getValue(classDemo, "longFiled");
			ReflectionUtils.getValue(classDemo, "floatFiled");
			ReflectionUtils.getValue(classDemo, "doubleFiled");
			ReflectionUtils.getValue(classDemo, "stringFiled");
		}
		long finish = System.nanoTime();
		return finish-start;
	}
	
	/**
	 * @param total
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static long testUnsafeGet(int total) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		
		ClassDemo classDemo = new ClassDemo();
		
		long start = System.nanoTime();
		for (int i = 0; i < total; i++) {			
			ReflectionUtils.getUnsafeValue(classDemo, "booleanFiled");
			ReflectionUtils.getUnsafeValue(classDemo, "byteFiled");
			ReflectionUtils.getUnsafeValue(classDemo, "intFiled");
			ReflectionUtils.getUnsafeValue(classDemo, "longFiled");
			ReflectionUtils.getUnsafeValue(classDemo, "floatFiled");
			ReflectionUtils.getUnsafeValue(classDemo, "doubleFiled");
			ReflectionUtils.getUnsafeValue(classDemo, "stringFiled");
		}
		long finish = System.nanoTime();
		return finish-start;				
	}
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		TestRef.testSet(1000);
		TestRef.testGet(1000);
	}
}
