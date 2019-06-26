package com.javabook.thread.bug.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 比较并交换 (CAS)操作包含三个操作数 ：内存位置（V）、预期原值（A）和新值(B)。
 * 如果内存位置的值与预期原值相匹配，那么处理器会自动将该位置值更新为新值。否则，处理器不做任何操作。无论哪种情况，它都会在 CAS 指令之前返回该位置的值。
 * CAS 有效地说明了“我认为位置 V应该包含值 A； 如果包含该值，则将 B放到这个位置；否则，不要更改该位置，只告诉我这个位置现在的值即可。在 CAS
 * 的一些特殊情况下将仅返回 CAS是否成功，而不提取当前值。
 * 
 * 通常将 CAS 用于同步的方式是从地址 V 读取值 A，执行多步计算来获得新值 B，然后使用 CAS 将 V 的值从 A 改为 B。如果 V
 * 处的值尚未同时更改，则 CAS 操作成功。 类似于 CAS
 * 的指令允许算法执行读-修改-写操作，而无需害怕其他线程同时修改变量，因为如果其他线程修改变量，那么 CAS 会检测它（并失败），算法可以对该操作重新计算。
 * CAS 的价值是它可以在硬件中实现，并且是极轻量级的（在大多数处理器中）：
 * 
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-22
 * 
 */
public class UnsafeCASCounter {

	/**
	 * casNumber
	 */
	private AtomicInteger number = new AtomicInteger();

	/**
	 * @return
	 */
	public int increment() {

		for (;;) {
			int expect = number.get();
			int update = expect + 1;
			if (number.compareAndSet(expect, update))
				return update;
		}
	}

	/**
	 * @return
	 */
	public int decrement() {

		for (;;) {
			int expect = number.get();
			int update = expect - 1;
			if (number.compareAndSet(expect, update))
				return update;
		}
	}
}
