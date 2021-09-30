package online.javabook.jvm.classinit.syncstaticblock;

public class ClassWithStaticBlock {
    static {
        System.out.println("被线程:" + Thread.currentThread() + "加载中");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("被线程:" + Thread.currentThread() + "加载结束");
    }
}
