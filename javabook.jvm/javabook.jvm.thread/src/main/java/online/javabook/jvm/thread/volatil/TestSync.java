package online.javabook.jvm.thread.volatil;

public class TestSync {

    int a = 0;
    boolean b = false;

    public synchronized void init() {
        a = 1; // 1
        b = true; // 2
    }

    public synchronized void use() {
        if (b) { // 3
            int i = a * a; // 4
        }
    }
}
