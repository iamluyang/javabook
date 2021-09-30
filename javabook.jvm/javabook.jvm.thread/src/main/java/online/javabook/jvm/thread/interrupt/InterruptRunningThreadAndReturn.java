package online.javabook.jvm.thread.interrupt;

public class InterruptRunningThreadAndReturn {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if(!Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + " 正在运行.");
                    }
                    else {
                        System.out.println(Thread.currentThread().getName() + ".isInterrupted() -> 第1次检测：" + Thread.currentThread().isInterrupted() + "; isAlive()：" + Thread.currentThread().isAlive());
                        return;
                    }
                }
            }
        };
        thread.start();
        System.out.println(thread.getName() + ".start() -> 启动线程");

        System.out.println(thread.getName() + ".interrupt() -> 中断线程");
        thread.interrupt();

        // main线程中的代码可能会被先执行, 尝试让main线程强行延迟一点，好让子线程有机会先运行(观察不同的打印输出)
        Thread.sleep(5);
        System.out.println(thread.getName() + ".isInterrupted() -> 第2次检测：" + thread.isInterrupted() + "; isAlive()：" + thread.isAlive());
    }
}
