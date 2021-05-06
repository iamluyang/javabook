package online.javabook.jvm.thread.interrupt;

public class InterruptSleepThread {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + ".sleep() -> 休眠线程");
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
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
