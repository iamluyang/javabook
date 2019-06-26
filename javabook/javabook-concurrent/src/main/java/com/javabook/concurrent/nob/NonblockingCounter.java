package com.javabook.concurrent.nob;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * http://www.ibm.com/developerworks/cn/java/j-jtp04186/
 * 
 * 使用 CAS 的非阻塞算法,，非阻塞算法通常叫作乐观算法，因为它们继续操作的假设是不会有干扰。如果发现干扰，就会回退并重试。
 * 
 *<ul>底层实现
 *	<li> private static final Unsafe unsafe = Unsafe.getUnsafe();
 *	<li> return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
 *</ul>
 *
 *<ul>性能优势
 *	<li>它用硬件的原生形态代替 JVM 的锁定代码路径，从而在更细的粒度层次上（独立的内存位置）进行同步，失败的线程也可以立即重试，而不会被挂起后重新调度。
 *	<li>更细的粒度降低了争用的机会，不用重新调度就能重试的能力也降低了争用的成本。即使有少量失败的 CAS 操作，这种方法仍然会比由于锁争用造成的重新调度快得多。 
 *	<li>在轻度到中度的争用情况下，非阻塞算法的性能会超越阻塞算法，因为 CAS 的多数时间都在第一次尝试时就成功，而发生争用时的开销也不涉及线程挂起和上下文切换，只多了几个循环迭代。
 *	<li>没有争用的 CAS 要比没有争用的锁便宜得多（这个有些问题？？？），因为没有争用的锁涉及 CAS 加上额外的处理，而争用的 CAS 比争用的锁获取涉及更短的延迟。
 *</ul>
 * @author LuYang
 *
 */
public final class NonblockingCounter {

	// value
	private AtomicInteger value = new AtomicInteger();

	/**
	 * @return
	 */
	public int getValue() {
		return value.get();
	}

	/**
	 * @return
	 */
	public int increment() {

        for (;;) {
        	
        	// 取出当前的值
            int expect = value.get(); 
            
            // expect加1，next为希望得到的值
            int next = expect + 1; 
            
            // 比较并设置：
            // 情况1：如果这个时候没有线程T-B访问increment方法，即线程T-B不会修改value
            // 则线程T-A中的expect与原子value的当前值是相同的，则当前线程T-A写入next，以原子的方式完成这个程序块，并返回next
            
            // 情况1：如果这个时候有线程T-B进入了increment方法，但是还没来得及执行compareAndSet
            // 则线程T-A中的expect与原子value的当前值是相同的，则当前线程T-A写入next，以原子的方式完成这个程序块，并返回next
            
			// 情况3：如果这个时候还有线程T-B访问increment方法，即线程T-B在线程比线程T-A 先执行compareAndSet
		    // 则线程T-A中的expect与原子value当前的值是不同的，则当前线程T-A重新进入下一轮取值和递增操作，直到以原子的方式完成这个程序块            	            
            if (value.compareAndSet(expect, next)) 
                return next;
        }
    }
	
	public static void main(String[] args) {
		
		NonblockingCounter counter = new NonblockingCounter();
		System.out.println( counter.increment() );
		
	}
}
