package online.javabook.jvm.tuning.memory.metaspace;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 最小永生区 -XX:PermSize 和最大永生区 -XX:MaxPermSize 设置
 * --------------------------------------------------------------------
 * -XX:MaxPermSize=size
 * Sets the maximum permanent generation space size (in bytes).
 * This option was deprecated in JDK 8, and superseded by the -XX:MaxMetaspaceSize option.
 * --------------------------------------------------------------------
 * -XX:PermSize=size
 * Sets the space (in bytes) allocated to the permanent generation that triggers a garbage collection if it is exceeded.
 * This option was deprecated un JDK 8, and superseded by the -XX:MetaspaceSize option.
 * --------------------------------------------------------------------
 */
public class PermSize {
}
