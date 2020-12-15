package org.gof.creational.patterns6.singleton.app;

import org.gof.creational.patterns6.singleton.LazyButNotThreadSafeSingleton1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        new Thread("T1"){
            @Override
            public void run() {
                while (true) {
                    try {
                        apple1.syncStaticMethod1();
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
                        apple1.notSyncStaticMethod();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        Thread.sleep(100000000);
    }
}
