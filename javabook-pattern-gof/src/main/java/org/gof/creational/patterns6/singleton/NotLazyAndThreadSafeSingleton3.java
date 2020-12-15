package org.gof.creational.patterns6.singleton;

public class NotLazyAndThreadSafeSingleton3 {

    private static NotLazyAndThreadSafeSingleton3 instance = new NotLazyAndThreadSafeSingleton3();

    private NotLazyAndThreadSafeSingleton3(){

    }

    public static NotLazyAndThreadSafeSingleton3 getInstance() {
        return instance;
    }
}
