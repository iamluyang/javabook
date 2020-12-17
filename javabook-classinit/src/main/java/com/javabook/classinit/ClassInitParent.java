package com.javabook.classinit;

import java.io.Serializable;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class ClassInitParent implements Cloneable,Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4578029789860800165L;

    /**
     * static field
     */
    public static double staticfield_Compile_inParent = 1;

    /**
     * static field - RunTime
     */
    public static double staticfield_Runtime_inParent = Math.random();

    /**
     * final static field - CompileTime
     */
    public static final double finalstaticfield_Compile_inParent = 1;

    /**
     * final static field - RunTime
     */
    public static final double finalstaticfield_Runtime_inParent = Math.random();

    static{
        // 仅仅初始化执行一次
        System.out.println("I am static block of the ClassInitParent");
    }

    public ClassInitParent() {
        System.out.println("I am constructor of the ClassInitParent.");
    }
}
