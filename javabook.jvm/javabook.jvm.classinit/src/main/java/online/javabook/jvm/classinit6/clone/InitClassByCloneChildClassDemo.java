package online.javabook.jvm.classinit6.clone;

import online.javabook.jvm.classinit.ChildClass;

public class InitClassByCloneChildClassDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		System.out.println("第1次创建ChildClass实例");
		ChildClass clazzInit1 = new ChildClass();
		
		System.out.println("第1次Clone ChildClass实例");
		ChildClass clone1 = (ChildClass) clazzInit1.clone();

		System.out.println("第2次Clone ChildClass实例");
		ChildClass clone2 = (ChildClass) clazzInit1.clone();
	}
}