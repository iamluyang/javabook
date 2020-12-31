package com.javabook.jvm.germspace;

import java.util.Random;


/**
 * -XX:PermSize=8M -XX:+PrintGCDetails
 *
 * java.lang.OutOfMemoryError: PermGen space
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class JvmOutOfMemoryErrorOfPermGenSpaceDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Random random = new Random();
        for(;;){
            random.toString().intern();
        }
    }
}