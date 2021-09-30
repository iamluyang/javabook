package online.javabook.jvm.classinit.stackframe;

public class StackFrameTest {

    public void methodA() {
        methodB();
    }

    public void methodB() {
        methodC();
    }

    public void methodC() {

    }
}
