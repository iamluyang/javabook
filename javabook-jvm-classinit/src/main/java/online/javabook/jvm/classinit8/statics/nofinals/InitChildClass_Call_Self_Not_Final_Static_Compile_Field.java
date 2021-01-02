package online.javabook.jvm.classinit8.statics.nofinals;

import online.javabook.jvm.classinit.ChildClass;

/**
 * <ul>访问类型的final static编译期字段
 * 	<li>观察类型的初始化顺序
 *  <li>观察类型的初始化次数
 * </ul>
 * @author LuYang
 *
 */
public class InitChildClass_Call_Self_Not_Final_Static_Compile_Field {

	public static void main(String[] args) {	
		
		System.out.println("第1次访问类型的static字段(编译时)");
		System.out.println( ChildClass.ChildClass_Not_Final_Static_Compile_Field);
		
		System.out.println("第2次访问类型的static字段(编译时)");
		System.out.println( ChildClass.ChildClass_Not_Final_Static_Compile_Field);
	}
}