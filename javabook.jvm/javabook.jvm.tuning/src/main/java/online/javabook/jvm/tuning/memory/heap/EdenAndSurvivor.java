package online.javabook.jvm.tuning.memory.heap;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置eden区空间大小和幸存区空间大小之间的比率
 *
 * -XX:SurvivorRatio=ratio
 * Sets the ratio between eden space size and survivor space size.
 * By default, this option is set to 8. The following example shows how to set the eden/survivor space ratio to 4:
 * -XX:SurvivorRatio=4
 *
 * 默认比例示意图
 *                                                 8                                                    1          1
 * |-----------|-----------|-----------|-----------|-----------|-----------|-----------|-----------|----------|----------|
 * |<--------------------------------------------eden--------------------------------------------->|<---s0--->|<---s1--->|
 *
 * --------------------------------------------------------------------
 * 设置幸存区的使用率阈值
 * -XX:TargetSurvivorRatio=percent
 * Sets the desired percentage of survivor space (0 to 100) used after young garbage collection. By default, this option is set to 50%.
 *
 * The following example shows how to set the target survivor space ratio to 30%:
 * -XX:TargetSurvivorRatio=3
 *
 * --------------------------------------------------------------------
 * 设置吞吐量垃圾收集器(ParallelGC)使用的初始幸存者空间比率
 *
 * -XX:InitialSurvivorRatio=ratio
 * Sets the initial survivor space ratio used by the throughput garbage collector
 * (which is enabled by the -XX:+UseParallelGC and/or -XX:+UseParallelOldGC options).
 * Adaptive sizing is enabled by default with the throughput garbage collector by using the -XX:+UseParallelGC and -XX:+UseParallelOldGC options,
 * and survivor space is resized according to the application behavior, starting with the initial value.
 * If adaptive sizing is disabled (using the -XX:-UseAdaptiveSizePolicy option),
 * then the -XX:SurvivorRatio option should be used to set the size of the survivor space for the entire execution of the application.
 *
 * The following formula can be used to calculate the initial size of survivor space (S) based on the size of the young generation (Y),
 * and the initial survivor space ratio (R):
 * S=Y/(R+2)
 *
 * The 2 in the equation denotes two survivor spaces. The larger the value specified as the initial survivor space ratio,
 * the smaller the initial survivor space size.
 * By default, the initial survivor space ratio is set to 8. If the default value for the young generation space size is used (2 MB),
 * the initial size of the survivor space will be 0.2 MB.
 *
 * The following example shows how to set the initial survivor space ratio to 4:
 * -XX:InitialSurvivorRatio=4
 */
public class EdenAndSurvivor {
}
