package com.javabook.concurrent.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ������CountDownLatch
 * 
 * @author LuYang
 * 
 */
public class CountDownLatchDemo {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		int runnerCount = 9;
		
		// ����������ʼ�Ŀ���������˶�Ա�����������߲����������ʼ
		CountDownLatch startCountDown = new CountDownLatch(1);
		
		// �������������Ŀ���
		// �� runnerCount ���˶�Ա������ֱ�������˶��ܵ����յ����������ʽ����
		CountDownLatch endCountDown = new CountDownLatch(runnerCount);

		// runnerCount���˶�Ա½������
		for (int i = 1; i <= runnerCount; i++) {
			Thread runner = new Thread(new Running(i, startCountDown, endCountDown));
			runner.start();
		}
				
		// ����������ʼ
		Thread.sleep(2000);
		System.out.println("������ʼ");
		startCountDown.countDown();

		// ������������
		endCountDown.await();		
		System.out.println("��������");
	}

	static class Running implements Runnable {
		
		private int id;
		private CountDownLatch startCountDown;
		private CountDownLatch endCountDown;		

		public Running(int id, CountDownLatch startCountDown, CountDownLatch endCountDown) {
			this.id = id;
			this.startCountDown = startCountDown;
			this.endCountDown   = endCountDown;			
		}

		@Override
		public void run() {
			try {
				System.out.println(id + "�����������ߣ����ȴ������˶�Ա�ĵ�����");
				startCountDown.await();
				
				try {
					// ��ǰ�˶�Ա�����ܲ���������ʱ9�뵽12�룩
					Thread.sleep( ThreadLocalRandom.current().nextInt(9000, 12000));
					
					// ��ǰ�˶�Ա�����ܲ�����	
					System.out.println(id + "����ɱ���");				
				} finally {
					// ��ǰ�˶�Ա������ɱ���
					endCountDown.countDown();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
