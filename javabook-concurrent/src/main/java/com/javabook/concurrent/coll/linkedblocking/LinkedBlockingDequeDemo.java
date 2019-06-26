package com.javabook.concurrent.coll.linkedblocking;

import java.util.concurrent.LinkedBlockingDeque;


/**
 * 技术特性
 * 1- 数据结构：一个基于链接节点、任选范围的阻塞双端队列。 
 * 2- 容器边界：构造方法参数提供了一个可选的容量范围，以防止容器过度膨胀（扩容）。如果未指定容量，那么容量将等于 Integer.MAX_VALUE。
 *                    链式节点在每次插入时被动态的创建，除非已经达到了双端队列的容量。
 * 3- 阻塞性质：大多数操作都以固定的时间运行（不计阻塞消耗的时间）。
 *                    除了 remove、removeFirstOccurrence、removeLastOccurrence、contains、iterator.remove() 以及批量操作，它们均以线性时间运行。 
 * 4- 迭代机制：这类及其迭代器实现了Collection 和Iterator 接口的所有可选方法。        
 * 5- 共享互斥： 实际上使用  ReentrantLock作为共享互斥的机制
 * 						final ReentrantLock lock = new ReentrantLock();
 *                      private final Condition notEmpty = lock.newCondition();
 *                      private final Condition notFull = lock.newCondition();
 *                      
 * 6- 实现接口：BlockingQueue - 参考JDK中一个有用的描述表格
 *  
 *     
 *  构造函数
 *  LinkedBlockingDeque() 
 *  	 创建一个容量为 Integer.MAX_VALUE 的 LinkedBlockingDeque。
 *  
 *  LinkedBlockingDeque(Collection<? extends E> c) 
 *  	创建一个容量为 Integer.MAX_VALUE 的 LinkedBlockingDeque，最初包含给定 collection 的元素，以该 collection 迭代器的遍历顺序添加。
 *  
 *  LinkedBlockingDeque(int capacity)
 *  	创建一个具有给定（固定）容量的 LinkedBlockingDeque。
 *   
 *  重要方法
 *  	public boolean removeFirstOccurrence(Object o)  从前向后查找
 *  	public boolean removeLastOccurrence(Object o)  从后向前查找
 *  	public int drainTo(Collection<? super E> c)
 *  	public int drainTo(Collection<? super E> c, int maxElements)
 *  
 *  数据结构 
 *     Node - item
 *              - prev
 *              - next
 *              
 *     Queue - first
 *               - last         
 *               - count
 *               - capacity
 *                     
 *  算法实现

    Links node as first element, or returns false if full.
    private boolean linkFirst(Node<E> node) {
        // assert lock.isHeldByCurrentThread();
        if (count >= capacity)
            return false;
        Node<E> f = first;
        node.next = f;
        first = node;
        if (last == null)
            last = node;
        else
            f.prev = node;
        ++count;
        notEmpty.signal();
        return true;
    }

    Links node as last element, or returns false if full.
    
    private boolean linkLast(Node<E> node) {
        // assert lock.isHeldByCurrentThread();
        if (count >= capacity)
            return false;
        Node<E> l = last;
        node.prev = l;
        last = node;
        if (first == null)
            first = node;
        else
            l.next = node;
        ++count;
        notEmpty.signal();
        return true;
    }

    
    Removes and returns first element, or null if empty.
    
    private E unlinkFirst() {
        // assert lock.isHeldByCurrentThread();
        Node<E> f = first;
        if (f == null)
            return null;
        Node<E> n = f.next;
        E item = f.item;
        f.item = null;
        f.next = f; // help GC
        first = n;
        if (n == null)
            last = null;
        else
            n.prev = null;
        --count;
        notFull.signal();
        return item;
    }

   
    Removes and returns last element, or null if empty.

    private E unlinkLast() {
        // assert lock.isHeldByCurrentThread();
        Node<E> l = last;
        if (l == null)
            return null;
        Node<E> p = l.prev;
        E item = l.item;
        l.item = null;
        l.prev = l; // help GC
        last = p;
        if (p == null)
            first = null;
        else
            p.next = null;
        --count;
        notFull.signal();
        return item;
    }
 *    
 * @author LuYang
 *
 */
public class LinkedBlockingDequeDemo {

	public static void main(String[] args) {
		LinkedBlockingDeque q = new LinkedBlockingDeque(1);
	}
}
