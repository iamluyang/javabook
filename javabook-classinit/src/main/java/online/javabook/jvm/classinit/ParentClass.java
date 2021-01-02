package online.javabook.classinit;

import java.io.Serializable;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class ParentClass implements Cloneable, Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4578029789860800165L;

    /**
     * static field
     */
    public static double ParentClass_Not_Final_Static_Compile_Field = 1;

    /**
     * static field - RunTime
     */
    public static double ParentClass_Not_Final_Static_Runtime_Field = Math.random();

    /**
     * final static field - CompileTime
     */
    public static final double ParentClass_Final_Static_Compile_Field = 1;

    /**
     * final static field - RunTime
     */
    public static final double ParentClass_Final_Static_Runtime_Field = Math.random();

    static{
        // 仅仅初始化执行一次
        System.out.println("I am static block of the ParentClass");
    }

    public ParentClass() {
        System.out.println("I am constructor of the ParentClass.");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
