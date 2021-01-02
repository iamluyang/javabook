package online.javabook.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LuYang
 *
 */
public class ConditionDemo {

	/**
	 * lock
	 */
	final Lock lock = new ReentrantLock();
	
	/**
	 * notFull
	 */
	final Condition notFull     = lock.newCondition();
	
	/**
	 * notEmpty
	 */
	final Condition notEmpty = lock.newCondition();

	/**
	 * items
	 */
	final Object[] items = new Object[100];
	
	/**
	 * putptr
	 */
	int putptr;
	
	/**
	 * takeptr
	 */
	int takeptr;
	
	/**
	 * count
	 */
	int count;

	/**
	 * @param x
	 * @throws InterruptedException
	 */
	public void put(Object x) throws InterruptedException {
		
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();
			
			items[putptr] = x;
			if (++putptr == items.length)
				putptr = 0;
			
			++count;			
			notEmpty.signal();
			
		} finally {
			lock.unlock();
		}
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public Object take() throws InterruptedException {
		
		lock.lock();
		try {
			while (count == 0)
				notEmpty.await();
			
			Object x = items[takeptr];
			
			if (++takeptr == items.length)
				takeptr = 0;
			
			--count;
			notFull.signal();
			
			return x;
		} finally {
			lock.unlock();
		}
	}

}
