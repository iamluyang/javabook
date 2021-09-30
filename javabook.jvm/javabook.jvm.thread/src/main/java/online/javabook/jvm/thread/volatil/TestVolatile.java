package online.javabook.jvm.thread.volatil;

public class TestVolatile {

    int a = 0;
    volatile boolean b = false;

    public void init() {
        a = 1; // 1
        b = true; // 2
    }

    public void use() {
        if (b) { // 3
            int i = a * a; // 4
        }
    }
}
