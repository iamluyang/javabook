package online.javabook.jvm.thread.stackframe;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class TestThreadStack {

    private ArrayList sharedInstance = new ArrayList();

    public static void main(String[] args) {
        TestThreadStack testThreadStackFrame = new TestThreadStack();
        testThreadStackFrame.methodTwo();
    }

    private void methodTwo() {
        methodOne();
        Date localVariable1 = new Date();
        System.out.println("------------>call methodTwo");
    }

    private void methodOne() {
        int localVariable1 = 45;
        ArrayList localVariable2 = sharedInstance;
        localVariable2.add(new Object());
        System.out.println("------------>call methodOne");

        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        for (Map.Entry<Thread, StackTraceElement[]> threadEntry : allStackTraces.entrySet()) {
            System.out.println(threadEntry.getKey().getName()+"->");
            for (StackTraceElement stackTraceElement : threadEntry.getValue()) {
                System.out.println("stackTraceElement:" + stackTraceElement);
            }
        }
    }

}
