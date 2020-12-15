package org.gof.creational.patterns6.singleton;

public class LazyButNotThreadSafeSingleton1 {

    private static LazyButNotThreadSafeSingleton1 instance;

    private LazyButNotThreadSafeSingleton1(){

    }

    public static LazyButNotThreadSafeSingleton1 getInstance() {
        if (instance == null) {
            instance = new LazyButNotThreadSafeSingleton1();
        }
        return instance;
    }
}
