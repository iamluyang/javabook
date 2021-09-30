package online.javabook.jvm.tuning.gc.adjust;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 在抛出 OutOfMemoryError 异常之前，允许使用限制JVM在GC上花费的时间比例的策略。
 * 默认情况下启用此选项，如果超过 98% 的总时间花在垃圾收集上并且回收的堆少于 2%，则并行 GC 将抛出 OutOfMemoryError。
 * 当堆很小时，此功能可用于防止应用程序长时间运行而几乎没有或没有进展。
 *
 * -XX:+UseGCOverheadLimit
 * Enables the use of a policy that limits the proportion of time spent by the JVM on GC before an OutOfMemoryError exception is thrown.
 * This option is enabled, by default and the parallel GC will throw an OutOfMemoryError if more than 98% of the total time is spent
 * on garbage collection and less than 2% of the heap is recovered. When the heap is small,
 * this feature can be used to prevent applications from running for long periods of time with little or no progress.
 * To disable this option, specify -XX:-UseGCOverheadLimit.
 */
public class UseGCOverheadLimit {
}
