package online.javabook.classinit;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class ChildClass extends ParentClass {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3932266286266527472L;

	/**
	 * static field
	 */
	public static double ChildClass_Not_Final_Static_Compile_Field = 1;
	
	/**
	 * static field - RunTime
	 */
	public static double ChildClass_Not_Final_Static_Runtime_Field = Math.random();
	
	/**
	 * final static field - CompileTime
	 */
	public static final double ChildClass_Final_Static_Compile_Field = 1;
	
	/**
	 * final static field - RunTime
	 */
	public static final double ChildClass_Final_Static_Runtime_Field = Math.random();
	
	static{
		// 仅仅初始化执行一次
		System.out.println("I am static block of the ChildClass.");
	}

	public ChildClass() {
		System.out.println("I am constructor of the ChildClass.");
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
