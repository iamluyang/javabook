package online.javabook.jvm.tuning.memory.heap;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置最小堆
 *
 * -Xmssize
 * Sets the minimum and the initial size (in bytes) of the heap. This value must be a multiple of 1024 and greater than 1 MB.
 * Append the letter k or K to indicate kilobytes, m or M to indicate megabytes, g or G to indicate gigabytes.
 *
 * The following examples show how to set the size of allocated memory to 6 MB using various units:
 *
 * -Xms6291456
 * -Xms6144k
 * -Xms6m
 * If you do not set this option, then the initial size will be set as the sum of the sizes allocated for the old generation and the young generation.
 * The initial size of the heap for the young generation can be set using the -Xmn option or the -XX:NewSize option.
 *
 * Note that the -XX:InitalHeapSize option can also be used to set the initial heap size. If it appears after -Xms on the command line,
 * then the initial heap size gets set to the value specified with -XX:InitalHeapSize.
 * --------------------------------------------------------------------
 * 设置最大堆
 *
 * -Xmxsize
 * Specifies the maximum size (in bytes) of the memory allocation pool in bytes. This value must be a multiple of 1024 and greater than 2 MB.
 * Append the letter k or K to indicate kilobytes, m or M to indicate megabytes, g or G to indicate gigabytes.
 * The default value is chosen at runtime based on system configuration. For server deployments, -Xms and -Xmx are often set to the same value.
 * See the section "Ergonomics" in Java SE HotSpot Virtual Machine Garbage Collection
 * Tuning Guide at http://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/index.html.
 *
 * The following examples show how to set the maximum allowed size of allocated memory to 80 MB using various units:
 *
 * -Xmx83886080
 * -Xmx81920k
 * -Xmx80m
 * The -Xmx option is equivalent to -XX:MaxHeapSize.
 *
 */
public class Heap {
}
