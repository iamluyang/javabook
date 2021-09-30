package online.javabook.jvm.bytecode.exceptiontable;

/**
 *
 */
public class ExceptionTableByteCode {

    public void methodA() {
        try {
            methodB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void methodB() throws Exception {
        while (true) {
            throw new Exception();
        }
    }
}
