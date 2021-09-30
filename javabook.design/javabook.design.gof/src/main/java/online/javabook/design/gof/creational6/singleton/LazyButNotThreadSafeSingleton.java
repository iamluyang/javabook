package online.javabook.design.gof.creational6.singleton;

public class LazyButNotThreadSafeSingleton {

    private static LazyButNotThreadSafeSingleton instance;

    private LazyButNotThreadSafeSingleton(){

    }

    public static LazyButNotThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new LazyButNotThreadSafeSingleton();
        }
        return instance;
    }
}
