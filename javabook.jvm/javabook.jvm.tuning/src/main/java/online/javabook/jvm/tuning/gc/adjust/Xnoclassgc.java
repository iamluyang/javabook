package online.javabook.jvm.tuning.gc.adjust;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 禁用类的垃圾回收 (GC)。这可以节省一些 GC 时间，从而缩短应用程序运行期间的中断。
 * 当您在启动时指定 -Xnoclassgc 时，应用程序中的类对象在 GC 期间将保持不变，并且始终被认为是活动的。
 * 这可能导致更多内存被永久占用，如果不小心使用，将引发内存不足异常。
 *
 * -Xnoclassgc
 * Disables garbage collection (GC) of classes. This can save some GC time, which shortens interruptions during the application run.
 *
 * When you specify -Xnoclassgc at startup, the class objects in the application will be left untouched during GC and will always be considered live.
 * This can result in more memory being permanently occupied which, if not used carefully, will throw an out of memory exception.
 */
public class Xnoclassgc {
}
