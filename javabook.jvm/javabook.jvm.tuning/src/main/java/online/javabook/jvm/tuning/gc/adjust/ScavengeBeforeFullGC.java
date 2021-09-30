package online.javabook.jvm.tuning.gc.adjust;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 在每次Full GC 之前启用年轻代的 GC。默认情况下启用此选项。
 * Oracle 建议您不要禁用它，因为在 Full GC 之前清理年轻代可以减少从老年代空间进入年轻代空间的对象数量。
 * 要在每次Full GC之前禁用年轻代的 GC，请指定 -XX:-ScavengeBeforeFullGC。
 *
 * -XX:+ScavengeBeforeFullGC
 * Enables GC of the young generation before each full GC. This option is enabled by default.
 * Oracle recommends that you do not disable it, because scavenging the young generation before a full GC
 * can reduce the number of objects reachable from the old generation space into the young generation space.
 * To disable GC of the young generation before each full GC, specify -XX:-ScavengeBeforeFullGC.
 */
public class ScavengeBeforeFullGC {
}
