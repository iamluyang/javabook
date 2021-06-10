package online.javabook.leetcode.arraycodes;

import java.util.ArrayList;
import java.util.List;

public class No1431KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 1, 3};
        List<Boolean> result = kidsWithCandies(nums, 3);
        for (Boolean i : result) {
            System.out.println(i);
        }
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for (int childIndex = 0; childIndex < candies.length; childIndex++) {
            int candy = candies[childIndex];
            if (candy > maxCandy) {
                maxCandy = candy;
            }
        }

        List<Boolean> result = new ArrayList<>(candies.length);
        for (int childIndex = 0; childIndex < candies.length; childIndex++) {
            int candy = candies[childIndex];
            if (candy + extraCandies >= maxCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
