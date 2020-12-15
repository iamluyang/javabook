package org.gof.creational.patterns6.singleton;

public class LazyAndThreadSafeSingleton2 {

    private static LazyAndThreadSafeSingleton2 instance;

    private LazyAndThreadSafeSingleton2(){

    }

    public static synchronized LazyAndThreadSafeSingleton2 getInstance() {
        if (instance == null) {
            instance = new LazyAndThreadSafeSingleton2();
        }
        return instance;
    }
}
