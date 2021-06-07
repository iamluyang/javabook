package online.javabook.gof.creational.patterns6.singleton;

public class DoubleCheckedLockingSingleton {

    private volatile static DoubleCheckedLockingSingleton singleton;

    private DoubleCheckedLockingSingleton(){

    }

    public static DoubleCheckedLockingSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return singleton;
    }
}
