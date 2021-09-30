package online.javabook.jvm.tuning.memory.heap.adjust;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 性能调优示例
 * 以下示例展示了如何使用实验性调整标志来优化吞吐量或提供更短的响应时间。
 *
 * Example 1 - Tuning for Higher Throughput
 * java -d64 -server -XX:+AggressiveOpts -XX:+UseLargePages -Xmn10g -Xms26g -Xmx26g
 *
 * Example 2 - Tuning for Lower Response Time
 * java -d64 -XX:+UseG1GC -Xms26g Xmx26g -XX:MaxGCPauseMillis=500 -XX:+PrintGCTimeStamp
 */
public class PerformanceTuningExamples {
}
