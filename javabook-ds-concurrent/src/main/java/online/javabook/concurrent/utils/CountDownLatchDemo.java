package online.javabook.concurrent.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 案例：CountDownLatch
 *
 * @author LuYang
 *
 */
public class CountDownLatchDemo {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        int runnerCount = 9;

        // 宣布比赛开始的口令，当所有运动员都来到起跑线才允许比赛开始
        CountDownLatch startCountDown = new CountDownLatch(1);

        // 宣布比赛结束的口令
        // 有 runnerCount 个运动员参赛，直到所有人都跑到了终点比赛才算正式结束
        CountDownLatch endCountDown = new CountDownLatch(runnerCount);

        // runnerCount个运动员陆续来到
        for (int i = 1; i <= runnerCount; i++) {
            Thread runner = new Thread(new Running(i, startCountDown, endCountDown));
            runner.start();
        }

        // 宣布比赛开始
        Thread.sleep(2000);
        System.out.println("比赛开始");
        startCountDown.countDown();

        // 宣布比赛结束
        endCountDown.await();
        System.out.println("比赛结束");
    }

    static class Running implements Runnable {

        private int id;
        private CountDownLatch startCountDown;
        private CountDownLatch endCountDown;

        public Running(int id, CountDownLatch startCountDown, CountDownLatch endCountDown) {
            this.id = id;
            this.startCountDown = startCountDown;
            this.endCountDown   = endCountDown;
        }

        @Override
        public void run() {
            try {
                System.out.println(id + "：来到起跑线，并等待其他运动员的到来。");
                startCountDown.await();

                try {
                    // 当前运动员正在跑步比赛（耗时9秒到12秒）
                    Thread.sleep( ThreadLocalRandom.current().nextInt(9000, 12000));

                    // 当前运动员结束跑步比赛
                    System.out.println(id + "：完成比赛");
                } finally {
                    // 当前运动员报告完成比赛
                    endCountDown.countDown();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}