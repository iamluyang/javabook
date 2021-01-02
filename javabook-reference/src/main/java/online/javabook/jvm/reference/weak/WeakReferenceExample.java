package online.javabook.reference.weak;

import online.javabook.reference.ReferenceTarget;
import online.javabook.reference.finalize.Host;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * -Xms512m -Xmx512m
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class WeakReferenceExample {

	public static void main(String[] args) throws InterruptedException {

		Host host = new Host ();
		
		// 1.创建引用队列ReferenceQueue
		ReferenceQueue<ReferenceTarget> queue = new ReferenceQueue<ReferenceTarget>();
		System.out.println("1.确认[引用队列]：" + queue + "\n");
		
		// 2.创建引用目标
		ReferenceTarget referenceTarget = new ReferenceTarget();
		System.out.println("2.确认[引用目标]：" + referenceTarget + "\n");
		
		// 3.创建一个弱引用，由构造函数设置一个引用目标，并绑定一个引用队列		
		Reference<ReferenceTarget> weakReference = new WeakReference<ReferenceTarget>(referenceTarget, queue);
		System.out.println("3.确认[弱引用]：" + weakReference + "\n");	
		
		// 4.引用目标失去强引用
		referenceTarget = null;
		System.out.println("4.从[弱引用]中确认[引用目标]：" + weakReference.get());	
		System.out.println("当前[引用目标]不是一个[强可达对象]");
		System.out.println("当前[引用目标]不是一个[软可达对象]");
		System.out.println("当前[引用目标]被一个[弱引用]所持有");
		System.out.println("当前[引用目标]变成一个[弱可达对象]" + "\n");

		// 5.创建一个WeakHashMap
		WeakHashMap<ReferenceTarget, Object> hashMap = new WeakHashMap<ReferenceTarget, Object>();
		hashMap.put(weakReference.get(), new Object());							
		System.out.println("5.确认WeakHashMap：" + hashMap + "\n");					

		// 6.第一次启动GC并休息1秒
		System.out.println("6.第一次启动GC并休息1秒.\n");
		System.gc(); 
		Thread.sleep(1000);		
		
		// 8.启动第一次GC后检查引用目标是否被清除，当弱可达对象被垃GC回收，GC会清除所有到此弱可到达对象的弱引用
		System.out.println("8.启动第一次GC后检查[弱引用]的[引用目标]，发现已被清除：" + weakReference.get() + "\n");

		// 9.引用目标“失去”相应的弱可达状态
		System.out.println("9.引用目标“失去”相应的弱可达状态，弱引用会进入引用队列\n");

		// 10.第一次从引用队列取出引用对象
		System.out.println("10.第一次从引用队列取出弱引用-> "+ queue.poll() + "\n");		

		// 11.检查WeakHashMap的大小
		System.out.println("11.检查WeakHashMap->" + hashMap);
	}
}
