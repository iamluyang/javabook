package com.javabook.concurrent.cas.ato;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * AtomicIntegerFieldUpdater 基于反射的实用工具，可以对指定类的指定 volatile int 字段进行原子更新。
 * 此类用于原子数据结构，该结构中同一节点的几个字段都独立受原子更新控制。
 * 
 * 注意，此类中 compareAndSet 方法的保证弱于其他原子类中该方法的保证。 因
 * 为此类不能确保所有使用的字段都适合于原子访问目的，所以对于相同更新器上的 compareAndSet 和 set
 * 的其他调用，它仅可以保证原子性和可变语义。
 * 
 * =================================== AtomicIntegerFieldUpdater是一个抽象类型  ===================================
 * 
 * AtomicReferenceFieldUpdater
 * 
 * 基于反射的实用工具，可以对指定类的指定 volatile字段进行原子更新。 该类用于原子数据结构，该结构中同一节点的几个引用字段都独立受原子更新控制。
 * 例如，树节点可能声明为
 * 
 * class Node { private volatile Node left, right;
 * 
 * private static final AtomicReferenceFieldUpdater leftUpdater =
 * AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "left");
 * private static AtomicReferenceFieldUpdater rightUpdater =
 * AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "right");
 * 
 * Node getLeft() { return left; } boolean compareAndSetLeft(Node expect, Node
 * update) { return leftUpdater.compareAndSet(this, expect, update); } // ...
 * and so on }
 * 
 * 注意，此类中 compareAndSet 方法的保证弱于其他原子类中该方法的保证。 因为此类不能确保所有使用的字段都适合于原子访问目的， 所以，对于
 * compareAndSet 和 set的其他调用，它仅可以保证原子性和可变语义。
 * 
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public final class AtomicFieldUpdaterDemo {

	// value
	private AtomicIntegerFieldUpdater updater1 = AtomicIntegerFieldUpdater.newUpdater(AtomicFieldUpdaterDemo.class, "");

	private AtomicLongFieldUpdater updater2 = AtomicLongFieldUpdater.newUpdater(AtomicFieldUpdaterDemo.class, "");

	private AtomicReferenceFieldUpdater updater3 = AtomicReferenceFieldUpdater.newUpdater(AtomicFieldUpdaterDemo.class,	AtomicFieldUpdaterDemo.class, "");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AtomicFieldUpdaterDemo counter = new AtomicFieldUpdaterDemo();
	}
}
