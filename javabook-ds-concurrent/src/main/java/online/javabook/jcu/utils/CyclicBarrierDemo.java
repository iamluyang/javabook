package online.javabook.jcu.utils;

import java.util.concurrent.*;

/**
 * @author LuYang
 *
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        final String[] point = {""};

        class People extends Thread {

            private CyclicBarrier barrier;

            public People(String name, CyclicBarrier barrier) {
                super(name);
                this.barrier = barrier;
            }

            public void run() {
                try {
                    System.out.println(getName() + "：从A前往B的路上");
                    Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 3000));
                    point[0] = "B";
                    barrier.await();

                    System.out.println(getName() + "：从B前往C的路上");
                    Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 4000));
                    point[0] = "C";
                    barrier.await();

                    System.out.println(getName() + "：从C前往D的路上");
                    Thread.sleep(ThreadLocalRandom.current().nextInt(4000, 5000));
                    point[0] = "D";
                    barrier.await();

                } catch (InterruptedException e) {
                } catch (BrokenBarrierException e) {
                }
            }
        }

        // 三个旅行者
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("两个旅行者都到达了集合地点:" + point[0]);
            }
        });
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.submit(new People("旅行者1", barrier));
        exec.submit(new People("旅行者2", barrier));
        exec.shutdown();
    }
}