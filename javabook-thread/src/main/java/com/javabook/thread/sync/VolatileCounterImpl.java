package com.javabook.thread.sync;

/**
 * <ul>
 * ����volatile�ļ�����������һ���ڶ��̻߳����²��ɿ��ļ�����
 * <li>volatile���ܱ�֤�ڴ�Ŀɼ���
 * <li>volatile���ܱ��ϲ�����ԭ����
 * </ul>
 * 
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2015-1-27
 *
 */
public final class VolatileCounterImpl implements ICounter {

	/**
	 * value
	 */
	private volatile long value = 0;

	@Override
	public long get() {
		return value;
	}

	@Override
	public long increment() {
		return value++;
	}

	@Override
	public long decrement() {
		return value--;
	}
}