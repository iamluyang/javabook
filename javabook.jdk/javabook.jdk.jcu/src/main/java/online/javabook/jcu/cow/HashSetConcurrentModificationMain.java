package online.javabook.jcu.cow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetConcurrentModificationMain {

    public static void main(String[] args) {
        Set set = new HashSet();
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
