package online.javabook.jvm.tuning.escape;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 启用逃逸分析。默认情况下启用此选项。要禁用转义分析，请指定 -XX:-DoEscapeAnalysis。只有 Java HotSpot Server VM 支持此选项。
 *
 * -XX:+DoEscapeAnalysis
 * Enables the use of escape analysis. This option is enabled by default.
 * To disable the use of escape analysis, specify -XX:-DoEscapeAnalysis. Only the Java HotSpot Server VM supports this option.
 */
public class DoEscapeAnalysis {
}
