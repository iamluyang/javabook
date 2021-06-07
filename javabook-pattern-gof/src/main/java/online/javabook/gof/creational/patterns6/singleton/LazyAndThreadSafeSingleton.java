package online.javabook.gof.creational.patterns6.singleton;

public class LazyAndThreadSafeSingleton {

    private static LazyAndThreadSafeSingleton instance;

    private LazyAndThreadSafeSingleton(){

    }

    public static synchronized LazyAndThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new LazyAndThreadSafeSingleton();
        }
        return instance;
    }
}
