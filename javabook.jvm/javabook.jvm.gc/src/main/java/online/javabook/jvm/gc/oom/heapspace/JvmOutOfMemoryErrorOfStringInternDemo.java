package online.javabook.jvm.gc.oom.heapspace;

import java.util.Random;


/**
 * JDK7和JDK7之前的JVM会报错PermGen space，intern字符串会分配在永生区。而JDK8后String常量被分配在堆中
 *
 * -XX:PermSize=16M -Xms16m -Xmx16m -XX:+PrintGCDetails
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class JvmOutOfMemoryErrorOfStringInternDemo {

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