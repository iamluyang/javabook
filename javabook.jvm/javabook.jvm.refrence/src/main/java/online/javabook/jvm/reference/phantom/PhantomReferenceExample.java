package online.javabook.jvm.reference.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

import online.javabook.jvm.reference.ReferenceTarget;
import online.javabook.jvm.reference.weak.WeakReferenceQueueMonitor;

/**
 * 虚引用类型同样是一种GC敏感的引用类型，当对象被虚引用所持有的时候，不管堆内存够不够都会立即被释放。
 * 虚引用所持有的对象在无论何时都不能通过虚引用返回，phantomReference.get()自始至终返回null。
 *
 * -Xms512m -Xmx512m
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class PhantomReferenceExample {

	ReferenceTarget copy;

	public static void main(String[] args) throws InterruptedException {

		// 1.创建引用队列
		ReferenceQueue<ReferenceTarget> queue = new ReferenceQueue<ReferenceTarget>();
		System.out.println("1.确认[引用队列]：" + queue + "\n");

		new PhantomReferenceQueueMonitor(queue).start();

		// 2.引用目标
		ReferenceTarget referenceTarget = new ReferenceTarget();
		System.out.println("2.确认[引用目标]：" + referenceTarget + "\n");

		// 3.创建一个虚引用，由构造函数设置一个引用目标，并绑定一个引用队列
		Reference<ReferenceTarget> phantomReference = new PhantomReference<ReferenceTarget>(referenceTarget, queue);
		System.out.println("3.确认[虚引用]: " + phantomReference + "\n");

		// 4.引用目标失去强引用
		referenceTarget = null;
		System.out.println("4.从[虚引用]中确认[引用目标]：" + phantomReference.get() + "，实际上这个方法始终都返回null");
		System.out.println("当前[引用目标]不是一个强可到达对象");
		System.out.println("当前[引用目标]不是一个软可到达对象");
		System.out.println("当前[引用目标]不是一个弱可到达对象");
		System.out.println("当前[引用目标]被一个[虚引用]所持有");

		// 5.第一次启动GC并休息1秒
		System.out.println("5.第一次启动GC并休息1秒\n");
		System.gc();
		Thread.sleep(1000);

		try {

			// 7.第二次启动GC并休息1秒
			System.out.println("6.第二次启动GC并休息1秒" + "\n");
			//System.gc();
			Thread.sleep(1000);

		} catch (Exception e) {
			// 注：可尝试屏蔽掉ReferenceTarget的finalize()方法，重新运行此例子
			System.out.println("6.目标对象没有定义finalize()方法\n");

			// 7.引用目标变成了虚可到达状态，GC立即把该虚引用加入到引用队列中
			System.out.println("7.第一次从引用队列取出引用对象：" + queue.poll() + "\n");
		}

		Thread.sleep(1000 * 3600);
	}
}
