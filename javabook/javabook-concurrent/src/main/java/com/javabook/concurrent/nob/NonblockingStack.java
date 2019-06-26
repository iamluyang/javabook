package com.javabook.concurrent.nob;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 非阻塞栈
 * 
 * @author LuYang
 * 
 * @param <E>
 */
public class NonblockingStack {

	// headRef
	AtomicReference<Node> headRef = new AtomicReference<Node>();

	/**
	 * @param item
	 */
	public void push(Object item) {

		Node newHeadNode = new Node(item);
		Node oldHeadNode;

		do {
			oldHeadNode = headRef.get();
			newHeadNode.next = oldHeadNode;

		// 如果此时被另一个线程的push抢先入栈，则退会重新尝试入栈
		} while (!headRef.compareAndSet(oldHeadNode, newHeadNode));
	}

	/**
	 * @return
	 */
	public Object pop() {

		Node oldHeadNode;
		Node newHeadNode;

		do {
			oldHeadNode = headRef.get();

			if (oldHeadNode == null)
				return null;
			newHeadNode = oldHeadNode.next;

		// 如果此时被另一个线程的pop抢先出栈，则退会重新尝试出栈
		} while (!headRef.compareAndSet(oldHeadNode, newHeadNode));
		
		return oldHeadNode.item;
	}

	// Node
	static class Node {

		final Object item;
		Node next;

		public Node(Object item) {
			this.item = item;
		}
	}
}
