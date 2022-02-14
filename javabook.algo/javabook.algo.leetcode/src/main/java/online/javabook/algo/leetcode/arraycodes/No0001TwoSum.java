package online.javabook.algo.leetcode.arraycodes;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */
public class No0001TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        int[] result = new Solution().twoSum2(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            // target = leftValue + rightValue
            for (int leftIndex = 0; leftIndex < nums.length; leftIndex++) {
                // 先获取左边的值
                int leftValue = nums[leftIndex];
                // 计算出右边的值
                int rightValue = target - leftValue;
                // 在剩余的数据中检查是否存在右边的值
                int rightIndex = getNextIndex(nums, leftIndex, rightValue);
                if (rightIndex != -1) {
                    return new int[]{leftIndex, rightIndex};
                }
            }
            return new int[]{};
        }

        // 相当于暴力轮询可能的数据
        private int getNextIndex(int[] nums, int leftIndex, int rightValue) {
            // 从左边leftIndex后面的数据获取，因为leftIndex前面的数据已经在之前计算过了
            for (int index = leftIndex + 1; index < nums.length; index++) {
                if (nums[index] == rightValue) {
                    return index;
                }
            }
            return -1;
        }

        // -------------------------------------------------------------------

        public int[] twoSum2(int[] nums, int target) {
            // target = leftValue + rightValue
            Map<Integer, Integer> values = new HashMap<>();
            for (int index = 0; index < nums.length; index++) {
                values.put(nums[index], index);
            }

            for (int leftIndex = 0; leftIndex < nums.length; leftIndex++) {
                // 先获取左边的值
                int leftValue = nums[leftIndex];
                // 计算出右边的值
                int rightValue = target - leftValue;
                Integer rightIndex = values.get(rightValue);
                if (rightIndex != null && rightIndex != leftIndex)
                    return new int[]{leftIndex, rightIndex};
            }
            return new int[]{};
        }
    }
}
