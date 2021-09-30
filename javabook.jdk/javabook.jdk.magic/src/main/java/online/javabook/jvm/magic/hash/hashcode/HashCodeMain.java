package online.javabook.jvm.magic.hash.hashcode;

import java.util.HashMap;

public class HashCodeMain {
    public static void main(String[] args) {
        int count = 10000 * 1;
        HashMap<ObjectWithGoodHashCode, Integer> hashMap1 = new HashMap<>();
        for (int i = 0; i < count; i++) {
            hashMap1.put(new ObjectWithGoodHashCode(i), i);
        }
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            hashMap1.get(new ObjectWithGoodHashCode(i));
        }
        long finish1 = System.currentTimeMillis();
        System.out.println("good hash code:" + (finish1 - start1));

        // ----------------------------------------------------------

        HashMap<ObjectWithBadHashCode, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < count; i++) {
            hashMap2.put(new ObjectWithBadHashCode(i), i);
        }
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            hashMap2.get(new ObjectWithBadHashCode(i));
        }
        long finish2 = System.currentTimeMillis();
        System.out.println("bad hash code:" + (finish2 - start2));

    }
}
