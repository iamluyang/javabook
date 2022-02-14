package online.javabook.algo.leetcode.arraycodes;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * ----------------------------------------------------------------------
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * ----------------------------------------------------------------------
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * ----------------------------------------------------------------------
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * ----------------------------------------------------------------------
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 */
public class No0004MedianOfTwoSortedArrays {
    public static void main(String[] args) {

        String s = "au";
        int[] nums1 = new int[]{1, 3, 5, 7, 9, 11, 13};
        int[] nums2 = new int[]{2, 15};
        // 1, 2, 3, 5, 7, 9, 11, 13, 15
        double result = new Solution().findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    static class Solution {

        // 合并数组再找出中间数
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] nums3 = new int[nums1.length + nums2.length];
            double median = 0.0;
            int idx1 = 0;
            int idx2 = 0;
            int idx3 = 0;
            // 合并有序数组
            while(idx1 < nums1.length && idx2 < nums2.length){
                if(nums1[idx1] < nums2[idx2]){
                    nums3[idx3++] = nums1[idx1++];
                    continue;
                }else {
                    nums3[idx3++] = nums2[idx2++];
                    continue;
                }
            }

            // 处理上面没有比较完的数组的剩余数据
            while(idx1 < nums1.length){
                nums3[idx3++] = nums1[idx1++];
            }
            while(idx2 < nums2.length){
                nums3[idx3++] = nums2[idx2++];
            }

            // 判断数组长度的奇偶性
            int index = nums3.length / 2;
            if(nums3.length % 2 == 0){
                median = ((double) nums3[index - 1] + (double)nums3[index]) / 2;
            }else{
                median = nums3[index];
            }
            return median;

        }

        // 二分法
        public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
            int n1Length = nums1.length;
            int n2Length = nums2.length;
            if (n1Length > n2Length)
                return findMedianSortedArrays2(nums2, nums1);

            int k = (n1Length + n2Length + 1) / 2;
            int left = 0;
            int right = n1Length;
            while (left < right) {
                int m1 = left + (right - left) / 2;
                int m2 = k - m1;
                if (nums1[m1] < nums2[m2 - 1])
                    left = m1 + 1;
                else
                    right = m1;
            }

            int m1 = left;
            int m2 = k - left;
            int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
            if ((n1Length + n2Length) % 2 == 1) {
                return c1;
            }

            int c2 = Math.min(m1 >= n1Length ? Integer.MAX_VALUE : nums1[m1], m2 >= n2Length ? Integer.MAX_VALUE : nums2[m2]);
            return (c1 + c2) * 0.5;
        }
    }

}
