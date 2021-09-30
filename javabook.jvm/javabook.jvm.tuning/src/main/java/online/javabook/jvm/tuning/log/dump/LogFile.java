package online.javabook.jvm.tuning.log.dump;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置写入日志数据的路径和文件名。默认情况下，该文件创建在当前工作目录中，并命名为 hotspot.log
 *
 * -XX:LogFile=path
 * Sets the path and file name where log data is written. By default,
 * the file is created in the current working directory, and it is named hotspot.log.
 *
 * The following example shows how to set the log file to /var/log/java/hotspot.log:
 *
 * -XX:LogFile=/var/log/java/hotspot.log
 *
 * --------------------------------------------------------------------
 */
public class LogFile {
}
