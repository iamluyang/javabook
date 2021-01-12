package online.javabook.concurrent.cas.ato;

import online.javabook.concurrent.cas.unsafe.MyUnsafe;
import sun.misc.Unsafe;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public final class AtomicLongArrayDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//AtomicLongArray atomicLongArray = new AtomicLongArray();

		// longArray
		long[] longArray = new long[]{0, 1, 2, 3, 4, 5};
		
		debug(longArray);
	}
	
	/**
	 * @param longArray
	 */
	public static void debug(long[] longArray) {

		// 通过反射方式返回Unsafe
	    Unsafe unsafe = MyUnsafe.getUnsafe();

	    // 获取用户给定数组寻址的换算因子。一个合适的换算因子不能返回的时候(例如：基本类型)，则返回0。
	    // 这个返回值能够与arrayBaseOffset一起使用去存取这个数组class中的元素
	    int longScale = unsafe.arrayIndexScale(long[].class);  
	    
	    // 获取给定数组中第一个元素的偏移地址。为了存取数组中的元素，这个偏移地址与arrayIndexScale方法的非0返回值一起被使用
	    int longArrayBaseOffset  = unsafe.arrayBaseOffset(long[].class);
	    
	    // intScale为2的n次方，intScale与（intScale-1）做 & 计算，可以实现校验
	    // 因为：4的二进制为 100 ，（3 - 1）的二进制为 011 ，而 100 & 011 = 0，则正确
        if ((longScale & (longScale - 1)) != 0) throw new Error("data type scale not a power of two");
        
        // numberOfLeadingZeros返回intScale这个数据的二进制串中从最左边算起连续的“0”的总数量
        // 因为：4的二进制为 100 ，numberOfLeadingZeros后为，int占4个字节，即32位，所以前端有29个连续0
        // 所以：31 - 29为2，intLeftShift表示左移的位数
	    int longLeftShift = 31 - Integer.numberOfLeadingZeros(longScale);

		System.out.println("Offset [ArrayBaseOffset:\t"	+ longArrayBaseOffset + "\tScale:\t" + longScale + "\tShift:\t" + longLeftShift + "]");
		
	    // 计算每个数组元素的偏移量	，intArrayBaseOffset为数组索引为0的元素的位置
	    
	    // 计算数组索引为0的元素的偏移量，因此((long) 0 << intLeftShift)为0即可，相当于 0 * 2^2 = 0	    
	    long longByteOffset0 = ((long) 0 << longLeftShift) + longArrayBaseOffset;
	    
	    // 计算数组索引为1的元素的偏移量，由1左移两位并加上第一个元素的偏移量，相当于 1 * 2^2 = 4
	    long longByteOffset1 = ((long) 1 << longLeftShift) + longArrayBaseOffset;
	    
	    // 计算数组索引为2的元素的偏移量，由2左移两位并加上第一个元素的偏移量，相当于 2 * 2^2 = 8
	    long longByteOffset2 = ((long) 2 << longLeftShift) + longArrayBaseOffset;
	    
	    // 计算数组索引为3的元素的偏移量，由3左移两位并加上第一个元素的偏移量，相当于 3 * 2^2 = 12
	    long longByteOffset3 = ((long) 3 << longLeftShift) + longArrayBaseOffset;
	    
	    // 计算数组索引为4的元素的偏移量，由4左移两位并加上第一个元素的偏移量，相当于 4 * 2^2 = 16
	    long longByteOffset4 = ((long) 4 << longLeftShift) + longArrayBaseOffset;
	    
	    // 换句话说每个元素相对索引为0的元素的偏移量可以通过如上二进制计算，等同于如上的十进制计算
	    long longByteOffset5 = ((long) 5 << longLeftShift) + longArrayBaseOffset;
	    
		System.out.println("ByteOffset [intByteOffset0:\t" + longByteOffset0
				+ "\tlongByteOffset1:\t" + longByteOffset1
				+ "\tlongByteOffset2:\t" + longByteOffset2
				+ "\tlongByteOffset3:\t" + longByteOffset3
				+ "\tlongByteOffset4:\t" + longByteOffset4
				+ "\tlongByteOffset5:\t" + longByteOffset5 + "]");
		
	    
	    int arrayElement0 = unsafe.getIntVolatile(longArray, longByteOffset0);
	     
	    int arrayElement1 = unsafe.getIntVolatile(longArray, longByteOffset1);
	     
	    int arrayElement2 = unsafe.getIntVolatile(longArray, longByteOffset2);
	     
	    int arrayElement3 = unsafe.getIntVolatile(longArray, longByteOffset3);
	     
	    int arrayElement4 = unsafe.getIntVolatile(longArray, longByteOffset4);
	     
	    int arrayElement5 = unsafe.getIntVolatile(longArray, longByteOffset5);
	     	    
		System.out.println("ArrayElement [arrayElement0:\t " + arrayElement0
				+ "\tarrayElement1:\t"  + arrayElement1 
				+ "\tarrayElement2:\t"  + arrayElement2
				+ "\tarrayElement3:\t " + arrayElement3
				+ "\tarrayElement4:\t"  + arrayElement4 
				+ "\tarrayElement5:\t"	+ arrayElement5 + "]");
	}
}
