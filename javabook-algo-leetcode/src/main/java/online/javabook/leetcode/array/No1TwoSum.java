package online.javabook.leetcode.array;

public class No1TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int leftIndex = 0; leftIndex < nums.length; leftIndex++) {
            int leftValue = nums[leftIndex];
            int rightValue = target - leftValue;
            int rightIndex = getNextIndex(nums, leftIndex, rightValue);
            if( rightIndex != -1) {
                return new int[] {leftIndex, rightIndex};
            }
        }
        return new int[] {};
    }

    private static int getNextIndex(int[] nums, int leftIndex, int rightValue) {
        for (int index = leftIndex + 1; index < nums.length; index++) {
            if(nums[index] == rightValue) {
                return index;
            }
        }
        return -1;
    }
}
