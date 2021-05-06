package online.javabook.jvm.classinit4.classbyforname;

/**
 * <ul>通过Class.forName加载指定类型
 * 	<li>观察类型的静态块的是否被初始化
 *  <li>观察类型的构造函数是否被初始化
 * </ul>
 * @author LuYang
 *
 */
public class InitClassByForNameAndNotInitializeParentClass {

	public static void main(String[] args) throws ClassNotFoundException {
		
		System.out.println("第1次加载ParentClass");
		Class<?> class1 = Class.forName("online.javabook.classinit.ParentClass",false, InitClassByForNameAndNotInitializeParentClass.class.getClassLoader());
		
		System.out.println("第2次加载ClassParent");
		Class<?> class2 = Class.forName("online.javabook.classinit.ParentClass",false, InitClassByForNameAndNotInitializeParentClass.class.getClassLoader());

		System.out.println("class1 == class2 -> " + (class1 == class2));
	}
}