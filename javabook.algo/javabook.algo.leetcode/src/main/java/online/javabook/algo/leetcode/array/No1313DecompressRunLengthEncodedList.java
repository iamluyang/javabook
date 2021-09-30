package online.javabook.algo.leetcode.array;

public class No1313DecompressRunLengthEncodedList {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] result = decompressRLElist(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] decompressRLElist(int[] nums) {

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
