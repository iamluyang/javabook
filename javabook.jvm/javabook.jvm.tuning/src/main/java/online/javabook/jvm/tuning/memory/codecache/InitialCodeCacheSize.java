package online.javabook.jvm.tuning.memory.codecache;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置初始代码缓存大小（以字节为单位）。
 *
 * -XX:InitialCodeCacheSize=size
 * Sets the initial code cache size (in bytes). Append the letter k or K to indicate kilobytes, m or M to indicate megabytes, g or G to indicate gigabytes.
 * The default value is set to 500 KB. The initial code cache size should be not less than the system's minimal memory page size.
 * The following example shows how to set the initial code cache size to 32 KB:
 *
 * -XX:InitialCodeCacheSize=32k
 */
public class InitialCodeCacheSize {
}
