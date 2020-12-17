package com.javabook.jvm.gc.finalize;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-9-25
 * 
 */
public class Nothing {

	/**
	 * name
	 */
	private String name;
	
	/**
	 * bytes
	 */
	private byte[] bytes = new byte[1024];

	/**
	 * @param name
	 * @param total
	 */
	public Nothing(String name, int total) {
		super();
		this.name  = name;
		this.bytes = new byte[total];
	}

	@Override
	protected void finalize() throws Throwable {

		System.out.println(Thread.currentThread().getName() + "守护线程：" + "开始执行对象" + this + "->" + name + "的finalize方法");
		boolean tag = true;
		
		//while (tag) {
			Thread.sleep(5000);
			System.out.print(name+":"+"sleep");
		//}
		
		System.out.println("结束finalize");
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		System.out.println("主线程开始：" + Thread.currentThread().getName());

		Nothing f1 = new Nothing("N1", 1024);
		Nothing f2 = new Nothing("N2", 1024);
		Nothing f3 = new Nothing("N3", 1024);
		Nothing f4 = new Nothing("N4", 1024);
		Nothing f5 = new Nothing("N5", 1024);
		f1 = null;
		f2 = null;
		f3 = null;
		f4 = null;
		f5 = null;

		System.out.println("开始GC");
		System.gc();
		//Thread.sleep(0  * 1000);
		//Thread.sleep(1  * 1000);
		Thread.sleep(60 * 1000);
		System.out.println("主线程结束"); // 当主线程结束后，Finalizer线程也会结束，由此可以推断出Finalizer是一个守护线程
	}
}
