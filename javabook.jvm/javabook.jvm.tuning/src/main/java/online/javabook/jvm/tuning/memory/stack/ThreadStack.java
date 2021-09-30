package online.javabook.jvm.tuning.memory.stack;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置线程栈大小，默认值依赖OS
 *
 * -Xsssize
 * Sets the thread stack size (in bytes). Append the letter k or K to indicate KB, m or M to indicate MB, g or G to indicate GB.
 * The default value depends on the platform:
 * Linux/ARM (32-bit): 320 KB
 * Linux/i386 (32-bit): 320 KB
 * Linux/x64 (64-bit): 1024 KB
 * OS X (64-bit): 1024 KB
 * Oracle Solaris/i386 (32-bit): 320 KB
 * Oracle Solaris/x64 (64-bit): 1024 KB
 * The following examples set the thread stack size to 1024 KB in different units:
 *
 * -Xss1m
 * -Xss1024k
 * -Xss1048576
 * This option is equivalent to -XX:ThreadStackSize.
 */
public class ThreadStack {
}
