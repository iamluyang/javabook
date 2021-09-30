package online.javabook.jvm.tuning.gc.thread;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置用于年轻代和年老代并行垃圾回收的线程数。默认值取决于 JVM 可用的 CPU 数量。
 *
 * -XX:ParallelGCThreads=threads
 * Sets the number of threads used for parallel garbage collection in the young and old generations.
 * The default value depends on the number of CPUs available to the JVM.
 *
 * For example, to set the number of threads for parallel GC to 2, specify the following option:
 *
 * -XX:ParallelGCThreads=2
 */
public class ParallelGCThreads {
}
