package com.javabook.concurrent.coll.delay;


/**
 * 技术特性
 * 1- 数据结构：Delayed 元素的一个无界阻塞队列，只有在延迟期满时才能从中提取元素。（底层数据容器通过一个PriorityQueue来实现的）
 * 
 * 2- 容器性质：该队列的头部是延迟期满后保存时间最长的 Delayed 元素。如果延迟都还没有期满，则队列没有头部，并且 poll 将返回 null。
 * 					  当一个元素的 getDelay(TimeUnit.NANOSECONDS) 方法返回一个小于等于 0 的值时，将发生到期。
 * 					  即使无法使用 take 或 poll 移除未到期的元素，也不会将这些元素作为正常元素对待。
 * 					  例如，size 方法同时返回到期和未到期元素的计数。此队列不允许使用 null 元素。
 * 
 * 3- 容器边界：由于该队列是无界的
 * 
 * 4- 阻塞性质：与过期相关的方法
 * 					public E take() 
 * 						获取并移除此队列的头部，在可从此队列获得到期延迟的元素之前一直等待（如有必要）。 
 * 					
 *                  public E poll(long timeout, TimeUnit unit) throws InterruptedException
 * 						获取并移除此队列的头部，在可从此队列获得到期延迟的元素，或者到达指定的等待时间之前一直等待（如有必要）。 
 * 					
 * 					与过期无关相关的方法
 * 
 * 					public E poll()
 * 						获取并移除此队列的头，如果此队列不包含具有已到期延迟时间的元素，则返回 null。 

 *                  put public void put(E e)
 *                      将指定元素插入此延迟队列。由于该队列是无界的，所以此方法不会阻塞。
 *                      
 *                  public boolean offer(E e, long timeout, TimeUnit unit)
 *                      将指定元素插入此延迟队列中。由于该队列是无界的，所以此方法不会阻塞。
 *                      
 *                  public boolean remove(Object o)
 *                      从此队列中移除指定元素的单个实例（如果存在），无论它是否到期。
 *                      
 *                  public void clear()
 *                       自动移除此延迟队列的所有元素。此调用返回后，队列将为空。不等待未到期延迟的元素；只是从队列中丢弃它们。 
 *  
 *   迭代性质：
 *                  public Iterator<E> iterator()
 *                  	返回在此队列所有元素（既包括到期的，也包括未到期的）上进行迭代的迭代器。迭代器不以任何特定的顺序返回元素。
 *                  	返回的 Iterator 是一个“弱一致”迭代器，不会抛出 ConcurrentModificationException，
 *                 	 	并且可确保遍历迭代器构造后所存在的所有元素，并且可能（但并不保证）反映构造后的所有修改。                         
 *                 
 *  构造函数
 *  
 *  重要方法    
 *                  public int remainingCapacity()
 *                  	  因为 DelayQueue 没有容量限制，所以它总是返回 Integer.MAX_VALUE。 
 *                  
 *                  public int drainTo(Collection<? super E> c)
 *                  	  先E first = q.peek();出队列中的第一个元素，如果过期了则添加到c中，如果没有过期方法立即返回，重复这个过程。
 *                        也即是说直到发现第一个没有过期的对象，就立即从此方法返回，不一定会排出队列中的所有元素，也可能一个也没有。。
 *                        
 *                  public int drainTo(Collection<? super E> c, int maxElements)
 *                  	   原理同上。但最多排出maxElements个元素，也可能一个也没有。
 *                  
 *  访问方法                
 *                  public Object[] toArray()
 *                  返回包含此队列所有元素的数组。所返回数组的元素没有特定的顺序。 
 *                  由于此队列并不维护对返回数组的任何引用，因而它将是“安全的”。
 *                  （换句话说，此方法必须分配一个新数组）。因此，调用者可以随意修改返回的数组。 
 *
 *  算法与数据结构
 *  
 *  
 *      public boolean offer(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            q.offer(e); // 入队，此处使用了优先级队列，优先级队列采用了堆的结构，入队后会对堆中数据进行排序，e入队后不一定是在队尾
            if (q.peek() == e) { // q.peek()返回的是优先级较高的元素，即表示这个刚刚入队的元素 e 即为 优先级较高的元素，即最快过期的元素，
                leader = null; // 清除当前队列的持有者线程，即有另外一个线程持有了队列，并且此时处于wait状态
                available.signal(); // 立即通知在队列poll或take方法上等待的线程，唤醒他们，这是有了一个可能要过期的元素了
            } // 否则表示当前入队的元素离过期还早，在poll或take方法上等待的线程继续wait
            return true;
        } finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            for (;;) {
                E first = q.peek(); // 取出队列的第一个元素
                if (first == null) // 如果优先队列的第一个元素为null，换句话说表示队列为空
                    available.await(); // 当前线程进入阻塞等待
                    
                else { // 如果返回元素，换句话说表示队列不为空，并得到了队头的元素，此刻并判断是否过期
                
                    long delay = first.getDelay(TimeUnit.NANOSECONDS);
                    
                    if (delay <= 0) // delay小于0，换句话说表示元素过期，元素poll出队列
                        return q.poll();
                        
                    else if (leader != null) // 否则表示delay依然大于0， 且当前线程已经持有这个队列，当前线程则继续等待
                        available.await();
                        
                    else {  // 否则表示delay依然大于0，将当前线程作为这个队列的持有者
                        Thread thisThread = Thread.currentThread();
                        leader = thisThread;
                        
                        try {
                            available.awaitNanos(delay); // 当前线程等待队头这个快过期的元素，等待的时间由之前得到，即 delay。而不是傻傻的一直等，当等待完delay时间后，就立即进入下一轮循环判断
                                                                      // 在当前线程等待期间，另外一个offer(E e)线程可能执行入队操作，这回引发2种情况：
                                                                      // 情况1：入队的元素是一个优先级不怎么高的元素， 入队后offer的线程返回
                                                                      // 情况2：入队的元素是当前队列中优先级最高的元素，这个offer将 leader 置空，队列的持有者不再是当前这个调用 take 方法的线程，并offer的线程将take的线程唤醒，offer线程释放锁
                                                                      //             take线程从wait中醒来，这是finally方法中的逻辑已经无需处理，因为 leader已经被offer线程置空了，因此take线程重新循环，
                                                                      //             2.1-如果此时元素已经过期，则直接返回
                                                                      //             2.2-如果此时还没过期，这继续等待
                                                                      
                                                                      // 在当前线程等待期间，如果有另外一个take线程可能也尝试执行出队操作，这回引发2种情况：
                                                                      // 情况1：元素已经过期了，则立即返回，finally中的leader ==null不成了，因为还被之前的take线程持有
                                                                                    ==>
                                                                      // 情况2：元素还没有过期了，而leader != null成立，因为还被之前的take线程持有，那这个take线程不在尝试操作了，而是也进入等待，就是说变成了前一个take线程的flower                                              
                     												 //             ==>当leader 的take线程从等待中回复过来，则清除leader标记，进入循环，发现元素已经过期了，就返回
                     												  //            ==>在finally当q中还有元素，将唤醒flower的take线程，
                        } finally { // 
                            if (leader == thisThread)
                                leader = null;
                        }
                    }
                }
            }
        } finally {
            if (leader == null && q.peek() != null) // 退出take前，如果peek发现队列不为空，并且 leader == null ，当前线程没有设置成队列持有者，且在这个访问take的线程可能从await中被打断，
                available.signal();
            lock.unlock();
        }
    } 
 *  
 *  
    
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            for (;;) {
                E first = q.peek(); // 返回优先队列的第一个元素
                if (first == null) {  // 如果优先队列的第一个元素为null，换句话说表示队列为空
                    if (nanos <= 0) // 并且nanos小于等于0，即不阻塞等待，立即返回null
                        return null;
                    else
                        nanos = available.awaitNanos(nanos);
                } else {
                    long delay = first.getDelay(TimeUnit.NANOSECONDS); // 如果返回元素，换句话说表示队列不为空，并得到了队头的元素，此刻并判断是否过期
                    if (delay <= 0)  // delay小于0，换句话说表示元素过期，元素poll出队列
                        return q.poll();
                        
                    if (nanos <= 0) // delay依然大于0，换句话说表示元素依然没有过期，但nanos小于0（换句话说poll方法在等待的timeout时间内，还没有等到过期的元素，返回null）
                        return null;
                        
                    if (nanos < delay || leader != null)            // 如果poll方法阻塞的剩余时间比元素过期的时间短，或者当前队列已经被某个线程持有
                        nanos = available.awaitNanos(nanos); // 现在poll方法的阻塞时间有最初的timeout，变成了nanos，只能在等这么久了，
                                                                                 // 除非XXXXX 
                        
                    else {                                                     // 如果poll方法阻塞的剩余时间比元素过期的时间长，换句话说我们没有必要等待那么长的时间，poll方法阻塞的剩余时间和元素过期的时间之间，
                                                                                // 选择较短的那个作为阻塞时间即可，因此选择元素过期的时间delay作为等待时间是比较合适的
                        Thread thisThread = Thread.currentThread(); // 获取当前访问poll方法的线程
                        leader = thisThread; // 设置当前队列的拥有线程
                        try {
                            long timeLeft = available.awaitNanos(delay); // 如果
                            nanos -= delay - timeLeft;
                        } finally {
                            if (leader == thisThread) //如果当前队列依然被这个线程持有
                                leader = null; // 则在退出前期循环前释放队列的持有线程属性
                        }
                    }
                }
            }
        } finally {
            if (leader == null && q.peek() != null)
                available.signal();
            lock.unlock();
        }
    }
 *  
 *  
 *  
 * 私有方法

 *    
 * @author LuYang
 *
 */
public class DelayQueueDemo {

/**
 * Thread designated to wait for the element at the head of
 * the queue.  This variant of the Leader-Follower pattern
 * (http://www.cs.wustl.edu/~schmidt/POSA/POSA2/) serves to
 * minimize unnecessary timed waiting.  When a thread becomes
 * the leader, it waits only for the next delay to elapse, but
 * other threads await indefinitely.  The leader thread must
 * signal some other thread before returning from take() or
 * poll(...), unless some other thread becomes leader in the
 * interim.  Whenever the head of the queue is replaced with
 * an element with an earlier expiration time, the leader
 * field is invalidated by being reset to null, and some
 * waiting thread, but not necessarily the current leader, is
 * signalled.  So waiting threads must be prepared to acquire
 * and lose leadership while waiting.
 * 
 * 线程被定义为等待队列的头元素. 这是Leader-Follower模式的一个变种，以尽量减少不必要的定时等待。
 * 当一个线程变成了Leader，它只等待接下来的延迟，但其他线程无限期地等待。
 * Leader线程必须在take() 或 poll(...)方法返回之前signal其他线程，除非在此期间其他线程变成了Leader。
 * 
 * 每当队列的头会被替换为一个更快过期的元素，leader由被重置为空
 */

}