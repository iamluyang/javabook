package online.javabook.jvm.gc.type;

/**
 * 年轻代GC(Minor GC)触发机制:
 * 当年轻代空间不足时，就会触发Minor Gc，这里的年轻代满指的是Eden代满，Survivor满不会引发Gc。(每次 Minor GC会清理年轻代的内存。)
 * 因为Java对象大多都具备朝生夕灭的特性，所以Minor GC非常频繁，一般回收速度也比较快。这一定义既清晰又易于理解。
 * Minor GC会引发STW，暂停其它用户的线程，等垃圾回收结束，用户线程才恢复运行。
 */
public class MinorGC {
}
