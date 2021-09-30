package online.javabook.jvm.tuning.gc.thread;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置用于并发 GC 的线程数。默认值取决于 JVM 可用的 CPU 数量。
 *
 * -XX:ConcGCThreads=threads
 * Sets the number of threads used for concurrent GC. The default value depends on the number of CPUs available to the JVM.
 *
 * For example, to set the number of threads for concurrent GC to 2, specify the following option:
 *
 * -XX:ConcGCThreads=2
 */
public class ConcGCThreads {
}
