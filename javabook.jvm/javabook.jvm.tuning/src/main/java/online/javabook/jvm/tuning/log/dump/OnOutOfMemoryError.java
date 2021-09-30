package online.javabook.jvm.tuning.log.dump;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 内存溢出后执行一个脚本文件
 * 设置自定义命令或一系列以分号分隔的命令，以便在首次抛出 OutOfMemoryError 异常时运行。
 * 如果字符串包含空格，则必须用引号将其括起来。有关命令字符串的示例，请参阅 -XX:OnError 选项的说明。
 *
 * -XX:OnOutOfMemoryError=string
 * Sets a custom command or a series of semicolon-separated commands to run when an OutOfMemoryError exception is first thrown.
 * If the string contains spaces, then it must be enclosed in quotation marks.
 * For an example of a command string, see the description of the -XX:OnError option.
 */
public class OnOutOfMemoryError {
}
