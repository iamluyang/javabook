package online.javabook.leetcode.arraycodes;

import java.util.HashMap;

public class No1512NumberOfGoodPairs {

    public static void main(String[] args) {
        int[] nums = new int[]{5,5,1,77,96,96,89,80,12,23,1,6,3,66,39,88,48,38,44,32,44,36,60,87,53,77,72,49,13,39,60,60,71,68,80,75,79,38,4,14,59,75,6,91,87,95,25,55,83,18,26,59,53,100,42,96,76,22,21,4,22,46,34,39,98,82,54,73,52,33,47,73,54,23,82,98,13,51,52,1,96,69,76};
        int result = numIdenticalPairs3(nums);
        System.out.println(result);
    }

    public static int numIdenticalPairs(int[] nums) {
        int result = 0;
        for (int numOutIndex = 0; numOutIndex < nums.length; numOutIndex++) {
            for (int numInIndex = numOutIndex + 1; numInIndex < nums.length; numInIndex++) {
                if (nums[numOutIndex] == nums[numInIndex]) {
                    result++;
                }
            }
        }
        return result;
    }

    // references count by hash map
    public static int numIdenticalPairs2(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            Integer count = map.get(num);
            if (count != null) {
                // count the number of repetitions
                count = count + 1;
                map.put(num, count);
                result += count;
            } else
                map.put(num, 0);
        }
        return result;
    }

    // tip - references count by array
    public static int numIdenticalPairs3(int[] nums) {
        int result = 0;
        int count[] = new int[101];

        for (int numIndex = 0; numIndex < nums.length; numIndex++) {
            int num = nums[numIndex];
            int time = count[num];
            count[num] = time + 1;

            if (time > 0) {
                result += time;
            }
        }
        return result;
    }
}
