package com.javabook.concurrent.utils;

import java.util.concurrent.TimeUnit;

/**
 * ����ԭ��-TimeUnit
 * ʱ��ת����أ�
 * 1 �ṩ�����룬΢�룬���룬�룬���ӣ�Сʱ������Щʱ�䵥λ���໥ת��
 * 
 * ���߳����:
 * 1 �ṩ�˻��ڶ���wait���߷���
 * 		public void timedWait(Object obj, long timeout)
 * 2 �ṩ�˻���ָ���̵߳�join���߷���
 * 		public void timedJoin(Thread thread, long timeout)
 * 3 �ṩ�˻��ڵ�ǰ�̵߳�sleep���߷���
 * 		public void sleep(long timeout) throws InterruptedException
 * @author LuYang
 *
 */
public class TimeUnitDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println( TimeUnit.SECONDS.toMinutes(60) );
		System.out.println( TimeUnit.SECONDS.toHours(3600) );
	}
}

