package online.javabook.jvm.tuning.memory.heap.adjust;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置堆空间最小空闲比例，当堆空间空闲内存低于该数值后，JVM堆会扩容
 *
 * -XX:MinHeapFreeRatio=percent
 * Sets the minimum allowed percentage of free heap space (0 to 100) after a GC event. If free heap space falls below this value,
 * then the heap will be expanded. By default, this value is set to 40%.
 *
 * The following example shows how to set the minimum free heap ratio to 25%:
 *
 * -XX:MinHeapFreeRatio=25
 * --------------------------------------------------------------------
 *
 * 设置堆空间最大空闲比例，当堆空间空闲内存高于该数值后，JVM堆会收缩
 *
 * -XX:MaxHeapFreeRatio=percent
 * Sets the maximum allowed percentage of free heap space (0 to 100) after a GC event.
 * If free heap space expands above this value, then the heap will be shrunk. By default, this value is set to 70%.
 *
 * The following example shows how to set the maximum free heap ratio to 75%:
 * -XX:MaxHeapFreeRatio=75
 */
public class MaxHeapFreeRatio {
}
