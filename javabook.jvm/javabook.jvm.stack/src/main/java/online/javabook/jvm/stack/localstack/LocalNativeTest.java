package online.javabook.jvm.stack.localstack;

/**
 * 本地方法用于抽象对不同操作系统底层的调用，或者为了提升语言性能
 */
public class LocalNativeTest {

    public native void test1();

    public native static void test2();

    public native synchronized void test3();

    public native void test4() throws Exception;
}
