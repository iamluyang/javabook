package online.javabook.jcu.sync;

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

        // 宣布比赛开始的口令
        // 当启动发令枪倒数为0时运动员才可以开始比赛
        CountDownLatch startCountDown = new CountDownLatch(1);

        // 宣布比赛结束的口令
        // 当3个运动员都跑到了终点比赛才算正式结束
        CountDownLatch endCountDown = new CountDownLatch(3);

        // runnerCount个运动员陆续来到
        Thread player1 = new Thread(new Player("Play1", startCountDown, endCountDown));
        player1.start();

        Thread player2 = new Thread(new Player("Play2", startCountDown, endCountDown));
        player2.start();

        Thread player3 = new Thread(new Player("Play3", startCountDown, endCountDown));
        player3.start();

        // 宣布比赛开始
        Thread.sleep(2000);
        System.out.println("比赛开始，发令枪准备从1倒数为0");
        startCountDown.countDown();

        // 宣布比赛结束
        endCountDown.await();
        System.out.println("比赛结束");
    }

    static class Player implements Runnable {

        private String player;
        private CountDownLatch startCountDown;
        private CountDownLatch endCountDown;

        public Player(String player, CountDownLatch startCountDown, CountDownLatch endCountDown) {
            this.player = player;
            this.startCountDown = startCountDown;
            this.endCountDown   = endCountDown;
        }

        @Override
        public void run() {
            try {
                System.out.println(player + "：来到起跑线，并等待其他运动员的到来。");
                startCountDown.await(); // 阻塞中，直到startCountDown为0

                try {
                    // 当前运动员正在跑步比赛（耗时9秒到12秒）
                    Thread.sleep( ThreadLocalRandom.current().nextInt(9000, 12000));

                    // 当前运动员结束跑步比赛
                    System.out.println(player + "：完成比赛");
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