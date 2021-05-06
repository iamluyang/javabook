package online.javabook.jvm.thread.samethread;

import java.util.concurrent.CountDownLatch;

public class MultiSingleThreadLoopMain {
    public static void main(String[] args) throws InterruptedException {

        int threadCount = 2;
        for (int i = 0; i <=8 ; i++) {

            CountDownLatch startCountDown = new CountDownLatch(threadCount);
            CountDownLatch finishCountDown = new CountDownLatch(threadCount);

            int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    int total = (int) Math.pow(10, finalI) / threadCount;

                    startCountDown.countDown();
                    for (int j = 0; j < total; j++){
                        new QuickTask().run();
                    }
                    finishCountDown.countDown();
                }
            };

            for (int j = 0; j < threadCount; j++) {
                new Thread(runnable).start();
            }

            startCountDown.await();
            long start = System.currentTimeMillis();

            finishCountDown.await();
            long finish = System.currentTimeMillis();

            int total = (int) Math.pow(10, i);
            System.out.println("TwoSingleThreadLoopMain -> 运行 QuickTask " + total + "次，花费时间: " + (finish - start) + " milliseconds");
        }
    }
}
