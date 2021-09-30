package online.javabook.jvm.tuning.memory.heap.adjust;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 对象大小超过该值则直接在老年代分配，避免新生区的操作。仅仅适用Serial收集器和ParNew收集器
 *
 * -XX:PretenureSizeThreshold
 */
public class PretenureSizeThreshold {
}
