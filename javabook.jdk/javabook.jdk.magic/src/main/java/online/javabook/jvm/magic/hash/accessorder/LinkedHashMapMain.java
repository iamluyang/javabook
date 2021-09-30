package online.javabook.jvm.magic.hash.accessorder;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMapMain {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new LinkedHashMap<String, String>(16, 0.75F, true);
        hashMap.put("1", "A");
        hashMap.put("2", "B");
        hashMap.put("3", "C");

        // 1 - Iterator Key
        for (String key : hashMap.keySet()) {
            System.out.println(key);
        }

        // 2 - Iterator Key
        hashMap.get("2"); // 2 go to last -> 1,3,2
        hashMap.get("1"); // 1 go to last -> 3,2,1
        for (String key : hashMap.keySet()) {
            System.out.println(key);
        }

        // 3 - Iterator Value - ConcurrentModificationException
        for (String key : hashMap.keySet()) {
            System.out.println(hashMap.get(key));
        }
    }
}
