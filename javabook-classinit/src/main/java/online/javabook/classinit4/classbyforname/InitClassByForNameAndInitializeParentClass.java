package online.javabook.classinit4.classbyforname;

/**
 * <ul>通过Class.forName加载指定类型
 * 	<li>观察类型的静态块的初始化顺序
 *  <li>观察类型的静态块的初始化次数
 *  <li>观察类型的构造函数是否被调用
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByForNameAndInitializeParentClass {

	public static void main(String[] args) throws ClassNotFoundException {
		
		System.out.println("第1次加载ParentClass");
		Class class1 = Class.forName("online.javabook.classinit.ParentClass");
		
		System.out.println("第2次加载ParentClass");
		Class class2 = Class.forName("online.javabook.classinit.ParentClass");

		System.out.println("class1 == class2 -> " + (class1 == class2));
	}
}