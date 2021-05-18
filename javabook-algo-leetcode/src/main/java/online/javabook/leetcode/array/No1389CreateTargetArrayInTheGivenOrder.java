package online.javabook.leetcode.array;

import java.util.Arrays;

public class No1389CreateTargetArrayInTheGivenOrder {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,0};
        int[] index = new int[] {0,1,2,3,0};
        int[] result = createTargetArray(nums, index);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] createTargetArray(int[] nums, int[] index) {

        int numsLength = nums.length;
        int[] result = new int[numsLength];
        Arrays.fill(result, -1);

        // tip - System.arraycopy
        for (int idx = 0; idx < numsLength; idx++) {
            int numberIndex = index[idx];

            if(result[numberIndex]==-1) {
                result[numberIndex] = nums[idx];
            }else{
                int[] temp = Arrays.copyOfRange(result, numberIndex, idx);
                result[numberIndex] = nums[idx];
                System.arraycopy(temp, 0, result, numberIndex + 1, temp.length);
            }
        }

        return result;
    }
}
