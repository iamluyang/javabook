package online.javabook.jvm.thread.stackframe;

public class MyRunnable implements Runnable {

    public void run() {
        methodOne();
    }

    public void methodOne() {
        // 原始局部变量
        int localVariable1 = 45;

        // 引用局部变量
        MySharedObject localVariable2 = MySharedObject.sharedInstance; // 被引用的对象

        methodTwo();
    }

    public void methodTwo() {
        // 引用局部变量
        Integer localVariable1 = new Integer(99);  // 被引用的对象
        //... do more with local variable.
    }
}
