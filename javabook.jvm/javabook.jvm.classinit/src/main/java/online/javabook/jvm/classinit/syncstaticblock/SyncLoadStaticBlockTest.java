package online.javabook.jvm.classinit.syncstaticblock;

public class SyncLoadStaticBlockTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread("线程1") {
            @Override
            public void run() {
                new ClassWithStaticBlock();
            }
        };

        Thread thread2 = new Thread("线程1") {
            @Override
            public void run() {
                new ClassWithStaticBlock();
            }
        };

        thread1.start();
        thread2.start();
    }
}
