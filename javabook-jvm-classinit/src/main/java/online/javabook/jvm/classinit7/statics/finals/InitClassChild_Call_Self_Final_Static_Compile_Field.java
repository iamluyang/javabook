package online.javabook.jvm.classinit7.statics.finals;

import online.javabook.jvm.classinit.ChildClass;

/**
 * <ul>访问类型的final static编译期字段
 * 	<li>观察类型的初始化顺序
 *  <li>观察类型的初始化次数
 * </ul>
 * @author LuYang
 *
 */
public class InitClassChild_Call_Self_Final_Static_Compile_Field {

	public static void main(String[] args) {
		
		System.out.println("第1次访问类型的final static字段(编译时)");
		System.out.println( ChildClass.ChildClass_Final_Static_Compile_Field);
		
		System.out.println("第2次访问类型的final static字段(编译时)");
		System.out.println( ChildClass.ChildClass_Final_Static_Compile_Field);
	}
}