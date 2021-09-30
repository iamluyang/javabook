package online.javabook.jvm.tuning.jit;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 通过在每次编译方法时将消息打印到控制台来启用来自 JVM 的详细诊断输出。
 *
 * -XX:+PrintCompilation
 * Enables verbose diagnostic output from the JVM by printing a message to the console every time a method is compiled.
 * This enables you to see which methods actually get compiled. By default, this option is disabled and diagnostic output is not printed.
 *
 * You can also log compilation activity to a file by using the -XX:+LogCompilation option.
 */
public class PrintCompilation {
}
