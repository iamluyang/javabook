package online.javabook.jcu.cow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListConcurrentModificationMain {

    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        Thread readThread = new Thread(() -> {
            for (Object o : list) {
                System.out.println("iter:"+o);
                doSleep(1000);
            }
        });

        Thread writeThread = new Thread(() -> {
            for (int i = 11; i <= 20; i++) {
                doSleep(2000);
                list.add(i);
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
