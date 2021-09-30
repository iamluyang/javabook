package online.javabook.jvm.gc.perforamce.staticfield;

/**
 * 测试静态字段的对象"引用"被分配到了那里(这里不是指对象，对象始终存放中堆空间中)，
 * 引用是在JDK6的方法区内存中，在JDK7~8的堆内存中
 *
 * jdk6~7:
 * -Xms256m -Xmx256m -XX:MaxPermSize=128m -XX:+PrintGCDetails
 *
 * jdk8:
 * -Xms256m -Xmx256mm -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=128m -XX:+PrintGCDetails
 *
 * 测试工具：JDK9 jhsdb
 */
public class StaticFieldAlloc {

    public static ObjectHolder staticObject = new ObjectHolder();
    public ObjectHolder instanceObject = new ObjectHolder();

    public static void main(String[] args) throws InterruptedException {
        StaticFieldAlloc staticFieldAlloc = new StaticFieldAlloc();

        System.out.println(staticObject);
        System.out.println(staticFieldAlloc.instanceObject);
        staticFieldAlloc.localObject();
        Thread.sleep(Long.MAX_VALUE);
    }

    private void localObject() {
        ObjectHolder localObject = new ObjectHolder();
        System.out.println(localObject);
    }
}
