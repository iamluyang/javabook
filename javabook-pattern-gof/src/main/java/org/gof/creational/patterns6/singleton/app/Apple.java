package org.gof.creational.patterns6.singleton.app;

import org.gof.creational.patterns6.singleton.DoubleCheckedLockingSingleton4;

public class Apple {

    public void notSyncMethod() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void notSyncStaticMethod() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public synchronized void syncMethod1() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public synchronized static void syncStaticMethod1() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public synchronized void syncMethod2() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public synchronized static void syncStaticMethod2() throws InterruptedException {
        while(true){
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
        }
    }
}
