package online.javabook.jvm.classinit1.news;

import online.javabook.jvm.classinit.ChildClass;

/**
 * <ul>通过new一个类型的对象初始化当前类，并初始化新创建的对象
 * 	<li>观察子类型静态代码的初始化顺序
 *  <li>观察子类型构造函数的初始化顺序
 * 	<li>观察子类型静态代码块的执行次数
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByNewChildClassDemo {

	public static void main(String[] args) {
		
		System.out.println("第1次新建ChildClass类型的对象");
		ChildClass clazzInit1 = new ChildClass();
		
		System.out.println("第2次新建ChildClass类型的对象");
		ChildClass clazzInit2 = new ChildClass();
	}
}
