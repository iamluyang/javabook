package com.javabook.concurrent.utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author LuYang
 *
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        class People extends Thread {

            private CyclicBarrier barrier;

            public People(String name, CyclicBarrier barrier) {
                super(name);
                this.barrier = barrier;
            }

            public void run() {
                try {
                    System.out.println(getName() + "：从A前往B");
                    Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 3000));
                    System.out.println(getName() + "到了B");
                    barrier.await();

                    System.out.println(getName() + "：从B前往C");
                    Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 4000));
                    System.out.println(getName() + "到了C");
                    barrier.await();

                    System.out.println(getName() + "：从C前往D");
                    Thread.sleep(ThreadLocalRandom.current().nextInt(4000, 5000));
                    System.out.println(getName() + "到了D");
                    barrier.await();

                } catch (InterruptedException e) {
                } catch (BrokenBarrierException e) {
                }
            }
        }

        // 三个旅行者
        CyclicBarrier barrier = new CyclicBarrier(2);
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.submit(new People("旅行者1", barrier));
        exec.submit(new People("旅行者2", barrier));
        exec.shutdown();
    }
}