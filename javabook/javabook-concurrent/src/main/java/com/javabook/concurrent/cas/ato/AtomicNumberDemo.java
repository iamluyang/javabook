package com.javabook.concurrent.cas.ato;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 线程之间的协调
 * 
 * 锁定的原理： 
 * 在Java语言中，协调对共享字段的访问的传统方法是使用同步。确保完成对共享字段的所有访问，同时具有适当的锁定。通过同步，可以确定（假设类编写正确）
 * 具有保护一组给定变量的锁定的所有线程都将拥有对这些变量的独占访问权(原子性)，并且在这之后的其他线程获得该锁定时，将可以看到之前的线程对变量进行的更改（可见性）。
 * 
 * 锁定的问题： 
 * 如果一个线程试图获取其他线程已经具有的锁定，那么该线程将被阻塞，直到该锁定可以使用。 这种方式具有一些明显的缺点：
 * 1.当线程被阻塞并等待锁定时，它无法进行其他任何操作。 
 * 2.如果阻塞的线程是高优先级的任务，那么该方案可能造成非常不好的结果，称为优先级倒置的危险。
 * 3.使用锁定还有一些其他危险，如死锁，当以不一致的顺序获得多个锁定时会发生死锁。
 * 4.如果锁定竞争太厉害（线程常常在其他线程具有锁定时要求获得该锁定），会损害吞吐量，因为竞争的同步非常昂贵。 
 * 对于现代 JVM 而言，无竞争的同步现在非常便宜。
 * 
 * 原子变量 
 * JDK并发包中提供了一组原子变量类型。
 * 1.原子变量类型可作为volatile变量的泛化，读取和写入原子变量与读取和写入volatile变量具有相同的存取语义；
 * 2.原子变量类型弥补了volatile变量在线程同步上的不足，原子变量可以支持基于原子条件的比较并设置更新操作；
 * 3.原子变量类型使用了平台提供的用于并发访问的硬件原语，这使得Java的多线程程序在性能上得到了很大的提升；
 * 
 * 更细粒度意味着更轻量级，调整具有竞争的并发应用程序的可伸缩性的通用技术是降低使用的锁定对象的粒度，希望更多的锁定请求从竞争变为不竞争。
 * 从锁定转换为原子变量可以获得相同的结果，通过切换为更细粒度的协调机制，竞争的操作就更少，从而提高了吞吐量。
 * 
 * 
 * 
 *  
 * AtomicInteger类型
 * 
 * 1.内部封装的字段为volatile int类型，因此可以获得内存可见性。
 * private volatile int value;
 *
 * 2.基于CAS的方式返回现有的值，并设置一个新值。
 * 
 * CAS更新失败的执行过程：
 * A.get方法首先将当前volatile int value中的值复制到局部变量中，局部变量对当前线程来说是安全的，因此无需担心它会被其他线程更改；
 * B.在compareAndSet操作之前如果有其他线程更改了volatile int value字段，那么compareAndSet将会返回false，表示CAS操作失败了；
 * C.程序将重新回到A处，重新尝试。
 * 
 * CAS更新成功的执行过程：
 * A.get方法首先将当前volatile int value中的值复制到局部变量中，局部变量对当前线程来说是安全的，因此无需担心它会被其他线程更改；
 * B.在compareAndSet操作之前如果没有其他线程更改volatile int value字段，那么compareAndSet将会返回true，表示CAS操作成功了；
 * C.程序将返回更新前的值，而不是当前更新的值，并退出。
 * 
 * 然后程序回退，按照上述的方式重新尝试。
 * 
 * 
    public final int getAndSet(int newValue) {
        for (;;) {
            int current = get();
            if (compareAndSet(current, newValue))
                return current;
        }
    }
    
    getAndIncrement提供了与getAndSet方法相似的CAS算法，只是将函数传递新值的方式改成了在当前值的基础上递增后进行CAS操作。还记得我们
         写过的基于volatile非同步的计数器的例子吗，volatile虽然提供了内存可见的支持，但并不能提供原子操作的线程同步，
         
        增加了一个数值递增的操作。
    public final int getAndIncrement() {
        for (;;) {
            int current = get();
            int next = current + 1;
            if (compareAndSet(current, next))
                return current;
        }
    }
    
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date Jul 6, 2015
 */
public final class AtomicNumberDemo {
	
	// value
	private AtomicBoolean   ab = new AtomicBoolean();
	
	// value
	private AtomicInteger   ai = new AtomicInteger();
	
	// value
	private AtomicLong      al = new AtomicLong();
	
	// value
	private AtomicReference ar = new AtomicReference<>();

}
