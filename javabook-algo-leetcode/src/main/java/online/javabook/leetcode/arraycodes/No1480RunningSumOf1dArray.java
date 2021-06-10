package online.javabook.leetcode.arraycodes;

public class No1480RunningSumOf1dArray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = runningSum(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] runningSum(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            if (index > 0) {
                nums[index] = num + nums[index - 1];
            } else {
                nums[index] = num;
            }
        }
        return nums;
    }
}
