package org.gof.creational.patterns6.singleton;

public class DoubleCheckedLockingSingleton4 {

    private volatile static DoubleCheckedLockingSingleton4 singleton;

    private DoubleCheckedLockingSingleton4(){

    }

    public static DoubleCheckedLockingSingleton4 getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckedLockingSingleton4.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckedLockingSingleton4();
                }
            }
        }
        return singleton;
    }
}
