package online.javabook.jcu.unsafe;

import java.lang.reflect.Field;

/**
 * @author LuYang
 *
 */
public class ReflectionModle {

	private boolean booleanFiled;

	private byte byteFiled;

	private int intFiled;
	
	private long longFiled;
	
	private float floatFiled;
	
	private double doubleFiled;
	
	private String stringFiled;
	
	/**
	 * @return the booleanFiled
	 */
	public boolean getBooleanFiled() {
		return booleanFiled;
	}

	/**
	 * @param booleanFiled the booleanFiled to set
	 */
	public void setBooleanFiled(boolean booleanFiled) {
		this.booleanFiled = booleanFiled;
	}

	/**
	 * @return the byteFiled
	 */
	public byte getByteFiled() {
		return byteFiled;
	}

	/**
	 * @param byteFiled the byteFiled to set
	 */
	public void setByteFiled(byte byteFiled) {
		this.byteFiled = byteFiled;
	}

	/**
	 * @return the intFiled
	 */
	public int getIntFiled() {
		return intFiled;
	}

	/**
	 * @param intFiled the intFiled to set
	 */
	public void setIntFiled(int intFiled) {
		this.intFiled = intFiled;
	}

	/**
	 * @return the longFiled
	 */
	public long getLongFiled() {
		return longFiled;
	}

	/**
	 * @param longFiled the longFiled to set
	 */
	public void setLongFiled(long longFiled) {
		this.longFiled = longFiled;
	}

	/**
	 * @return the floatFiled
	 */
	public float getFloatFiled() {
		return floatFiled;
	}

	/**
	 * @param floatFiled the floatFiled to set
	 */
	public void setFloatFiled(float floatFiled) {
		this.floatFiled = floatFiled;
	}

	/**
	 * @return the doubleFiled
	 */
	public double getDoubleFiled() {
		return doubleFiled;
	}

	/**
	 * @param doubleFiled the doubleFiled to set
	 */
	public void setDoubleFiled(double doubleFiled) {
		this.doubleFiled = doubleFiled;
	}

	/**
	 * @return the stringFiled
	 */
	public String getStringFiled() {
		return stringFiled;
	}

	/**
	 * @param stringFiled the stringFiled to set
	 */
	public void setStringFiled(String stringFiled) {
		this.stringFiled = stringFiled;
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		
		Field byteFiled   = ReflectionModle.class.getDeclaredField("byteFiled");
		Field intFiled    = ReflectionModle.class.getDeclaredField("intFiled");
		Field longFiled   = ReflectionModle.class.getDeclaredField("longFiled");
		Field floatFiled  = ReflectionModle.class.getDeclaredField("floatFiled");
		Field doubleFiled = ReflectionModle.class.getDeclaredField("doubleFiled");
		
		System.out.println( MyUnsafe.getUnsafe().objectFieldOffset(byteFiled) );
		System.out.println( MyUnsafe.getUnsafe().objectFieldOffset(intFiled)  );
		System.out.println( MyUnsafe.getUnsafe().objectFieldOffset(longFiled)  );
		System.out.println( MyUnsafe.getUnsafe().objectFieldOffset(floatFiled)  );
		System.out.println( MyUnsafe.getUnsafe().objectFieldOffset(doubleFiled)  );
	}
}
