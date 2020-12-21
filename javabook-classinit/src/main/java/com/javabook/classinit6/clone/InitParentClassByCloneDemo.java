package com.javabook.classinit6.clone;

import com.javabook.classinit.ChildClass;
import com.javabook.classinit.ParentClass;

public class InitParentClassByCloneDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		System.out.println("第1次创建ClassInitParent实例");
		ParentClass clazzInit1 = new ParentClass();

		System.out.println("第1次Clone ChildClass实例");
		ParentClass clone1 = (ParentClass) clazzInit1.clone();

		System.out.println("第2次Clone ChildClass实例");
		ParentClass clone2 = (ParentClass) clazzInit1.clone();
	}
}