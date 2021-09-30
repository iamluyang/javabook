package online.javabook.jvm.gc.oom.metaspace;

import java.util.Random;

/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 *
 * <p>
 * -Xms2m -Xmx2m -XX:MaxMetaspaceSize=2M -XX:+PrintGCDetails
 * <p>
 * Error occurred during initialization of VM
 * OutOfMemoryError: Metaspace
 *
 * JDK8中使用了Metaspace区代替了JDK7中的永生区
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 */
public class JvmOutOfMemoryErrorOfMetaSpaceDemo2 {

    /**
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException {

        Random random = new Random();
        for(;;){
            random.toString().intern();
        }
    }
}