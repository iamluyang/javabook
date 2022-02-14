package online.javabook.algo.leetcode.arraycodes;

import online.javabook.algo.leetcode.commons.ListNode;

import java.util.BitSet;
import java.util.HashMap;

/**
 * 小结：1.使用多轮循环穷举
 *      2.发现是否存在缩小左边缘位置的方法
 * ----------------------------------------------------------------------
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
public class No0003LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        String s = "au";
        int result = new Solution().lengthOfLongestSubstring3(s);
        System.out.println(result);
    }

    static class Solution {

        // 使用穷尽的方式递增左边界
        public int lengthOfLongestSubstring(String s) {

            int length = s.length();
            if (length == 0) return 0;
            if (length == 1) return 1;
            int max = 0;
            byte[] abc = new byte[256];

            // 重置左边界的起始位置
            for (int leftIdx = 0; leftIdx < length; leftIdx++) {

                // 从左边界的起始位置开始计算长度
                int total = 0;
                for (int idx = leftIdx; idx < length; idx++) {
                    char currChar = s.charAt(idx);
                    int location = currChar;
                    if (abc[location] == 0) {
                        abc[location] = 1;
                        total++;
                        max = total > max ? total : max;
                    } else {
                        abc = new byte[256];
                        break;
                    }
                }
            }
            return max;
        }

        // 使用滑动窗口计算(实际是只是优化了左边缘的位置的计算)
        public int lengthOfLongestSubstring2(String s) {
            if (s.length() == 0) return 0;
            if (s.length() == 1) return 1;

            int max = 0;
            HashMap<Character, Integer> map = new HashMap<>(128);

            // 从左向右取出字符
            int startIdx = 0;
            for (int endIdx = 0; endIdx < s.length(); endIdx++) {
                char charValue = s.charAt(endIdx);

                // 如果map中已经存在这样的字符
                Integer keyIdx = map.get(charValue);
                if (keyIdx != null) {
                    // 取出该重复字符上一次的位置，
                    startIdx = Math.max(startIdx, keyIdx + 1);
                }

                // 将当前字符的索引位置放入map
                map.put(charValue, endIdx);

                // 计算首位之间的字符长度：endIdx - startIdx + 1
                max = Math.max(max, endIdx - startIdx + 1);
            }
            return max;
        }

        // 使用滑动窗口计算(优化了用更紧凑的容器来存储数据和索引)
        public int lengthOfLongestSubstring3(String s) {
            if (s.length() == 0) return 0;
            if (s.length() == 1) return 1;

            int max = 0;
            short[] map = new short[256];
            for (int i = 0; i < map.length; i++) {
                map[i] = -1;
            }

            // 从左向右取出字符
            int startIdx = 0;
            for (short endIdx = 0; endIdx < s.length(); endIdx++) {
                char charValue = s.charAt(endIdx);

                // 如果map中已经存在这样的字符
                int keyIdx = map[charValue];
                if (keyIdx != -1) {
                    // 取出该重复字符上一次的位置，
                    startIdx = Math.max(startIdx, keyIdx + 1);
                }

                // 将当前字符的索引位置放入map
                map[charValue] = endIdx;

                // 计算滑动窗口中的字符长度：endIdx - startIdx + 1
                max = Math.max(max, endIdx - startIdx + 1);
            }

            return max;
        }
    }

}
