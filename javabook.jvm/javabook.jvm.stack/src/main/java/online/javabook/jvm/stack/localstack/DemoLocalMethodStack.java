package online.javabook.jvm.stack.localstack;

public class DemoLocalMethodStack {
    public static void main(String[] args) {
        new Thread().start();
        // java线程栈和本地方法栈被混合在一起
        //  start0();
    }
}
