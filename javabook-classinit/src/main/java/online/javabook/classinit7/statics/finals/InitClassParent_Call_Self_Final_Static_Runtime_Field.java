package online.javabook.classinit7.statics.finals;

import online.javabook.classinit.ParentClass;

/**
 * <ul>访问类型的final static运行期字段
 * 	<li>观察类型的初始化顺序
 *  <li>观察类型的初始化次数
 * </ul>
 * @author LuYang
 *
 */
public class InitClassParent_Call_Self_Final_Static_Runtime_Field {

	public static void main(String[] args) {
		
		System.out.println("第1次访问类型的final static字段(运行时)");
		System.out.println( ParentClass.ParentClass_Final_Static_Runtime_Field);
		
		System.out.println("第2次访问类型的final static字段(运行时)");
		System.out.println( ParentClass.ParentClass_Final_Static_Runtime_Field);
	}
}