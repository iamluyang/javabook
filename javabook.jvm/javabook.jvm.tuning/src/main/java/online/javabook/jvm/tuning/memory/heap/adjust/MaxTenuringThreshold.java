package online.javabook.jvm.tuning.memory.heap.adjust;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置新生代对象遭受GC的次数并向年老代晋升的阈值。
 *
 * 如果同龄的对象已经超过Survivor Space的一半，即便这些对象 没有到达MaxTenuringThreshold所规定的年龄值，
 * 这些对象也将直接进入Old Generation，也包括Survivor Space中年龄更大的对象。该值越大对象在新生代的时间可能会越久
 *
 * -XX:MaxTenuringThreshold=threshold
 * Sets the maximum tenuring threshold for use in adaptive GC sizing. The largest value is 15.
 * The default value is 15 for the parallel (throughput) collector, and 6 for the CMS collector.
 * The following example shows how to set the maximum tenuring threshold to 10:
 * -XX:MaxTenuringThreshold=10
 */
public class MaxTenuringThreshold {
}
