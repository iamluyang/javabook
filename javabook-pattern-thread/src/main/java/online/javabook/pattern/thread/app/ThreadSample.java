package online.javabook.pattern.thread.app;

public class ThreadSample {

    private Object lock = new Object();

    public void notSyncMethod() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void notSyncStaticMethod() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public synchronized void syncMethod1() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public synchronized void syncMethod2() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public void syncMethod3() throws InterruptedException {
        synchronized (this) {
            while(true){
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public void syncMethod4() throws InterruptedException {
        synchronized (lock) {
            while(true){
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public synchronized static void syncStaticMethod1() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public synchronized static void syncStaticMethod2() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void syncStaticMethod3() throws InterruptedException {
        synchronized (ThreadSample.class) {
            while (true) {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
