package online.javabook.jvm.reference.finalizer;

/**
 * Finalizer守护线程处理队列中的finalize任务（似乎不是并发处理的）
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-9-25
 * 
 */
public class FinalizerQueueMain {

	/**
	 * name
	 */
	private String name;

	/**
	 * @param name
	 */
	public FinalizerQueueMain(String name) {
		super();
		this.name  = name;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println(Thread.currentThread().getName() + "守护线程：(" + Thread.currentThread().isDaemon() + ")" + "开始执行对象" + name + "的finalize方法");

		Thread.sleep(5000);
		System.out.println(name+"的finalize正在运行.");
		System.out.println(name+"的finalize结束\n");
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		System.out.println("主线程开始：" + Thread.currentThread().getName());

		FinalizerQueueMain f1 = new FinalizerQueueMain("N1");
		FinalizerQueueMain f2 = new FinalizerQueueMain("N2");
		FinalizerQueueMain f3 = new FinalizerQueueMain("N3");
		FinalizerQueueMain f4 = new FinalizerQueueMain("N4");
		FinalizerQueueMain f5 = new FinalizerQueueMain("N5");
		f1 = null;
		f2 = null;
		f3 = null;
		f4 = null;
		f5 = null;

		System.out.println("开始GC");
		System.gc();

		Thread.sleep(60 * 1000);
		System.out.println("主线程结束");
	}
}
