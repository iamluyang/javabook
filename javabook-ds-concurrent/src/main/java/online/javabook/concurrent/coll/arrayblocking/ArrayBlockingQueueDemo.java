package online.javabook.concurrent.coll.arrayblocking;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 技术特性
 * 1- 数据结构：一个由数组支持的有界阻塞队列。此队列按 FIFO（先进先出）原则对元素进行排序。
 * 2- 容器边界：这是一个典型的“有界缓存区”，固定大小的数组在其中保持生产者插入的元素和使用者提取的元素。
 * 3- 阻塞性质：一旦创建了这样的缓存区，就不能再增加其容量。试图向已满队列中放入元素会导致操作受阻塞；试图从空队列中提取元素将导致类似阻塞。 
 * 4- 线程排序：此类支持对等待的生产者线程和使用者线程进行排序的可选公平策略。默认情况下，不保证是这种排序。（这里指线程排序）
 *     公平策略 - 通过将公平性 (fairness) 设置为 true 而构造的队列允许按照 FIFO 顺序访问线程。公平性通常会降低吞吐量，但也减少了可变性和避免了“不平衡性”。 
 *     不公策略 - 
 *     实际上使用  ReentrantLock作为共享互斥的机制
 *     
 *  构造函数
 *  ArrayBlockingQueue(int capacity)   
 *  	创建一个带有给定的（固定）容量和默认访问策略的 ArrayBlockingQueue。
 *  
 *  ArrayBlockingQueue(int capacity, boolean fair) 
 *  	创建一个具有给定的（固定）容量和指定访问策略的 ArrayBlockingQueue。
 *  
 *  ArrayBlockingQueue(int capacity, boolean fair, Collection<? extends E> c) 
 *  	创建一个具有给定的（固定）容量和指定访问策略的 ArrayBlockingQueue，它最初包含给定 collection 的元素，并以 collection 迭代器的遍历顺序添加元素。
 *   
 *  重要方法
 *  	add(E e) 
 *  		将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量），在成功时返回 true，如果此队列已满，则抛出 IllegalStateException。
 *  
 *   	drainTo(Collection<? super E> c) 
 *         	移除此队列中所有可用的元素，并将它们添加到给定 collection 中。       	
 *         	方法特点 - 移除此队列中所有可用的元素，并将它们添加到给定 collection 中。此操作可能比反复轮询此队列更有效。
 *         	异常现象 - 在试图向 collection c 中添加元素没有成功时，可能导致在抛出相关异常时，
 *          		元素会同时在两个 collection 中出现，
 *          		或者在其中一个 collection 中出现，
 *          		也可能在两个 collection 中都不出现。
 *          		如果试图将一个队列放入自身队列中，则会导致 IllegalArgumentException 异常。
 *          并发修改 - 此外，如果正在进行此操作时修改指定的 collection，则此操作行为是不确定的。
 *          
 *          算法-- 从队尾takeIndex开始轮询 count （元素个数）次，将元素添加到c中，并清除到队列中的元素，最后将队列的putIndex、takeIndex索引复位，count复位。并且 notFull.signalAll();
 *        
 * 		drainTo(Collection<? super E> c, int maxElements) 
 *			最多从此队列中移除给定数量的可用元素，并将这些元素添加到给定 collection 中。
 *          算法-- 算法与上诉一样 count为 maxElements，从队头开始取元素，如果maxElements大于count则以count为准
 *          
 *
 *  算法与数据结构
 *     使用一个环形数组来维护数据
 *     takeIndex - 当前取数据的位置，队头索引，数据从对头获取，获取后索引递增，到队末后索引位置回到0
 *     putIndex - 当前放在数据的位置，队未索引，数据添加到末端，添加后索引递增，到队末后索引位置回到0
 *
 * 私有方法
 *     
 *    private void insert(E x) {  - 插入一个数据，
 *       items[putIndex] = x;    // 插入到指定位置
 *       putIndex = inc(putIndex); // 递增队尾索引
 *       ++count; // 递增元素个数 
 *       notEmpty.signal(); // 通知wait在notEmpty的线程，现在队列可以提取数据了
 *    }
 *   
 *    private E extract() { // 提前一个元素 
 *        final Object[] items = this.items; // 当前元素数组
 *        E x = this.<E>cast(items[takeIndex]); // 从当前位置提取元素，被类型转换
 *        items[takeIndex] = null; // 当前位置置空，为以后添加数据使用
 *        takeIndex = inc(takeIndex); // 递增队头索引
 *        --count; // 递减元素个数 
 *        notFull.signal();  // 通知wait在notFull的线程，现在队列可以添加数据了
 *        return x;
 *    }
 *    
 *    void removeAt(int i) { // 删除指定位置的元素
 *       final Object[] items = this.items; 
 *        // if removing front item, just advance
 *        if (i == takeIndex) { // 如果要删除的位置i与当前队头的位置相同，就相当于数据出队
 *            items[takeIndex] = null;
 *            takeIndex = inc(takeIndex); // 递增队头索引
 *        } else {
 *            // slide over all others up through putIndex.
 *            for (;;) { // 轮询数组
 *                int nexti = inc(i); // 获取下一个位置索引
 *                if (nexti != putIndex) { // 如果下一个位置不为队尾的索引
 *                    items[i] = items[nexti]; // 将当前位置的后续元素往前复制
 *                    i = nexti; // 更新下一个要复制数据的位置，并一直轮询到最后一个元素
 *                } else {
 *                    items[i] = null; // 直到轮询到队尾索引，将原先最后一个元素清除，它已经复制到前一个位置了
 *                    putIndex = i; // 更新队尾索引为i ，如果从非队尾删除数据，则队尾位置更新为上一次的删除位置 i
 *                    break; // 退出
 *                }
 *            }
 *        }
 *        --count; // 递减元素个数 
 *        notFull.signal(); // 通知wait在notFull的线程，现在队列可以添加数据了
 *    }
 *    
 * @author LuYang
 *
 */
public class ArrayBlockingQueueDemo {

	public static void main(String[] args) {
		ArrayBlockingQueue q = new ArrayBlockingQueue(1);
	}
}
