package online.javabook.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1313DecompressRunLengthEncodedList {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3};
        int[] result = decompressRLElist(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] decompressRLElist(int[] nums) {
        int numLength = nums.length;
        int resultLength = 0;
        for (int numberIndex = 0; numberIndex < numLength; numberIndex += 2) {
            int freq = nums[numberIndex];
            resultLength += freq;
        }
        int[] result = new int[resultLength];

        int fromIndex = 0;
        for (int numIndex = 0; numIndex < numLength; numIndex += 2) {
            Arrays.fill(result, fromIndex, fromIndex + nums[numIndex], nums[numIndex + 1]);
            fromIndex += nums[numIndex];
        }
        return result;
    }
}
