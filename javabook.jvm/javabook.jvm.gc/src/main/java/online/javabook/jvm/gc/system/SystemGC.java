package online.javabook.jvm.gc.system;

/**
 * 调用gc方法表明 Java 虚拟机花费精力来回收未使用的对象，以使它们当前占用的内存可用于快速重用。
 * 当控制从方法调用返回时，Java 虚拟机已尽最大努力从所有丢弃的对象中回收空间
 * 调用System.gc()实际上等效于调用：Runtime.getRuntime().gc()
 */
public class SystemGC {
    public static void main(String[] args) throws InterruptedException {

        TestObj testObj = new TestObj();

        // 这种调用方式只是暗示JVM触发Full GC，但是不是立即或一定生效
        System.gc();
        //Thread.sleep(1000);
        //System.runFinalization();

        while (true) {
            // CPU繁忙，以至于GC无法触发
        }

        //Thread.sleep(Long.MAX_VALUE);
    }
}
