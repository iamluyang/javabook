package com.javabook.concurrent.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * JDK1.7 ���ṩ��һ�������ڶ��̻߳�������������������
 * 
 * ����ԭ��-ThreadLocalRandom
 * ��Ȼ�߳�ͬ��Ч�ʲ��ߣ�ʹ��ThreadLocalģʽ�����̶߳�����Ե�Random����
 * @author LuYang
 *
 */
public class ThreadLocalRandomDemo {
	public static void main(String[] args) throws InterruptedException {
		int number  = ThreadLocalRandom.current().nextInt();
		System.out.println(number);
	}
}

