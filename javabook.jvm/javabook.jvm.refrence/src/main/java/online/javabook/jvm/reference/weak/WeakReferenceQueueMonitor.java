package online.javabook.jvm.reference.weak;

import online.javabook.jvm.reference.ReferenceTarget;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class WeakReferenceQueueMonitor extends Thread {

	ReferenceQueue<ReferenceTarget> referenceQueue;

	public WeakReferenceQueueMonitor(ReferenceQueue<ReferenceTarget> referenceQueue) {
		super();
		this.referenceQueue = referenceQueue;
	}

	@Override
	public void run() {
		while(true) {
			Reference<? extends ReferenceTarget> reference = referenceQueue.poll();
			if(reference==null){
				System.out.println( ">>>>>>>>>>弱引用对象还没有进入引用队列" );
			}else{
				System.out.println( "7.弱引用对象进入了引用队列：" + reference );
				return;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
