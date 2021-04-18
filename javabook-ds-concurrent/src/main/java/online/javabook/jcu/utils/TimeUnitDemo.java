package online.javabook.jcu.utils;

import java.util.concurrent.TimeUnit;

/**
 * 技术原理-TimeUnit
 * 时间转换相关：
 * 1 提供了纳秒，微秒，毫秒，秒，分钟，小时，天这些时间单位在相互转换
 *
 * 与线程相关:
 * 1 提供了基于对象wait工具方法
 * 		public void timedWait(Object obj, long timeout)
 * 2 提供了基于指定线程的join工具方法
 * 		public void timedJoin(Thread thread, long timeout)
 * 3 提供了基于当前线程的sleep工具方法
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
