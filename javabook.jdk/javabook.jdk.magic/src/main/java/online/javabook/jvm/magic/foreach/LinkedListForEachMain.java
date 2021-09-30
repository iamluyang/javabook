package online.javabook.jvm.magic.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListForEachMain {
    public static void main(String[] args) {
        int count = 10000 * 1000;
        List<String> list = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            list.add(String.valueOf(i));
        }

        // ------------------------------------------------------------
        // 隐似迭代器
        // ------------------------------------------------------------
        long start1 = System.currentTimeMillis();
        for (String element : list) {

        }
        long finish1 = System.currentTimeMillis();
        System.out.println("Foreach LinkedList:" + (finish1 - start1));

        // ------------------------------------------------------------
        // 显式迭代器
        // ------------------------------------------------------------
        long start2 = System.currentTimeMillis();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            iterator.next();
        }
        long finish2 = System.currentTimeMillis();
        System.out.println("Iterator LinkedList:" + (finish2 - start2));

        // ------------------------------------------------------------
        // 显式迭代器
        // ------------------------------------------------------------
        long start3 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long finish3 = System.currentTimeMillis();
        System.out.println("index LinkedList:" + (finish3 - start3));

    }
}
