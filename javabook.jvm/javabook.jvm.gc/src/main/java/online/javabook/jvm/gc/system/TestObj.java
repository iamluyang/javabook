package online.javabook.jvm.gc.system;

public class TestObj {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("我被触发了");
    }
}
