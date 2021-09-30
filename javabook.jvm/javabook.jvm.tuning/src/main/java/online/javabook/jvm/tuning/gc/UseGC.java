package online.javabook.jvm.tuning.gc;

/**
 * 常用VM参数：
 *----------------------------------------------------------------------------------------------------
 * 1.启用串行垃圾收集器的使用。对于不需要垃圾收集任何特殊功能的小型简单应用程序，这通常是最佳选择。
 *
 * Serial + Serial Old
 * -XX:+UseSerialGC -XX:+PrintFlagsFinal
 *
 * Enables the use of the serial garbage collector. This is generally the best choice for small and simple applications that do not require
 * any special functionality from garbage collection.
 * By default, this option is disabled and the collector is chosen automatically based on the configuration of the machine and type of the JVM.
 *
 *----------------------------------------------------------------------------------------------------
 * 2.启用在年轻代中使用并行线程进行收集
 *
 * ParNew + Serial Old
 * -XX:+UseParNewGC -XX:+PrintFlagsFinal
 * Java HotSpot(TM) 64-Bit Server VM warning: Using the ParNew young collector with the Serial old collector
 * is deprecated and will likely be removed in a future release
 *
 * Enables the use of parallel threads for collection in the young generation. By default, this option is disabled.
 * It is automatically enabled when you set the -XX:+UseConcMarkSweepGC option.
 * Using the -XX:+UseParNewGC option without the -XX:+UseConcMarkSweepGC option was deprecated in JDK 8.
 *
 *----------------------------------------------------------------------------------------------------
 * 3.允许使用并行清理垃圾收集器（也称为吞吐量收集器）通过利用多个处理器来提高应用程序的性能。
 *
 * Parallel Scavenge + Serial Old
 * -XX:+UseParallelGC -XX:-UseParallelOldGC -XX:+PrintFlagsFinal
 *
 * Enables the use of the parallel scavenge garbage collector (also known as the throughput collector) to improve
 * the performance of your application by leveraging multiple processors.
 * By default, this option is disabled and the collector is chosen automatically based on the configuration of the machine and type of the JVM.
 * If it is enabled, then the -XX:+UseParallelOldGC option is automatically enabled, unless you explicitly disable it.
 *
 *----------------------------------------------------------------------------------------------------
 *
 * -XX:+UseNUMA
 * 通过增加应用程序对低延迟内存的使用，在具有非统一内存架构 (NUMA) 的机器上实现应用程序的性能优化。
 * Enables performance optimization of an application on a machine with nonuniform memory architecture (NUMA) by increasing
 * the application's use of lower latency memory. By default, this option is disabled and no optimization for NUMA is made.
 * The option is only available when the parallel garbage collector is used (-XX:+UseParallelGC).
 *
 *----------------------------------------------------------------------------------------------------
 * 4.启用对Full GC 的并行垃圾收集器的使用。
 *
 * Parallel Scavenge + Serial Old
 * -XX:+UseParallelOldGC -XX:+PrintFlagsFinal
 *
 * Enables the use of the parallel garbage collector for full GCs. By default, this option is disabled.
 * Enabling it automatically enables the -XX:+UseParallelGC option.
 *
 *----------------------------------------------------------------------------------------------------
 * 5.允许使用并行清理垃圾收集器（也称为吞吐量收集器）通过利用多个处理器来提高应用程序的性能。
 *
 * Parallel Scavenge + Parallel Old
 * -XX:+UseParallelGC -XX:+PrintFlagsFinal
 *
 * Enables the use of the parallel scavenge garbage collector (also known as the throughput collector) to improve
 * the performance of your application by leveraging multiple processors.
 *
 * By default, this option is disabled and the collector is chosen automatically based on the configuration of the machine and type of the JVM.
 * If it is enabled, then the -XX:+UseParallelOldGC option is automatically enabled, unless you explicitly disable it.
 *----------------------------------------------------------------------------------------------------
 * 6.
 *
 * DefNew + CMS
 * -XX:+UseConcMarkSweepGC -XX:-UseParNewGC -XX:+PrintFlagsFinal

 * Java HotSpot(TM) 64-Bit Server VM warning: Using the DefNew young collector with the CMS collector
 * is deprecated and will likely be removed in a future release
 *
 *----------------------------------------------------------------------------------------------------
 * 7.为老年代启用 CMS 垃圾收集器。 Oracle 建议您在吞吐量 (-XX:+UseParallelGC) 垃圾收集器无法满足应用程序延迟要求时使用 CMS 垃圾收集器。
 * G1 垃圾收集器 (-XX:+UseG1GC) 是另一种选择。
 *
 * ParNew + CMS + Serial Old
 * -XX:+UseConcMarkSweepGC -XX:+PrintFlagsFinal
 *
 * Enables the use of the CMS garbage collector for the old generation.
 * Oracle recommends that you use the CMS garbage collector when application latency requirements cannot be met by the throughput (-XX:+UseParallelGC)
 * garbage collector. The G1 garbage collector (-XX:+UseG1GC) is another alternative.
 *
 * By default, this option is disabled and the collector is chosen automatically based on the configuration of the machine and type of the JVM.
 * When this option is enabled, the -XX:+UseParNewGC option is automatically set and you should not disable it,
 * because the following combination of options has been deprecated in JDK 8: -XX:+UseConcMarkSweepGC -XX:-UseParNewGC.
 *
 *----------------------------------------------------------------------------------------------------
 * 是否启用显示的使用 System.gc() 请求启用并发GC调用。此选项默认禁用，只能与 -XX:+UseConcMarkSweepGC 选项一起启用。
 * -XX:+ExplicitGCInvokesConcurrent
 *
 * Enables invoking of concurrent GC by using the System.gc() request.
 * This option is disabled by default and can be enabled only together with the -XX:+UseConcMarkSweepGC option.
 *
 *----------------------------------------------------------------------------------------------------
 * 是否启用显示的使用 System.gc() 请求启用并发GC调用, 请求和卸载类来启用并发 GC 的调用。此选项默认禁用，只能与 -XX:+UseConcMarkSweepGC 选项一起启用。
 * -XX:+ExplicitGCInvokesConcurrentAndUnloadsClasses
 *
 * Enables invoking of concurrent GC by using the System.gc() request and unloading of classes during the concurrent GC cycle.
 * This option is disabled by default and can be enabled only together with the -XX:+UseConcMarkSweepGC option.
 *
 *----------------------------------------------------------------------------------------------------
 * 8.启用垃圾优先 (G1) 垃圾收集器。它是一个服务器式垃圾收集器，针对具有大量 RAM 的多处理器机器。它以高概率满足 GC 暂停时间目标，同时保持良好的吞吐量。
 * 建议将 G1 收集器用于需要大堆（大小约为 6 GB 或更大）且 GC 延迟要求有限（稳定且可预测的暂停时间低于 0.5 秒）的应用程序。
 *
 * -XX:+UseG1GC
 *
 * Enables the use of the garbage-first (G1) garbage collector. It is a server-style garbage collector,
 * targeted for multiprocessor machines with a large amount of RAM. It meets GC pause time goals with high probability,
 * while maintaining good throughput. The G1 collector is recommended for applications requiring large heaps (sizes of around 6 GB or larger)
 * with limited GC latency requirements (stable and predictable pause time below 0.5 seconds).
 *
 * By default, this option is disabled and the collector is chosen automatically based on the configuration of the machine and type of the JVM.
 *----------------------------------------------------------------------------------------------------
 */
public class UseGC {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }
}
