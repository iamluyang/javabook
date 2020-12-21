package com.javabook.classinit6.clone;

import com.javabook.classinit.ChildClass;
import com.javabook.classinit.ParentClass;

public class InitChildClassByCloneDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		System.out.println("第1次创建ChildClass实例");
		ChildClass clazzInit1 = new ChildClass();
		
		System.out.println("第1次Clone ChildClass实例");
		ChildClass clone1 = (ChildClass) clazzInit1.clone();

		System.out.println("第2次Clone ChildClass实例");
		ChildClass clone2 = (ChildClass) clazzInit1.clone();
	}
}