package online.javabook.jvm.thread.whereislock;

public class WhereIsLockMain {

    public static void main(String[] args) throws InterruptedException {
        SimpleObject apple1 = new SimpleObject();
        new Thread("T1"){
            @Override
            public void run() {
                while (true) {
                    try {
                        apple1.syncMethod1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("T2"){
            @Override
            public void run() {
                while (true) {
                    try {
                        apple1.syncMethod1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        Thread.sleep(100000000);
    }
}
