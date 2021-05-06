package online.javabook.jcu.cow;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetConcurrentModificationMain {

    public static void main(String[] args) {
        Set set = new TreeSet();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(4);
        set.add(4);
        set.add(5);
        set.add(5);

        Thread readThread = new Thread(() -> {
            for (Object o : set) {
                System.out.println("iter:"+o);
                doSleep(1000);
            }
        });

        Thread writeThread = new Thread(() -> {
            for (int i = 11; i <= 20; i++) {
                doSleep(2000);
                set.add(i);
                System.out.println("add:"+i);
            }
        });

        readThread.start();
        writeThread.start();
    }

    private static void doSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
