package online.javabook.jvm.tools.cmd;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 查看命令行的参数以及GC类型
 *
 * java -XX:+PrintCommandLineFlags
 * Enables printing of ergonomically selected JVM flags that appeared on the command line.
 * It can be useful to know the ergonomic values set by the JVM, such as the heap space size and the selected garbage collector.
 * By default, this option is disabled and flags are not printed.
 * --------------------------------------------------------------------
 * 查看所有参数的默认值
 *
 * java -XX:+PrintFlagsInitial
 * --------------------------------------------------------------------
 * 查看所有参数的最终值
 * java -XX:+PrintFlagsFinal
 *
 * 配合命令行工具
 * jinfo -flag 参数名 进程id
 */
public class JavaFlag {

}
