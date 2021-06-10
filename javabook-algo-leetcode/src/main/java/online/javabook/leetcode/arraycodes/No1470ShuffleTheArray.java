package online.javabook.leetcode.arraycodes;

import java.util.ArrayList;
import java.util.List;

public class No1470ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,3,2,1};
        int[] result = shuffle(nums, 4);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] shuffle(int[] nums, int n) {
        int [] result = new int[nums.length];
        for (int numIndex = 0; numIndex < nums.length; numIndex++) {
            if(numIndex + n < nums.length){
                int resultIndex = numIndex * 2;
                result[resultIndex] = nums[numIndex];
                result[resultIndex + 1] = nums[numIndex + n];
            }else{
                break;
            }
        }
        return result;
    }
}
