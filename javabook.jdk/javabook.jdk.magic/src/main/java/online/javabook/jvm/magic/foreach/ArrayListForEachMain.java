package online.javabook.jvm.magic.foreach;

import java.util.*;

public class ArrayListForEachMain {
    public static void main(String[] args) {
        int count = 10000 * 1;
        List<String> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(String.valueOf(i));
        }

        // ------------------------------------------------------------
        // 隐似迭代器
        // ------------------------------------------------------------
        long start1 = System.currentTimeMillis();
        for (String element : list) {

        }

        // 编译器的等价转换
        //for(Iterator var5 = list.iterator(); var5.hasNext(); var6 = (String)var5.next()) {
        //}

        long finish1 = System.currentTimeMillis();
        System.out.println("Foreach ArrayList:" + (finish1 - start1));

        // ------------------------------------------------------------
        // 显式迭代器
        // ------------------------------------------------------------
        long start2 = System.currentTimeMillis();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            iterator.next();
        }

        // 编译器的等价转换
        //while(iterator.hasNext()) {
        //    iterator.next();
        //}
        long finish2 = System.currentTimeMillis();
        System.out.println("Iterator ArrayList:" + (finish2 - start2));

        // ------------------------------------------------------------
        // 显式迭代器
        // ------------------------------------------------------------
        long start3 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long finish3 = System.currentTimeMillis();
        System.out.println("Index ArrayList:" + (finish3 - start3));
    }
}
