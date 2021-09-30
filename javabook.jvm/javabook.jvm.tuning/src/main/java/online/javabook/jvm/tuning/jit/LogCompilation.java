package online.javabook.jvm.tuning.jit;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 启用将编译活动记录到当前工作目录中名为 hotspot.log 的文件中。您可以使用 -XX:LogFile 选项指定不同的日志文件路径和名称。
 * 默认情况下，此选项处于禁用状态，并且不记录编译活动。
 *
 * -XX:+LogCompilation
 * Enables logging of compilation activity to a file named hotspot.log in the current working directory.
 * You can specify a different log file path and name using the -XX:LogFile option.
 *
 * By default, this option is disabled and compilation activity is not logged.
 * The -XX:+LogCompilation option has to be used together with the -XX:+UnlockDiagnosticVMOptions option that unlocks diagnostic JVM options.
 *
 * You can enable verbose diagnostic output with a message printed to the console every time a method is compiled by using the -XX:+PrintCompilation option.
 */
public class LogCompilation {
}
