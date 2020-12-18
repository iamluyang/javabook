package com.javabook.classinit.instance;

import com.javabook.classinit.ChildClass;

/**
 * <ul>newInstance的方式创建类型的对象
 * 	<li>观察子类型静态代码的初始化顺序
 *  <li>观察子类型构造函数的初始化顺序
 * 	<li>观察子类型静态代码块的执行次数
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByClassNewInstanceChildClassDemo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		System.out.println("第1次以newInstance的方式创建ClassChild类型的对象");
		ChildClass.class.newInstance();

		System.out.println("第2次以newInstance的方式创建ClassChild类型的对象");
		ChildClass.class.newInstance();
	}
}