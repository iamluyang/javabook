package online.javabook.concurrent.utils;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 案例：
 * 服务员向原有空杯中不断倒水，消费者不断从原有装满水的杯中喝水。
 * 当服务员倒满水和消费者喝完水时，两个杯子进行交换。一直这样周而复始。
 *
 */

public class ExchangerDemo {

	// exchanger
	static Exchanger<Cup> exchanger = new Exchanger<Cup>();

	// 满的杯子
	static Cup cupA = new Cup("cupA", 0);
	// 空的杯子
	static Cup cupB = new Cup("cupB", 0);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Producer(2)).start();// 倒水的线程的速率更快一些
		new Thread(new Customer(1)).start();// 喝水的线程的速率更慢一些
	}

	// Producer
	static class Producer implements Runnable {

		/**
		 * speed
		 */
		int speed;

		/**
		 * @param speed
		 */
		public Producer(int speed) {
			this.speed = speed;
		}

		@Override
		public void run() {

			Cup currentCup = cupA;

			while (currentCup != null) {
				try {
					if (currentCup.isFull()) {
						System.out.println("服务者将斟满水的杯子[ " + currentCup.getName() + " ]" + currentCup + "->交给消费者");
						currentCup = exchanger.exchange(currentCup);
					} else {
						currentCup.add(speed);
						System.out.println("服务者将水添加到杯子[ " + currentCup.getName() + " ]" + currentCup);
						Thread.sleep( ThreadLocalRandom.current().nextInt(2000) );
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Customer
	static class Customer implements Runnable {

		int speed;

		public Customer(int speed) {
			this.speed = speed;
		}

		@Override
		public void run() {

			Cup currentCup = cupB;

			while (currentCup != null) {

				try {
					if (currentCup.isEmpty()) {
						System.out.println("消费者将喝完水的杯子[ " + currentCup.getName() + " ]" + currentCup + "->交给服务者");
						currentCup = exchanger.exchange(currentCup);
					} else {
						currentCup.del(speed);
						System.out.println("消费者饮用杯子中的水[ " + currentCup.getName() + " ]" + currentCup);
						Thread.sleep( ThreadLocalRandom.current().nextInt(2000) );
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	static class Cup {

		// 杯子名称
		private String name;

		// 杯子容量
		private int capacity = 0;

		/**
		 * @param capacity
		 */
		public Cup(String name, int capacity) {
			this.name = name;
			this.capacity = capacity;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		public void add(int i) {
			capacity += i;
			capacity = capacity > 10 ? 10 : capacity;
		}

		public void del(int i) {
			capacity -= i;
			capacity = capacity < 0 ? 0 : capacity;
		}

		public boolean isFull() {
			return capacity == 10 ? true : false;
		}

		public boolean isEmpty() {
			return capacity == 0 ? true : false;
		}

		@Override
		public String toString() {
			StringBuffer processing = new StringBuffer();
			processing.append("[");
			for(int count=0; count<capacity; count++){
				processing.append(".");
			}
			processing.append("]" + capacity);
			return processing.toString();
		}
	}
}