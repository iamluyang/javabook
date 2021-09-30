package online.javabook.jvm.thread.aba;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 说明：AtomicStampedReference以原子的方式同时维护着一对数据：引用对象与一个作为操作标记的整数。 引用对象
 * ：引用对象用来维护一个对象的引用 操作标记 ：操作标记用来维护某次操作的时间戳或是基于某种业务需求产生的与该操作相对应的数字
 * 
 * AtomicStampedReference通过构造函数传递一个初始的引用对象和整数。
 * 
 * public AtomicStampedReference(V initialRef, int initialStamp) { pair =
 * Pair.of(initialRef, initialStamp); }
 * 
 * 方法1：AtomicStampedReference通过set方法更新引用对象和操作标记。 public void set(V newReference,
 * int newStamp) { Pair<V> current = pair; if (newReference != current.reference
 * || newStamp != current.stamp) this.pair = Pair.of(newReference, newStamp); }
 * 
 * 思考1： 为什么AtomicStampedReference的set方法是线程安全的?
 * 
 * 解答1： AtomicStampedReference内部使用了一个Pair类型来封装引用对象与操作标记。
 * 每次通过Pair.of方法创建一个新的Pair对象，用于维护一对引用对象与操作标记。
 * 
 * 操作2： AtomicStampedReference通过get方法返回引用对象和操作标记。 典型的用法为 int[] stampHolder = new
 * int[1]; V reference = asr.get(stampHolder); 。
 * 因为Java不能返回一个以上的返回值，所以stamp值放到了stampHolder中
 * 
 * public V get(int[] stampHolder) { Pair<V> pair = this.pair; stampHolder[0] =
 * pair.stamp; return pair.reference; }
 * 
 * 思考2：当前线程调用get方法返回的引用对象是否会对应另外一个线程set方法设置进去的操作标记值呢？
 * 
 * 解答2： 从get方法中可以看到AtomicStampedReference中的private volatile Pair<V>
 * pair字段（即get方法中的this.pair）， 先被赋值给了get方法中的局部变量Pair<V>
 * pair，之后的操作都是通过局部变量pair完成的。即便这个时候有其他线程修改了 private volatile Pair<V>
 * pair字段，当前线程依然访问的是局部变量pair指向的那个修改前的对象。
 * 
 * 思考3：通过这种分别获取引用对象和操作标记的方式返回的引用对象是否会对应另外一个线程set操作设置进去的操作标记值呢？
 * 
 * V reference = atomicReference.getReference(); int stamp =
 * reference.getStamp();
 * 
 * 解答3：为了让程序执行结果更加明显。代码示例中通过Thread.sleep来控制线程的交替执行顺序。
 * 从执行结果我们可以看出返回的引用对象和操作标记是不匹配的。 因为在reference.getStamp()返回操作标记之前
 * 有另外一个线程更新了AtomicStampedReference对象，即AtomicStampedReference对象中pair字段被更新了。
 * 这个故事告诉我们使用线程安全的类并不代表写出的代码就一定是线程安全的。
 * 
 * AtomicStampedReference
 * 
 * @author LuYang
 * 
 */
public final class AtomicStampedReferenceDemo {

	static AtomicStampedReference<String> asr = new AtomicStampedReference<String>("A", 1);

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		// 线程1
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {

				String reference = asr.getReference();
				System.out.println("线程T1先获得AtomicStampedReference当前的reference" + ":" + reference);

				try {
					// T1先sleep一会，好让T2执行
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				int stamp = asr.getStamp();
				System.out.println("线程T1再获得AtomicStampedReference当前的stamp"	+ ":" + stamp);
			}
		});

		// 线程2
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					// T2先sleep一会，好让T1先执行
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				int[] stampHolder = new int[1];
				String reference = asr.get(stampHolder);
				asr.compareAndSet(reference, "B", stampHolder[0], 2);
			}
		});

		t1.start();
		t2.start();
	}
}
