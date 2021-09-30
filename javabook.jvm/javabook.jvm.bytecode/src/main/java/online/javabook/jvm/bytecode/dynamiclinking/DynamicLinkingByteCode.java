package online.javabook.jvm.bytecode.dynamiclinking;

/**
 * 动态连接
 */
public class DynamicLinkingByteCode {

    private int field1;

    public void methodA() {
        methodB();
        field1++;
    }

    public void methodB() {

    }
}
