package online.javabook.jvm.tuning.gc.adjust;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置最大 GC 暂停时间的目标（以毫秒为单位）。这是一个软目标，JVM将尽最大努力实现它。默认情况下，没有最大暂停时间值。
 *
 * -XX:MaxGCPauseMillis=time
 * Sets a target for the maximum GC pause time (in milliseconds). This is a soft goal, and the JVM will make its best effort to achieve it.
 * By default, there is no maximum pause time value.
 *
 * The following example shows how to set the maximum target pause time to 500 ms:
 *
 * -XX:MaxGCPauseMillis=500
 */
public class MaxGCPauseMillis {
}
