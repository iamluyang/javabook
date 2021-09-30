package online.javabook.jvm.gc.oom.germspace;

import java.util.Random;


/**
 * JDK7和JDK7之前的JVM会报错PermGen space，intern字符串会分配在永生区。而JDK8后String常量被分配在堆中
 *
 *
 * -Xms16m -Xmx16m -XX:PermSize=1M -XX:+PrintStringTableStatistics -XX:+PrintGCDetails
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