package online.javabook.jvm.reference.soft;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import online.javabook.jvm.reference.ReferenceTarget;

/**
 * 根据我的不成熟的想法，JVM引入多种引用类型的目的在于暗示GC对特定引用类型的释放时机做特殊处理，并提供监听操作，
 * 并且被引用的类型往往都是较大的对象或者需要在释放的时候被监听，对引用类型的释放监听可以用来管理与引用类型相关
 * 联的资源是否也需要处理。
 *
 * 软引用类型所包装的强引用被置空，GC并不会立即回收依然被软引用所持有的对象，而是等待堆内存低于某个阈值后才释放
 * 软引用所持有的对象。软引用是一种内存敏感的引用类型。
 *
 * -Xms512m -Xmx512m -XX:+PrintGCDetails
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class SoftReferenceMain {

	public static void main(String[] args) throws InterruptedException {

		// 1.创建引用队列
		ReferenceQueue<ReferenceTarget> queue = new ReferenceQueue<ReferenceTarget>();
		System.out.println("1. 确认[引用队列]：" + queue + "\n");
		
		new SoftReferenceQueueMonitor(queue).start();

		// 2.创建引用目标
		ReferenceTarget referenceTarget = new ReferenceTarget();
		System.out.println("2.确认[引用目标]：" + referenceTarget + "\n");

		// 3.创建一个软引用，由构造函数设置一个引用目标，并绑定一个引用队列
		Reference<ReferenceTarget> softReference = new SoftReference<ReferenceTarget>(referenceTarget, queue);
		System.out.println("3.确认[软引用]: " + softReference + "\n");

		// 4.引用目标失去强引用
		referenceTarget = null;
		System.out.println("4.从[软引用]中确认[引用目标]");
		System.out.println("当前[引用目标]不是一个[强可达对象]: referenceTarget = null");
		System.out.println("当前[引用目标]被一个[软引用]所持有:" + softReference.get());
		System.out.println("当前[引用目标]变成一个[软可达对象]" + "\n");

		// 5.第一次启动GC并休息1秒
		System.out.println("5.第一次启动GC并休息1秒.\n");
		System.gc();
		Thread.sleep(1000);

		// 6.软可到达对象的finalize()方法
		System.out.println("6.启动GC后软可到达对象的finalize()方法没有被执行。" + "即GC没有立即回收[软可达]对象(现在内存还比较充足)" + "\n");

		// 7.启动GC后检查引用目标是否被清除
		System.out.println("7.启动GC后检查[软引用]的[引用目标]，发现依然存在：" + softReference.get() + "\n");

		// 8.启动内存泄漏堆积
		System.out.println("8.启动内存泄漏堆积代码");
		Object[] gb = new Object[1024];
		try {
			int mbcount = 1 * 1024 * 1024;
			for (int count = 0; count < 1024; count++) {
				gb[count] = new byte[mbcount * 100];
				long freeMemoryMB = Runtime.getRuntime().freeMemory() / mbcount;
				System.out.println("FreeMemory：" + freeMemoryMB + "MB");
				Thread.sleep(1000);
			}
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
			System.out.println("9.引用目标“失去”相应的软可到达状态，软引用会进入引用队列");
		}

	}
}
