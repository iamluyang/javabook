package online.javabook.jcu.sync;

import java.util.concurrent.Exchanger;

/**
 * 案例：
 * 服务员向原有空杯中不断倒水，消费者不断从原有装满水的杯中喝水。
 * 当服务员倒满水和消费者喝完水时，两个杯子进行交换。一直这样周而复始。
 *
 */

public class ExchangerDemo {

	// exchanger
	static Exchanger<Cup> exchanger = new Exchanger<Cup>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Customer(new Cup("cupA", 0))).start();// 喝水的线程的速率更慢一些
		new Thread(new Producer(new Cup("cupB", 0))).start();// 倒水的线程的速率更快一些
	}

	// Customer
	static class Customer implements Runnable {

		Cup cup;

		public Customer(Cup cup) {
			this.cup = cup;
		}

		@Override
		public void run() {

			Cup currentCup = cup;

			while (true) {

				try {
					if (this.cup.isEmpty()) {
						System.out.println("消费者将喝完水的杯子:" + this.cup + "->交给服务者");
						Cup fullCup = exchanger.exchange(this.cup);
						this.cup = fullCup;
					} else {
						this.cup.del(1);
						Thread.sleep(2000);
						System.out.println("消费者饮用杯子中的水:" + this.cup);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// Producer
	static class Producer implements Runnable {

		Cup cup;

		public Producer(Cup cup) {
			this.cup = cup;
		}

		@Override
		public void run() {

			Cup currentCup = cup;

			while (true) {
				try {
					if (this.cup.isFull()) {
						System.out.println("服务者将斟满水的杯子:" + this.cup + "->交给消费者");
						Cup emptyCup = exchanger.exchange(this.cup);
						this.cup = emptyCup;
					} else {
						this.cup.add(1);
						Thread.sleep(1000);
						System.out.println("服务者将水添加到杯子:" + this.cup);
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
			processing.append(this.name + ":[");
			for(int count=0; count<capacity; count++){
				processing.append(".");
			}
			processing.append("]" + capacity);
			return processing.toString();
		}
	}
}