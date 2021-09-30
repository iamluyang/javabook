package online.javabook.jvm.tuning.memory.heap;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置年轻代和年老代大小之间的比例
 *
 * -XX:NewRatio=ratio
 * Sets the ratio between young and old generation sizes.
 * By default, this option is set to 2. The following example shows how to set the young/old ratio to 1:
 * -XX:NewRatio=1
 *
 * 默认比例示意图
 *       1                 2
 * |-----------|-----------|-----------|
 * |<--Young-->|<---------Old--------->|
 *
 * --------------------------------------------------------------------
 *
 * 显示的设置新生代的大小，Oracle 建议您将年轻代的大小保持在整个堆大小的一半到四分之一之间（如果同时设置了NewRadio，则以Xmn为准）
 *
 * -Xmnsize
 * Sets the initial and maximum size (in bytes) of the heap for the young generation (nursery).
 * Append the letter k or K to indicate kilobytes, m or M to indicate megabytes, g or G to indicate gigabytes.
 *
 * The young generation region of the heap is used for new objects. GC is performed in this region more often than in other regions.
 * If the size for the young generation is too small, then a lot of minor garbage collections will be performed.
 *
 * If the size is too large, then only full garbage collections will be performed, which can take a long time to complete.
 * Oracle recommends that you keep the size for the young generation between a half and a quarter of the overall heap size.
 *
 * The following examples show how to set the initial and maximum size of young generation to 256 MB using various units:
 *
 * -Xmn256m
 * -Xmn262144k
 * -Xmn268435456
 * Instead of the -Xmn option to set both the initial and maximum size of the heap for the young generation,
 * you can use -XX:NewSize to set the initial size and -XX:MaxNewSize to set the maximum size.

 * --------------------------------------------------------------------
 *
 * -XX:NewSize=size
 * Sets the initial size (in bytes) of the heap for the young generation (nursery). Append the letter k or K to indicate kilobytes, m or M to indicate megabytes, g or G to indicate gigabytes.
 *
 * The young generation region of the heap is used for new objects. GC is performed in this region more often than in other regions. If the size for the young generation is too low, then a large number of minor GCs will be performed. If the size is too high, then only full GCs will be performed, which can take a long time to complete. Oracle recommends that you keep the size for the young generation between a half and a quarter of the overall heap size.
 *
 * The following examples show how to set the initial size of young generation to 256 MB using various units:
 *
 * -XX:NewSize=256m
 * -XX:NewSize=262144k
 * -XX:NewSize=268435456
 * The -XX:NewSize option is equivalent to -Xmn.
 *
 * --------------------------------------------------------------------
 *
 * -XX:MaxNewSize=size
 * Sets the maximum size (in bytes) of the heap for the young generation (nursery). The default value is set ergonomically.
 *
 * --------------------------------------------------------------------
 */
public class NewAndOld {
}
