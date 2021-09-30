package online.javabook.jvm.tuning.thread;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置线程本地分配缓冲区 (TLAB) 的初始大小（以字节为单位）.如果此选项设置为 0，则 JVM 会自动选择初始大小。
 *
 * -XX:TLABSize=size
 * Sets the initial size (in bytes) of a thread-local allocation buffer (TLAB).
 * Append the letter k or K to indicate kilobytes, m or M to indicate megabytes, g or G to indicate gigabytes.
 * If this option is set to 0, then the JVM chooses the initial size automatically.
 *
 * The following example shows how to set the initial TLAB size to 512 KB:
 *
 * -XX:TLABSize=512k
 */
public class Tlab {
}
