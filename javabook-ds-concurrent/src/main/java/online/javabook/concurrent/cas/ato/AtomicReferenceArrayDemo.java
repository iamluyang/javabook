package online.javabook.concurrent.cas.ato;

import online.javabook.concurrent.cas.unsafe.MyUnsafe;
import sun.misc.Unsafe;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public final class AtomicReferenceArrayDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray<>();

		// referenceArray
		Object[] referenceArray = new Object[]{new Integer(0), new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5)};
		debug(referenceArray);
	}
	
	/**
	 * @param intArray2
	 */
	public static void debug(Object[] referenceArray) {
        
		// 通过反射方式返回Unsafe
	    Unsafe unsafe = MyUnsafe.getUnsafe();

	    // 获取用户给定数组寻址的换算因子。一个合适的换算因子不能返回的时候(例如：基本类型)，则返回0。
	    // 这个返回值能够与arrayBaseOffset一起使用去存取这个数组class中的元素
	    int referenceScale = unsafe.arrayIndexScale(Object[].class);  
	    
	    // 获取给定数组中第一个元素的偏移地址。为了存取数组中的元素，这个偏移地址与arrayIndexScale方法的非0返回值一起被使用
	    int referenceArrayBaseOffset  = unsafe.arrayBaseOffset(Object[].class);
	    
	    // intScale为2的n次方，intScale与（intScale-1）做 & 计算，可以实现校验
	    // 因为：4的二进制为 100 ，（3 - 1）的二进制为 011 ，而 100 & 011 = 0，则正确
        if ((referenceScale & (referenceScale - 1)) != 0) throw new Error("data type scale not a power of two");
        
        // numberOfLeadingZeros返回intScale这个数据的二进制串中从最左边算起连续的“0”的总数量
        // 因为：4的二进制为 100 ，numberOfLeadingZeros后为，int占4个字节，即32位，所以前端有29个连续0
        // 所以：31 - 29为2，intLeftShift表示左移的位数
	    int referenceLeftShift = 31 - Integer.numberOfLeadingZeros(referenceScale);

		System.out.println("Offset [ArrayBaseOffset:\t"	+ referenceArrayBaseOffset + "\tScale:\t" + referenceScale + "\tShift:\t" + referenceLeftShift + "]");
		
	    // 计算每个数组元素的偏移量	，intArrayBaseOffset为数组索引为0的元素的位置
	    
	    // 计算数组索引为0的元素的偏移量，因此((long) 0 << intLeftShift)为0即可，相当于 0 * 2^2 = 0	    
	    long referenceByteOffset0 = ((long) 0 << referenceLeftShift) + referenceArrayBaseOffset;
	    
	    // 计算数组索引为1的元素的偏移量，由1左移两位并加上第一个元素的偏移量，相当于 1 * 2^2 = 4
	    long referenceByteOffset1 = ((long) 1 << referenceLeftShift) + referenceArrayBaseOffset;
	    
	    // 计算数组索引为2的元素的偏移量，由2左移两位并加上第一个元素的偏移量，相当于 2 * 2^2 = 8
	    long referenceByteOffset2 = ((long) 2 << referenceLeftShift) + referenceArrayBaseOffset;
	    
	    // 计算数组索引为3的元素的偏移量，由3左移两位并加上第一个元素的偏移量，相当于 3 * 2^2 = 12
	    long referenceByteOffset3 = ((long) 3 << referenceLeftShift) + referenceArrayBaseOffset;
	    
	    // 计算数组索引为4的元素的偏移量，由4左移两位并加上第一个元素的偏移量，相当于 4 * 2^2 = 16
	    long referenceByteOffset4 = ((long) 4 << referenceLeftShift) + referenceArrayBaseOffset;
	    
	    // 换句话说每个元素相对索引为0的元素的偏移量可以通过如上二进制计算，等同于如上的十进制计算
	    long referenceByteOffset5 = ((long) 5 << referenceLeftShift) + referenceArrayBaseOffset;
	    
		System.out.println("ByteOffset [intByteOffset0:\t" + referenceByteOffset0
				+ "\treferenceByteOffset1:\t" + referenceByteOffset1
				+ "\treferenceByteOffset2:\t" + referenceByteOffset2
				+ "\treferenceByteOffset3:\t" + referenceByteOffset3
				+ "\treferenceByteOffset4:\t" + referenceByteOffset4
				+ "\treferenceByteOffset5:\t" + referenceByteOffset5 + "]");
		
	    
		Object arrayElement0 = unsafe.getObjectVolatile(referenceArray, referenceByteOffset0);
	     
		Object arrayElement1 = unsafe.getObjectVolatile(referenceArray, referenceByteOffset1);
	     
		Object arrayElement2 = unsafe.getObjectVolatile(referenceArray, referenceByteOffset2);
	     
		Object arrayElement3 = unsafe.getObjectVolatile(referenceArray, referenceByteOffset3);
	     
		Object arrayElement4 = unsafe.getObjectVolatile(referenceArray, referenceByteOffset4);
	     
		Object arrayElement5 = unsafe.getObjectVolatile(referenceArray, referenceByteOffset5);
	     	    
		System.out.println("ArrayElement [arrayElement0:\t " + arrayElement0
				+ "\tarrayElement1:\t"  + arrayElement1 
				+ "\tarrayElement2:\t"  + arrayElement2
				+ "\tarrayElement3:\t " + arrayElement3
				+ "\tarrayElement4:\t"  + arrayElement4 
				+ "\tarrayElement5:\t"	+ arrayElement5 + "]");
	}
}
