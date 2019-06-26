package com.javabook.concurrent.coll.priority;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 技术特性
 * 1- 数据结构：一个无界阻塞队列，它使用与类 PriorityQueue 相同的顺序规则，并且提供了阻塞获取操作。
 * 2- 容器边界：虽然此队列逻辑上是无界的，但是资源被耗尽时试图执行 add 操作也将失败（导致 OutOfMemoryError）。
 * 3- 数据要求：此类不允许使用 null 元素。依赖自然顺序的优先级队列也不允许插入不可比较的对象（这样做会导致抛出 ClassCastException）。  
 * 4- 阻塞性质：大多数操作都以固定时间运行（不计阻塞消耗的时间）。
 *                    异常包括 remove、removeFirstOccurrence、removeLastOccurrence、contains、iterator.remove() 以及批量操作，它们均以线性时间运行。 
 *                    
 * 5- 排序策略： 在此类上进行的操作不保证具有同等优先级的元素的顺序。
 * 					   如果需要实施某一排序，那么可以定义自定义类或者比较器，比较器可使用修改键断开主优先级值之间的联系。
 * 					   例如，以下是应用先进先出 (first-in-first-out) 规则断开可比较元素之间联系的一个类。
 * 					   要使用该类，则需要插入一个新的 FIFOEntry(anEntry) 来替换普通的条目对象。 
 *     
 *  构造函数
 *  PriorityBlockingQueue()
 *  	 用默认的初始容量 (11) 创建一个 PriorityBlockingQueue，并根据元素的自然顺序对其元素进行排序。
 *  
 *  PriorityBlockingQueue(Collection<? extends E> c) 
 *  	创建一个包含指定 collection 元素的 PriorityBlockingQueue。
 *  
 *  PriorityBlockingQueue(int capacity)
 *  	使用指定的初始容量创建一个 PriorityBlockingQueue，并根据元素的自然顺序对其元素进行排序。
 *  
 * PriorityBlockingQueue(int initialCapacity, Comparator<? super E> comparator) 
 *         使用指定的初始容量创建一个 PriorityBlockingQueue，并根据指定的比较器对其元素进行排序。
 
 *  重要方法
 *  
 *  
 *  扩容机制 
 *  	
 *  private void tryGrow(Object[] array, int oldCap) - 扩容时需上锁
 *  
 *  数据结构 
 *              
 *     			 - Object[] queue
 *               - size         
 *               - Comparator<? super E> comparator
 *               - ReentrantLock lock
 *               - Condition notEmpty
 *               - volatile int allocationSpinLock 自旋锁
 *               - PriorityQueue q
 *                     
 *  算法实现
 *  			算法实现上和PriorityQueue是一样的，PriorityQueue的代码更紧凑一些
 *  
 * private static <T> void siftUpComparable(int k, T x, Object[] array)
 * 
 * private static <T> void siftUpUsingComparator(int k, T x, Object[] array, Comparator<? super T> cmp)
 * 
 * private static <T> void siftDownComparable(int k, T x, Object[] array, int n)
 * 
 * private static <T> void siftDownUsingComparator(int k, T x, Object[] array, int n, Comparator<? super T> cmp)
 *    
 * @author LuYang
 *
 */
public class PriorityBlockingQueueDemo {

	public static void main(String[] args) {
		PriorityBlockingQueue q = new PriorityBlockingQueue();
		/*ArrayBlockingQueue, 
		DelayQueue, 
		LinkedBlockingDeque, 
		LinkedBlockingQueue, 
		PriorityBlockingQueue, 
		SynchronousQueue*/ 	
		
		/*ArrayBlockingQueue, 
		ConcurrentLinkedQueue, 
		DelayQueue, 
		LinkedBlockingDeque, 
		LinkedBlockingQueue, 
		PriorityBlockingQueue, 
		PriorityQueue, 
		SynchronousQueue */
	}
}
