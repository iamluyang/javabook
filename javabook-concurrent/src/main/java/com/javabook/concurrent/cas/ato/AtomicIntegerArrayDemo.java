package com.javabook.concurrent.cas.ato;

import sun.misc.Unsafe;

import com.javabook.concurrent.cas.unsafe.MyUnsafe;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public final class AtomicIntegerArrayDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(3);

		// integerArray
		int[] intArray = new int[]{0, 1, 2, 3, 4, 5};
		debug(intArray);
	}
	
	/**
	 * @param intArray2
	 */
	public static <T> void debug(int[] intArray) {

		// 通过反射方式返回Unsafe
	    Unsafe unsafe = MyUnsafe.getUnsafe();

	    // 获取用户给定数组寻址的换算因子。一个合适的换算因子不能返回的时候(例如：基本类型)，则返回0。
	    // 这个返回值能够与arrayBaseOffset一起使用去存取这个数组class中的元素
	    int intScale = unsafe.arrayIndexScale(int[].class);  
	    
	    // 获取给定数组中第一个元素的偏移地址。为了存取数组中的元素，这个偏移地址与arrayIndexScale方法的非0返回值一起被使用
	    int intArrayBaseOffset  = unsafe.arrayBaseOffset(int[].class);
	    
	    // intScale为2的n次方，intScale与（intScale-1）做 & 计算，可以实现校验
	    // 因为：4的二进制为 100 ，（3 - 1）的二进制为 011 ，而 100 & 011 = 0，则正确
        if ((intScale & (intScale - 1)) != 0) throw new Error("data type scale not a power of two");
        
        // numberOfLeadingZeros返回intScale这个数据的二进制串中从最左边算起连续的“0”的总数量
        // 因为：4的二进制为 100 ，numberOfLeadingZeros后为，int占4个字节，即32位，所以前端有29个连续0
        // 所以：31 - 29为2，intLeftShift表示左移的位数
	    int intLeftShift = 31 - Integer.numberOfLeadingZeros(intScale);

		System.out.println("Offset [ArrayBaseOffset:\t"	+ intArrayBaseOffset + "\tScale:\t" + intScale + "\tShift:\t" + intLeftShift + "]");
		
	    // 计算每个数组元素的偏移量	，intArrayBaseOffset为数组索引为0的元素的位置
	    
	    // 计算数组索引为0的元素的偏移量，因此((long) 0 << intLeftShift)为0即可，相当于 0 * 2^2 = 0	    
	    long intByteOffset0 = ((long) 0 << intLeftShift) + intArrayBaseOffset;
	    
	    // 计算数组索引为1的元素的偏移量，由1左移两位并加上第一个元素的偏移量，相当于 1 * 2^2 = 4
	    long intByteOffset1 = ((long) 1 << intLeftShift) + intArrayBaseOffset;
	    
	    // 计算数组索引为2的元素的偏移量，由2左移两位并加上第一个元素的偏移量，相当于 2 * 2^2 = 8
	    long intByteOffset2 = ((long) 2 << intLeftShift) + intArrayBaseOffset;
	    
	    // 计算数组索引为3的元素的偏移量，由3左移两位并加上第一个元素的偏移量，相当于 3 * 2^2 = 12
	    long intByteOffset3 = ((long) 3 << intLeftShift) + intArrayBaseOffset;
	    
	    // 计算数组索引为4的元素的偏移量，由4左移两位并加上第一个元素的偏移量，相当于 4 * 2^2 = 16
	    long intByteOffset4 = ((long) 4 << intLeftShift) + intArrayBaseOffset;
	    
	    // 换句话说每个元素相对索引为0的元素的偏移量可以通过如上二进制计算，等同于如上的十进制计算
	    long intByteOffset5 = ((long) 5 << intLeftShift) + intArrayBaseOffset;
	    
		System.out.println("ByteOffset [intByteOffset0:\t" + intByteOffset0
				+ "\tintByteOffset1:\t" + intByteOffset1
				+ "\tintByteOffset2:\t" + intByteOffset2
				+ "\tintByteOffset3:\t" + intByteOffset3
				+ "\tintByteOffset4:\t" + intByteOffset4
				+ "\tintByteOffset5:\t" + intByteOffset5 + "]");
		
	    
	    int arrayElement0 = unsafe.getIntVolatile(intArray, intByteOffset0);
	     
	    int arrayElement1 = unsafe.getIntVolatile(intArray, intByteOffset1);
	     
	    int arrayElement2 = unsafe.getIntVolatile(intArray, intByteOffset2);
	     
	    int arrayElement3 = unsafe.getIntVolatile(intArray, intByteOffset3);
	     
	    int arrayElement4 = unsafe.getIntVolatile(intArray, intByteOffset4);
	     
	    int arrayElement5 = unsafe.getIntVolatile(intArray, intByteOffset5);
	     	    
		System.out.println("ArrayElement [arrayElement0:\t " + arrayElement0
				+ "\tarrayElement1:\t"  + arrayElement1 
				+ "\tarrayElement2:\t"  + arrayElement2
				+ "\tarrayElement3:\t " + arrayElement3
				+ "\tarrayElement4:\t"  + arrayElement4 
				+ "\tarrayElement5:\t"	+ arrayElement5 + "]");
	}
}
