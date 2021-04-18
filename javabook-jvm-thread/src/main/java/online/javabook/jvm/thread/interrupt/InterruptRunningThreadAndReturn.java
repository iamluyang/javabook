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

        Thread.sleep(5);
        System.out.println(thread.getName() + ".isInterrupted() -> 第2次检测：" + thread.isInterrupted() + "; isAlive()：" + thread.isAlive());
    }
}
