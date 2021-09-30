package online.javabook.jdk.java8.functionalinterface;

public class ThreadMain {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //......
            }
        });
        thread1.start();

        // ---------------------------------------------

        Thread thread2 = new Thread(() -> {
            //......
        });
        thread2.start();
    }
}
