package online.javabook.jvm.classinit.stackframe;

public class LocalVariablesTableOfStackFrameTest {

    public void methodA() {
        int a = 1;
        {
            int b = 2;
        }
        int c = a+ a;
    }

}
