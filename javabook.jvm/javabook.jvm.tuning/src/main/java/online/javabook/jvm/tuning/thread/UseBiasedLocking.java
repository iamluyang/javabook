package online.javabook.jvm.tuning.thread;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 禁用偏向锁定。启用此标志的一些具有大量无竞争同步的应用程序可能会获得显着的加速，而具有某些锁定模式的应用程序可能会出现减速。
 * 有关偏向锁定技术的更多信息，请参阅 Java 调优白皮书中的示例，网址为:
 * http://www.oracle.com/technetwork/java/tuning-139912.html#section4.2.5
 *
 * -XX:-UseBiasedLocking
 * Disables the use of biased locking. Some applications with significant amounts of uncontended synchronization may attain
 * significant speedups with this flag enabled, whereas applications with certain patterns of locking may see slowdowns.
 * For more information about the biased locking technique, see the example in Java Tuning White Paper at
 * http://www.oracle.com/technetwork/java/tuning-139912.html#section4.2.5
 *
 * By default, this option is enabled.
 */
public class UseBiasedLocking {
}
