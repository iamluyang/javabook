package online.javabook.jvm.thread.interrupt;

public class InterruptWaitThread {
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        Thread thread = new Thread() {
            @Override
            public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ".wait() -> 线程等待");
                synchronized (lock) {
                    System.out.println("xxx");
                    lock.wait();
                }
            } catch (InterruptedException e) {
                // 处于wait状态的线程如果被打断， 不能立即捕获异常，仍然需要重新获得锁，再回到等待被中断的地方
                System.out.println(Thread.currentThread().getName() + ".isInterrupted() -> 第1次检测：" + Thread.currentThread().isInterrupted() + "; isAlive()：" + Thread.currentThread().isAlive());
                e.printStackTrace();
            }
            }
        };

        thread.start();
        System.out.println(thread.getName() + ".start() -> 启动线程");

        Thread.sleep(1000);
        System.out.println(thread.getName() + ".interrupt() -> 中断线程");
        thread.interrupt();

        Thread.sleep(1000);
        System.out.println(thread.getName() + ".isInterrupted() -> 第2次检测：" + thread.isInterrupted() + "; isAlive()：" + thread.isAlive());
    }
}
