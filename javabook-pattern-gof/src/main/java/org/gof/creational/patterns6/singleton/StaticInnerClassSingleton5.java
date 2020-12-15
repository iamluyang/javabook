package org.gof.creational.patterns6.singleton;

public class StaticInnerClassSingleton5 {

    private static class SingletonHolder {
        private static final StaticInnerClassSingleton5 INSTANCE = new StaticInnerClassSingleton5();
    }

    private StaticInnerClassSingleton5(){

    }

    public static final StaticInnerClassSingleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
