package online.javabook.jvm.tuning.log.dump;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 当抛出 java.lang.OutOfMemoryError 异常时，可以使用堆分析器 (HPROF) 将 Java 堆转储到当前目录中的文件。
 * 您可以使用 -XX:HeapDumpPath 选项显式设置堆转储文件路径和名称。默认情况下，当抛出 OutOfMemoryError 异常时，此选项被禁用并且不会转储堆。
 *
 * -XX:+HeapDumpOnOutOfMemoryError
 * Enables the dumping of the Java heap to a file in the current directory by using the heap profiler (HPROF)
 * when a java.lang.OutOfMemoryError exception is thrown.
 * You can explicitly set the heap dump file path and name using the -XX:HeapDumpPath option.
 * By default, this option is disabled and the heap is not dumped when an OutOfMemoryError exception is thrown.
 *
 * --------------------------------------------------------------------
 *
 * 当设置了 -XX:+HeapDumpOnOutOfMemoryError 选项时，设置用于写入堆分析器 (HPROF) 提供的堆转储的路径和文件名。
 * 默认情况下，该文件在当前工作目录中创建，并命名为 java_pidpid.hprof，其中 pid 是导致错误的进程的标识符。以下示例显示了如何显式设置默认文件（%p 表示当前进程标识符）
 *
 * -XX:HeapDumpPath=path
 * Sets the path and file name for writing the heap dump provided by the heap profiler (HPROF) when the -XX:+HeapDumpOnOutOfMemoryError option is set.
 * By default, the file is created in the current working directory, and it is named java_pidpid.hprof where pid is the identifier of the process that
 * caused the error. The following example shows how to set the default file explicitly (%p represents the current process identificator):
 *
 * -XX:HeapDumpPath=./java_pid%p.hprof
 * The following example shows how to set the heap dump file to /var/log/java/java_heapdump.hprof:
 *
 * -XX:HeapDumpPath=/var/log/java/java_heapdump.hprof
 */
public class HeapDumpOnOutOfMemoryError {
}
