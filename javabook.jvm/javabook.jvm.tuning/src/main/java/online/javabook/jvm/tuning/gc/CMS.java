package online.javabook.jvm.tuning.gc;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 *
 * -XX:+CMSClassUnloadingEnabled
 * Enables class unloading when using the concurrent mark-sweep (CMS) garbage collector. This option is enabled by default.
 * To disable class unloading for the CMS garbage collector, specify -XX:-CMSClassUnloadingEnabled.
 *
 * --------------------------------------------------------------------
 *
 * -XX:CMSExpAvgFactor=percent
 * Sets the percentage of time (0 to 100) used to weight the current sample when computing exponential averages for the concurrent collection statistics.
 * By default, the exponential averages factor is set to 25%. The following example shows how to set the factor to 15%:
 *
 * -XX:CMSExpAvgFactor=15
 *
 * --------------------------------------------------------------------
 *
 * 老年代的占用率超过初始占用率（老年代的百分比），并发收集也会开始
 *
 * -XX:CMSInitiatingOccupancyFraction=percent
 * 设置开始 CMS 收集周期的老年代占用率（0 到 100）的百分比。
 * 默认值设置为 -1。任何负值（包括默认值）都意味着 -XX:CMSTriggerRatio 用于定义起始占用率的值。
 *
 * The following example shows how to set the occupancy fraction to 20%:
 *
 * -XX:CMSInitiatingOccupancyFraction=20
 *
 * --------------------------------------------------------------------
 *
 * -XX:+CMSScavengeBeforeRemark
 * Enables scavenging attempts before the CMS remark step. By default, this option is disabled.
 *
 * --------------------------------------------------------------------
 *
 * -XX:CMSTriggerRatio=percent
 * Sets the percentage (0 to 100) of the value specified by -XX:MinHeapFreeRatio that is allocated before a CMS collection cycle commences.
 * The default value is set to 80%.
 *
 * The following example shows how to set the occupancy fraction to 75%:
 *
 * -XX:CMSTriggerRatio=75
 */
public class CMS {
}
