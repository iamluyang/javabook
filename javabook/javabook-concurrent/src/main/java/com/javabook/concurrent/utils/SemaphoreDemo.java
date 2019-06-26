package com.javabook.concurrent.utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * �����ź�����������ͬʱ����ĳ���ض���Դ�Ĳ�������
 * 
 * ������
 * 1.���ڿ���ͬʱ����ĳЩ�ض���Դ���߳����������н�����
 * 2.��������ͬʱִ��ĳ��ָ���������߳�������
 * 
 * ������
 * ��ֵ�ź��� Semaphore mutex = new Semaphore(1)
 * ���ź�����ʼ��Ϊ 1��ʹ������ʹ��ʱ���ֻ��һ�����õ���ɣ��Ӷ�������һ���໥�ų������
 * 
 * @author Administrator
 * 
 */
public class SemaphoreDemo {

	/**
	 * pool
	 */
	private Set<Object> set;

	/**
	 * semaphoreBound
	 */
	private final Semaphore semaphoreBound;

	/**
	 * @param maxPool
	 */
	public SemaphoreDemo(int bound) {
		this.set  = Collections.synchronizedSet( new HashSet<Object>() );
		this.semaphoreBound = new Semaphore(bound);
	}

	/**
	 * @param x
	 * @return
	 * @throws Exception
	 */
	public boolean add(Object x) throws Exception {
		
		// acquire������ʾ����һ����ɣ��ź���������ĳ��������ɵ��̹߳���
		// ��˿�����һ���߳��л�ȡ��ɣ���������һ���߳����ͷ����
		semaphoreBound.acquire();
		boolean added = false;
		try {
			added = set.add(x);
			return added;
		} finally {
			if(!added)
				semaphoreBound.release();
		}
	}

	/**
	 * @param x
	 * @return
	 * @throws Exception
	 */
	public boolean remove(Object x) throws Exception {
		
		// release������ʾ�ͷ�һ����ɣ��ź���������ĳ���ͷ���ɵ��̹߳���
		// ��˿�����һ���߳����ͷ���ɣ���������һ���߳��л�ȡ���
		boolean removed = set.remove(x);
		if(removed) semaphoreBound.release();
		return removed;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

