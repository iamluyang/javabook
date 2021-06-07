package online.javabook.gof.creational.patterns6.singleton;

public class NotLazyAndThreadSafeSingleton {

    private static NotLazyAndThreadSafeSingleton instance = new NotLazyAndThreadSafeSingleton();

    private NotLazyAndThreadSafeSingleton(){

    }

    public static NotLazyAndThreadSafeSingleton getInstance() {
        return instance;
    }
}
