package online.javabook.jvm.reference.finalizer;

import sun.misc.IOUtils;

import java.io.File;

/**
 * 当主线程结束后，Finalizer线程也会结束，由此可以推断出 Finalizer 是一个守护线程, 当最后一个非守护线程结束时，守护线程随着JVM一同结束工作.
 * 没有来得及处理的finalize就不了了之了
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-9-25
 * 
 */
public class FinalizerDaemonMain {

	/**
	 * name
	 */
	private String name;

	/**
	 * @param name
	 */
	public FinalizerDaemonMain(String name) {
		super();
		this.name  = name;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println(Thread.currentThread().getName() + "守护线程：(" + Thread.currentThread().isDaemon() + ")" + "开始执行对象" + name + "的finalize方法");
		System.out.println(name+"的finalize正在运行.");
		File file = new File("c:\\a.txt");

		Thread.sleep(10000);
		System.out.println(name+"的finalize结束");
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		System.out.println("主线程开始：" + Thread.currentThread().getName());

		FinalizerDaemonMain f1 = new FinalizerDaemonMain("N1");
		FinalizerDaemonMain f2 = new FinalizerDaemonMain("N2");
		FinalizerDaemonMain f3 = new FinalizerDaemonMain("N3");
		FinalizerDaemonMain f4 = new FinalizerDaemonMain("N4");
		FinalizerDaemonMain f5 = new FinalizerDaemonMain("N5");
		f1 = null;
		f2 = null;
		f3 = null;
		f4 = null;
		f5 = null;

		System.out.println("开始GC");
		System.gc();

		System.out.println("主线程结束");
	}
}
