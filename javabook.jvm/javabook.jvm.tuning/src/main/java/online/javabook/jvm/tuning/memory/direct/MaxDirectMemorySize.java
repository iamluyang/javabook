package online.javabook.jvm.tuning.memory.direct;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置直接内存大小(设置nio直接缓冲区分配的最大总大小,以字节为单位)
 * 默认情况下大小设置为 0，这意味着JVM会自动选择NIO直接缓冲区分配的大小
 *
 * -XX:MaxDirectMemorySize=size
 * Sets the maximum total size (in bytes) of the New I/O (the java.nio package) direct-buffer allocations.
 * Append the letter k or K to indicate kilobytes, m or M to indicate megabytes, g or G to indicate gigabytes.
 * By default, the size is set to 0, meaning that the JVM chooses the size for NIO direct-buffer allocations automatically.
 *
 * The following examples illustrate how to set the NIO size to 1024 KB in different units:
 *
 * -XX:MaxDirectMemorySize=1m
 * -XX:MaxDirectMemorySize=1024k
 * -XX:MaxDirectMemorySize=1048576
 */
public class MaxDirectMemorySize {
}
