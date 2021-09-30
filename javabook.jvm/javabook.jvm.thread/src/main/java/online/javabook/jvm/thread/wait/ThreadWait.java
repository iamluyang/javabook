package online.javabook.jvm.thread.wait;

public class ThreadWait {
    public static void main(String[] args) {

        Object lock = new Object();
        Thread thread = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {

                    while (true) {
                        System.out.println("synchronized (lock)");
                        try {
                            System.out.println("begin:wait");
                            lock.wait(5000);
                            System.out.println("finis:wait");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        };
        thread.start();
    }


}
