package online.javabook.pattern.thread.producerconsumer;

import java.util.Random;

/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class MakerThread extends Thread {
	
	/**
	 * random
	 */
	private final Random random;
	
	/**
	 * table
	 */
	private final Table table;
	
	/**
	 * id
	 */
	private static int id = 0; 

	/**
	 * @param name
	 * @param table
	 * @param seed
	 */
	public MakerThread(String name, Table table, long seed) {
		super(name);
		this.table = table;
		this.random = new Random(seed);
	}

	public void run() {
		try {
			while (true) {
				Thread.sleep(random.nextInt(1000));
				String cake = "[ Cake No." + nextId() + " by " + getName() + " ]";
				table.put(cake);
			}
		} catch (InterruptedException e) {
		}
	}

	private static synchronized int nextId() {
		return id++;
	}
}
