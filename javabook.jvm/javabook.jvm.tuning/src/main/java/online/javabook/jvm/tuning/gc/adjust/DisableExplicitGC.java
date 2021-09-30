package online.javabook.jvm.tuning.gc.adjust;


/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 启用禁用处理对 System.gc() 调用的选项。
 * 默认情况下禁用此选项，这意味着处理对 System.gc() 的调用。如果对 System.gc() 调用的处理被禁用，JVM 仍会在必要时执行 GC。
 *
 * -XX:+DisableExplicitGC
 * Enables the option that disables processing of calls to System.gc().
 * This option is disabled by default, meaning that calls to System.gc() are processed.
 * If processing of calls to System.gc() is disabled, the JVM still performs GC when necessary.
 */
public class DisableExplicitGC {
}
