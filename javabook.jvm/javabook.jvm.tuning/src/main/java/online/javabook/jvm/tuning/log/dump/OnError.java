package online.javabook.jvm.tuning.log.dump;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置一个自定义命令或一系列以分号分隔的命令，以便在发生不可恢复的错误时运行。如果字符串包含空格，则必须用引号将其括起来。
 * 以下示例显示了如何使用 -XX:OnError 选项运行 gcore 命令来创建核心映像，并在出现不可恢复的错误时启动调试器附加到进程（%p 指定当前进程）
 *
 * -XX:OnError=string
 * Sets a custom command or a series of semicolon-separated commands to run when an irrecoverable error occurs.
 * If the string contains spaces, then it must be enclosed in quotation marks.
 *
 * The following example shows how the -XX:OnError option can be used to run the gcore command to create the core image,
 * and the debugger is started to attach to the process in case of an irrecoverable error (the %p designates the current process):
 *
 * -XX:OnError="gcore %p;dbx - %p"
 */
public class OnError {
}
