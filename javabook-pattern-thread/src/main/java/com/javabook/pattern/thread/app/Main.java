package com.javabook.pattern.thread.app;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadSample apple1 = new ThreadSample();
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
