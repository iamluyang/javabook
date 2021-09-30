package online.javabook.jvm.tuning.memory.codecache;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置 JIT 编译代码的最大代码缓存大小（以字节为单位）
 *
 * -XX:ReservedCodeCacheSize=size
 * Sets the maximum code cache size (in bytes) for JIT-compiled code. Append the letter k or K to indicate kilobytes,
 * m or M to indicate megabytes, g or G to indicate gigabytes. The default maximum code cache size is 240 MB;
 * if you disable tiered compilation with the option -XX:-TieredCompilation, then the default size is 48 MB.
 * This option has a limit of 2 GB; otherwise, an error is generated.
 * The maximum code cache size should not be less than the initial code cache size; see the option -XX:InitialCodeCacheSize.
 * This option is equivalent to -Xmaxjitcodesize.
 */
public class ReservedCodeCacheSize {
}
