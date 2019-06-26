package com.javabook.concurrent.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * JDK1.7 中提供了一个适用于多线程环境更快的随机数生成器
 * 
 * 技术原理-ThreadLocalRandom
 * 既然线程同步效率不高，使用ThreadLocal模式，让线程独享各自的Random对象
 * @author LuYang
 *
 */
public class ThreadLocalRandomDemo {
	public static void main(String[] args) throws InterruptedException {
		int number  = ThreadLocalRandom.current().nextInt();
		System.out.println(number);
	}
}

