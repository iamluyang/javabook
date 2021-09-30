package online.javabook.jvm.tuning.log.dump;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置应将详细 GC 事件信息重定向到哪个文件以进行日志记录。
 *
 * -Xloggc:filename
 * Sets the file to which verbose GC events information should be redirected for logging.
 * The information written to this file is similar to the output of -verbose:gc with the time elapsed since the first GC event preceding each logged event.
 * The -Xloggc option overrides -verbose:gc if both are given with the same java command.
 *
 * Example:
 *
 * -Xloggc:garbage-collection.log
 */
public class Xloggc {
}
