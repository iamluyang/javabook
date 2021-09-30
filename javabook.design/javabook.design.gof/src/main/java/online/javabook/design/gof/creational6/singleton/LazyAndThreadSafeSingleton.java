package online.javabook.design.gof.creational6.singleton;

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
