package com.javabook.concurrent.utils;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ������
 * ����Ա��ԭ�пձ��в��ϵ�ˮ�������߲��ϴ�ԭ��װ��ˮ�ı��к�ˮ�� 
 * ������Ա����ˮ�������ߺ���ˮʱ���������ӽ��н�����һֱ�����ܶ���ʼ��
 * 
 */

public class ExchangerDemo {

	// exchanger
	static Exchanger<Cup> exchanger = new Exchanger<Cup>();
	
	// ���ı���
	static Cup cupA = new Cup("cupA", 0);
	// �յı���
	static Cup cupB = new Cup("cupB", 0);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Producer(2)).start();// ��ˮ���̵߳����ʸ���һЩ
		new Thread(new Customer(1)).start();// ��ˮ���̵߳����ʸ���һЩ
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
						System.out.println("�����߽�����ˮ�ı���[ " + currentCup.getName() + " ]" + currentCup + "->����������");
						currentCup = exchanger.exchange(currentCup);						
					} else {
						currentCup.add(speed);
						System.out.println("�����߽�ˮ��ӵ�����[ " + currentCup.getName() + " ]" + currentCup);
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
						System.out.println("�����߽�����ˮ�ı���[ " + currentCup.getName() + " ]" + currentCup + "->����������");
						currentCup = exchanger.exchange(currentCup);						
					} else {
						currentCup.del(speed);
						System.out.println("���������ñ����е�ˮ[ " + currentCup.getName() + " ]" + currentCup);
						Thread.sleep( ThreadLocalRandom.current().nextInt(2000) );
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	static class Cup {
		
		// ��������
		private String name;
		
		// ��������
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
