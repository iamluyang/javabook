package online.javabook.pattern.thread.producerconsumer;

import java.util.Random;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class EaterThread extends Thread {
	
	/**
	 * random
	 */
	private final Random random;
	
	/**
	 * table
	 */
	private final Table table;

	/**
	 * @param name
	 * @param table
	 * @param seed
	 */
	public EaterThread(String name, Table table, long seed) {
		super(name);
		this.table  = table;
		this.random = new Random(seed);
	}

	public void run() {
		try {
			while (true) {
				String cake = table.take();
				Thread.sleep(random.nextInt(1000));
			}
		} catch (InterruptedException e) {
		}
	}
}
