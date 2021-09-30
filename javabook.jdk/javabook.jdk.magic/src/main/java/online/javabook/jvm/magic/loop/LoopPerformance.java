package online.javabook.jvm.magic.loop;

import java.util.Iterator;

public class LoopPerformance {

    public static void main(String[] args) {

        long count = Long.MAX_VALUE;

        // ------------------------------------------------------------
        // 隐似迭代器
        // ------------------------------------------------------------
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            String object = new String();
        }
        long finish1 = System.currentTimeMillis();
        System.out.println("for1:" + (finish1 - start1));

        // ------------------------------------------------------------
        // 显式迭代器
        // ------------------------------------------------------------
        long start2 = System.currentTimeMillis();
        String object = new String();
        for (int i = 0; i < count; i++) {
            //object = new Object();
        }
        long finish2 = System.currentTimeMillis();
        System.out.println("for2:" + (finish2 - start2));

    }
}
