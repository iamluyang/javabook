package online.javabook.jvm.thread.interrupt;

public class InterruptRunningThreadAndContinue {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if(!Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + " is running.");
                    }
                    else {
                        System.out.println(Thread.currentThread().getName() + ".isInterrupted() -> 第1次检测：" + Thread.currentThread().isInterrupted() + "; isAlive()：" + Thread.currentThread().isAlive());

                        // 屏蔽或开启interrupted(),观察打印输出的结果有什么不同
                        Thread.currentThread().interrupted();
                        System.out.println("thread.interrupted() -> 中断重置");
                    }
                }
            }
        };
        thread.start();
        System.out.println("thread.start() -> 启动线程");

        Thread.sleep(1);
        System.out.println("thread.interrupt() -> 中断线程");
        thread.interrupt();

        Thread.sleep(1);
        System.out.println(thread.getName() + ".isInterrupted() -> 第2次检测：" + thread.isInterrupted() + "; isAlive()：" + thread.isAlive());
    }
}
