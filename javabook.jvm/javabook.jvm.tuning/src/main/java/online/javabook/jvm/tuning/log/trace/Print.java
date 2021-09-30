package online.javabook.jvm.tuning.log.trace;

import java.util.LinkedList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 输出详细的GC处理日志
 *
 * -XX:+PrintGCDetails
 * Enables printing of detailed messages at every GC. By default, this option is disabled.
 * --------------------------------------------------------------------
 * 输出带时间戳的GC日志
 *
 * -XX:+PrintGCTimeStamps
 * Enables printing of time stamps at every GC. By default, this option is disabled.
 * --------------------------------------------------------------------
 * 输出带日期的GC日志
 *
 * -XX:+PrintGCDateStamps
 * Enables printing of a date stamp at every GC. By default, this option is disabled.
 * --------------------------------------------------------------------
 * 打印GC简要信息
 *
 * -XX:+PrintGC
 * Enables printing of messages at every GC. By default, this option is disabled.
 * --------------------------------------------------------------------
 * 打印GC事件
 *
 * -verbose:gc
 * Displays information about each garbage collection (GC) event.
 * --------------------------------------------------------------------
 * 打印线程状态和并发锁状态
 * 设置此选项相当于运行 jstack -l 命令或 jcmd pid Thread.print -l 命令，其中 pid 是当前 Java 进程标识符。
 *
 * -XX:+PrintConcurrentLocks
 * Enables printing of java.util.concurrent locks after a Control+C event (SIGTERM). By default, this option is disabled.
 *
 * Setting this option is equivalent to running the jstack -l command or the jcmd pid Thread.print -l command,
 * where pid is the current Java process identifier.
 * --------------------------------------------------------------------
 * 启用打印自上次暂停（例如，GC 暂停）以来经过的时间。默认情况下，此选项处于禁用状态。
 *
 * -XX:+PrintGCApplicationConcurrentTime
 * Enables printing of how much time elapsed since the last pause (for example, a GC pause). By default, this option is disabled.
 * --------------------------------------------------------------------
 * 启用打印暂停（例如，GC 暂停）持续的时间。默认情况下，此选项处于禁用状态。
 *
 * -XX:+PrintGCApplicationStoppedTime
 * Enables printing of how much time the pause (for example, a GC pause) lasted. By default, this option is disabled.
 * --------------------------------------------------------------------
 * 启用有关自适应生成大小的信息的打印。默认情况下，此选项处于禁用状态。
 *
 * -XX:+PrintAdaptiveSizePolicy
 * Enables printing of information about adaptive generation sizing. By default, this option is disabled.
 * --------------------------------------------------------------------
 * 打印详细的重复数据删除统计信息。
 *
 * -XX:+PrintStringDeduplicationStatistics
 * Prints detailed deduplication statistics. By default, this option is disabled. See the -XX:+UseStringDeduplication option.
 * --------------------------------------------------------------------
 * 为每个单独的 GC 工作线程任务启用时间戳打印
 *
 * -XX:+PrintGCTaskTimeStamps
 * Enables printing of time stamps for every individual GC worker thread task. By default, this option is disabled.
 * --------------------------------------------------------------------
 * 允许打印任期年龄信息
 *
 * -XX:+PrintTenuringDistribution
 * Enables printing of tenuring age information. The following is an example of the output:
 *
 * Desired survivor size 48286924 bytes, new threshold 10 (max 10)
 * - age 1: 28992024 bytes, 28992024 total
 * - age 2: 1366864 bytes, 30358888 total
 * - age 3: 1425912 bytes, 31784800 total
 * ...
 * Age 1 objects are the youngest survivors (they were created after the previous scavenge,
 * survived the latest scavenge, and moved from eden to survivor space).
 * Age 2 objects have survived two scavenges (during the second scavenge they were copied from one survivor space to the next). And so on.
 *
 * In the preceding example, 28 992 024 bytes survived one scavenge and were copied from eden to survivor space,
 * 1 366 864 bytes are occupied by age 2 objects, etc. The third value in each row is the cumulative size of objects of age n or less.
 *
 * By default, this option is disabled.
 *
 * --------------------------------------------------------------------
 * 启用类实例直方图的打印
 * 设置此选项相当于运行 jmap -histo 命令或 jcmd pid GC.class_histogram 命令，其中 pid 是当前 Java 进程标识符
 *
 * -XX:+PrintClassHistogram
 *
 * Enables printing of a class instance histogram after a Control+C event (SIGTERM).
 * By default, this option is disabled.
 *
 * Setting this option is equivalent to running the jmap -histo command,
 * or the jcmd pid GC.class_histogram command, where pid is the current Java process identifier.
 *
 * --------------------------------------------------------------------
 *
 * 打印字符串表中的统计信息
 * -XX:+PrintStringTableStatistics
 *
 * --------------------------------------------------------------------
 */
public class Print {
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        List<byte[]> headMemorys = new LinkedList<byte[]>();
        for(;;){
            byte[] _1MB = new byte[1024];
            headMemorys.add(_1MB);
            //System.out.println("消耗堆内存:" + headMemorys.size() + "MB");
            //Thread.sleep(1);
        }
    }
}
