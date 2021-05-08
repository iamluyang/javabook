package online.javabook.leetcode.array;

public class No1365HowManyNumbersAreSmallerThanTheCurrentNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 2, 2, 3};
        int[] result = smallerNumbersThanCurrent(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int numberLength = nums.length;
        int[] counts = new int[101];
        for (int numberIndex = 0; numberIndex < numberLength; numberIndex++) {
            counts[nums[numberIndex]]++;
        }

        int countsLength = counts.length;
        for (int countIndex = 1; countIndex < countsLength; countIndex++) {
            counts[countIndex] = counts[countIndex - 1] + counts[countIndex];
        }

        int[] result = new int[numberLength];
        for (int numberIndex = 0; numberIndex < numberLength; numberIndex++) {
            result[numberIndex] = nums[numberIndex] == 0 ? 0 : counts[nums[numberIndex] - 1];
        }

        return result;
    }
}
