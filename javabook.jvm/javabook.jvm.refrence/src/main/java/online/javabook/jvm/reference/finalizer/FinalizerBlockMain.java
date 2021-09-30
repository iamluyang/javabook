package online.javabook.jvm.reference.finalizer;

/**
 * Finalizer守护线程处理finalize队列中的任务，finalize会阻塞直到处理完，才继续处理下一个finalize
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-9-25
 * 
 */
public class FinalizerBlockMain {

	/**
	 * name
	 */
	private String name;

	/**
	 * @param name
	 */
	public FinalizerBlockMain(String name) {
		super();
		this.name  = name;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println(Thread.currentThread().getName() + "守护线程：(" + Thread.currentThread().isDaemon() + ")" + "开始执行对象" + name + "的finalize方法");
		boolean tag = true;
		
		while (tag) {
			System.out.println(name+"的finalize正在运行. finalizer队列被阻塞");
			Thread.sleep(1000);
		}
		System.out.println(name+"的finalize结束");
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		System.out.println("主线程开始：" + Thread.currentThread().getName());

		FinalizerBlockMain f1 = new FinalizerBlockMain("N1");
		FinalizerBlockMain f2 = new FinalizerBlockMain("N2");
		FinalizerBlockMain f3 = new FinalizerBlockMain("N3");
		FinalizerBlockMain f4 = new FinalizerBlockMain("N4");
		FinalizerBlockMain f5 = new FinalizerBlockMain("N5");
		f1 = null;
		f2 = null;
		f3 = null;
		f4 = null;
		f5 = null;

		System.out.println("开始GC");
		System.gc();

		while (true) {
			Thread.sleep(5000);
			System.out.println("Running in main");
		}
	}
}
