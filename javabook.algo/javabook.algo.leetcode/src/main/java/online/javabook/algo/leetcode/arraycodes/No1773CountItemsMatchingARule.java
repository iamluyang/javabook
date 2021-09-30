package online.javabook.algo.leetcode.arraycodes;

import java.util.ArrayList;
import java.util.List;

public class No1773CountItemsMatchingARule {
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        List phone = new ArrayList();
        phone.add("phone");
        phone.add("blue");
        phone.add("pixel");
        items.add(phone);

        List phone2 = new ArrayList();
        phone2.add("phone");
        phone2.add("blue2");
        phone2.add("pixel2");
        items.add(phone2);

        int result = countMatches(items, "type", "phone");
        System.out.println(result);
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int match = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        int count = 0;
        int size = items.size();

        // tip - don't use iter
        for (int index = 0; index < size; index++) {
            List item = items.get(index);
            if (item.get(match).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }
}
