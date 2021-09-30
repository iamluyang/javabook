package online.javabook.jvm.magic.hash.loadfactor;

import java.util.HashMap;

public class LoadFactorMain {
    public static void main(String[] args) {
        int count = 10000 * 1000;

        for (int loadFactor = 1; loadFactor <= 10; loadFactor++) {

            HashMap<Integer, Integer> hashMap1 = new HashMap<>(10000, (float) 0.10 * loadFactor);

            long start1 = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                hashMap1.put(i, i);
            }
            long finish1 = System.currentTimeMillis();
            System.out.println("put -> load factor:(" +  (float)(0.10 * loadFactor) + ")->" + (finish1 - start1));

            // --------------------------------------------------------------

            /*long start2 = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                hashMap1.get(i);
            }
            long finish2 = System.currentTimeMillis();
            System.out.println("get -> load factor:(" +  (float)(0.10 * loadFactor) + ")->" + (finish2 - start2));*/
        }
    }
}
