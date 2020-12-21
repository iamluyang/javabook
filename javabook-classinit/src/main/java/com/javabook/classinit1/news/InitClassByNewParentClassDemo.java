package com.javabook.classinit1.news;

import com.javabook.classinit.ParentClass;

/**
 * <ul>通过new一个类型的对象初始化当前类，并初始化新创建的对象
 * 	<li>观察子类型静态代码的初始化顺序
 *  <li>观察子类型构造函数的初始化顺序
 * 	<li>观察子类型静态代码块的执行次数
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByNewParentClassDemo {

	public static void main(String[] args) {
		
		System.out.println("第1次新建ParentClass类型的对象");
		ParentClass clazzInit1 = new ParentClass();
		
		System.out.println("第2次新建ParentClass类型的对象");
		ParentClass clazzInit2 = new ParentClass();
	}
}
