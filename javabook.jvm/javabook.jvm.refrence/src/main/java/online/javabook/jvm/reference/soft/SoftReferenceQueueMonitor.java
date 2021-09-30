package online.javabook.jvm.reference.soft;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

import online.javabook.jvm.reference.ReferenceTarget;

public class SoftReferenceQueueMonitor extends Thread {

	ReferenceQueue<ReferenceTarget> referenceQueue;
	
	public SoftReferenceQueueMonitor(ReferenceQueue<ReferenceTarget> referenceQueue) {
		super();
		this.referenceQueue = referenceQueue;
	}

	@Override
	public void run() {
		while(true) {
			Reference<? extends ReferenceTarget> reference = referenceQueue.poll();
			if(reference==null){
				System.out.println( ">>>>>>>>>>软引用对象还没有进入引用队列" );
			}else{
				System.out.println( "10.软引用对象进入了引用队列：" + reference );
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
