package online.javabook.jvm.tuning.memory.heap.adjust;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * SurvivorRatio的比例可能会受到UseAdaptiveSizePolicy的影响，可以关闭UseAdaptiveSizePolicy策略
 * 启用自适应生成大小调整。默认情况下启用此选项。要禁用自适应生成大小，请指定 -XX:-UseAdaptiveSizePolicy 并显式设置内存分配池的大小
 *
 * -XX:+UseAdaptiveSizePolicy
 * Enables the use of adaptive generation sizing. This option is enabled by default. To disable adaptive generation sizing,
 * specify -XX:-UseAdaptiveSizePolicy and set the size of the memory allocation pool explicitly (see the -XX:SurvivorRatio option).
 *
 */
public class UseAdaptiveSizePolicy {
}
