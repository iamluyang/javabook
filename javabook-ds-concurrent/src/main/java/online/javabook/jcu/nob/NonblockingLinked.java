package online.javabook.jcu.nob;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 非阻塞链表 修改链表、树或哈希表可能涉及对多个指针的更新。 CAS 支持对单一指针的原子性条件更新，但是不支持两个以上的指针。
 * 所以，要构建一个非阻塞的链表、树或哈希表，需要找到一种方式，可以用 CAS 更新多个指针，同时不会让数据结构处于不一致的状态。
 * 
 * 进行线程干预 - 对于非复杂数据结构，构建非阻塞算法的 “技巧” 是确保数据结构总处于一致的状态（甚至包括在线程开始修改数据结构和它完成修改之间），
 * 还要确保其他线程不仅能够判断出第一个线程已经完成了更新还是处在更新的中途，还能够判断出如果第一个线程走向
 * AWOL，完成更新还需要什么操作。如果线程发现了处在更新中途的数据结构，它就可以 “帮助”
 * 正在执行更新的线程完成更新，然后再进行自己的操作。当第一个线程回来试图完成自己的更新时，会发现不再需要了，返回即可，因为 CAS
 * 会检测到帮助线程的干预（在这种情况下，是建设性的干预）。
 * 
 * 不进行线程帮助 - 这种 “帮助邻居”
 * 的要求，对于让数据结构免受单个线程失败的影响，是必需的。如果线程发现数据结构正处在被其他线程更新的中途，然后就等候其他线程完成更新，
 * 那么如果其他线程在操作中途失败
 * ,这个线程就可能永远等候下去。即使不出现故障，这种方式也会提供糟糕的性能，因为新到达的线程必须放弃处理器，导致上下文切换，或者等到自己的时间片过期
 * （而这更糟）。
 * 
 * 比喻 ：食堂师傅　－　2个打菜师傅－食客 - 场景- 每个食客需要打一份饭，打一份菜，没打饭，打菜的师傅就要等
 * 
 * 打饭师傅A给客人C，先打了一份饭，然后有事情走开了；
 * 打饭师傅B，有两种工作策略：
 * 	选择1- 等待打饭师傅A回来后，打饭师傅A继续给客人C打菜，很明显这样的方式没有什么效率，如果打饭师傅A长时间没有回来，打饭师傅B就得一直等待，客人C也在等待；
 *  选择2- 打饭师傅B帮助打饭师傅A给客人C打菜，如果这个时候打饭师傅A回来发现客人C已经打好菜了，他没有必要知道是谁帮他完成了，只要知道在状态改变以后不再给客人C重复打菜就好了；
 * 
 * 幕后的非阻塞算法：
 * 
 * 如果深入 JVM
 * 和操作系统，会发现非阻塞算法无处不在。垃圾收集器使用非阻塞算法加快并发和平行的垃圾搜集；调度器使用非阻塞算法有效地调度线程和进程，实现内在锁。在
 * Mustang（Java 6.0）中，基于锁的 SynchronousQueue 算法被新的非阻塞版本代替。很少有开发人员会直接使用
 * SynchronousQueue，但是通过 Executors.newCachedThreadPool()
 * 工厂构建的线程池用它作为工作队列。比较缓存线程池性能的对比测试显示，新的非阻塞同步队列实现提供了几乎是当前实现 3 倍的速度。在 Mustang
 * 的后续版本（代码名称为 Dolphin）中，已经规划了进一步的改进。
 * 
 * @author LuYang
 * 
 * @param
 */
public class NonblockingLinked {

	// headRefer
	private AtomicReference<Node> headRefer = new AtomicReference<Node>(new Node(null, null));

	// tailRefer
	private AtomicReference<Node> tailRefer = headRefer;

	/**
	 * put操作实际上由两个操作构成，一个完整的put操作要完成这两个操作
	 * 第二个操作： 更新 tailNode 节点指向put入的新节点 newNode
	 * 第二个操作：更新 tailRefer 指向新创建了节点newNode
	 * 
	 * 使用阻塞方式，我们只需要将这两个操作放在一个同步方法块中就可以
	 * 
	 * 使用非阻塞方法，一个完整的put操作同样要完成这两个操作，但是其中第二个操作，不一定由同一个线程完成，可能会由另一个线程帮助之前的线程完成，
	 * 我们还有使用两个访问条件，来决定当前线程是否能够执行其中的两个操作，还是回退重新检测执行条件：
	 * 防卫条件1 - 
	 * 
	 * @param newObject
	 * @return
	 */
	public boolean put(Object newObject) {
		
		// 当前线程T-A进入put方法
		Node newNode = new Node(newObject, null);

		while (true) {
			
			// 获取链尾节点
			Node tailNode        = tailRefer.get();
			// 获取链尾节点的下一个节点tailNextNode：
			// tailNextNode节点可能为null，表示put的操作刚刚开始，或者已经完成了put操作
			Node tailNextNode = tailNode.next.get();

			/* 防卫条件1 - 如果当前 tailRefer指向的元素与tailNode不同 ：
			   表示 tailRefer 已经被另一个线程T-B修改了，即线程T-B已经完成了一次完整的put操作，
			   那么当前线程T-A则结束后续操作，线程T-A重新开始下一轮操作
			*/
			if (tailNode == tailRefer.get()) { 

				/* 防卫条件2 - 如果tailNextNode不为null：
				   表示已经有另一个线程T-B同时在操作put方法，并且已经完成了2个操作中的第一个了，
				   那么当前线程T-A进入协助操作程序块，帮助线程T-B完成剩下的第2个操作 */
				if (tailNextNode == null) {

					/* 当前线程T-A更新tailNode的next为newNode，
                    	1-如果此时tailNode的next如果为null，表示当前链表没有被线程T-B修改，当前线程T-A首先完成了第一个操作；
                    	   如果第一个操作更新成功，线程T-A继续更新 tailRef 的指向的尾节点，原有的尾节点 tailNode，更新为 newNode
                    	
                    	2-如果此时tailNode的next如不为null，表示当前链表已经被线程T-B修改，当前线程T-A不继续执行第二个操作，
                           当前线程T-A重新进入while方法块，准备进入下一轮判断，之后线程T-A会发生如下两种情况：
                           情况1：此刻线程T-B在线程T-A还没有来得及执行下一轮判断前，线程T-B继续执行第二个操作，最终完成了链表的操作；
                           情况2：此刻线程T-A在线程T-B还没有来得及完成第二个操作前，线程T-A帮组线程T-B执行第二个操作，最终完成了链表的操作；
					 */					
					if (tailNode.next.compareAndSet(null, newNode)) {
						// 第一个操作
						tailRefer.compareAndSet(tailNode, newNode);
						return true;
					}
				} else {
					
					// 协助操作：当前线程T-A尝试协助线程T-B完成第二步操作		
					// 情况1：如果线程T-B后来自己完成了第二步操作，那么当前线程T-A不做任何修改，因为tailNode已经和tailRefer引用的对象不同
					// 情况2：如果线程T-B没有自己去完成第二步操作，那么当前线程T-A帮助T-B完成，因为tailNode依然和tailRefer引用的对象相同
					tailRefer.compareAndSet(tailNode, tailNextNode);
				}
			}
		}
	}

	// Node
	private static class Node {

		final Object item;
		final AtomicReference<Node> next;

		Node(Object item, Node next) {
			this.item = item;
			this.next = new AtomicReference<Node>(next);
		}
	}

}
