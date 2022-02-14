package online.javabook.algo.leetcode.arraycodes;

import online.javabook.algo.leetcode.commons.ListNode;

/**
 * ----------------------------------------------------------------------
 * 小结：循环大法，处理好进位逻辑即可。
 * ----------------------------------------------------------------------
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * ----------------------------------------------------------------------
 * 例子：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * ----------------------------------------------------------------------
 */
public class No0002AddTwoNumbers {
    public static void main(String[] args) {
        //ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        //ListNode l2 = new ListNode(9 , new ListNode(9, new ListNode(9, new ListNode(9))));

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = new Solution().addTwoNumbers(l1, l2);
        ListNode nextNode = result;
        while (nextNode != null) {
            System.out.println(nextNode.val);
            nextNode = nextNode.next;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 参与计算的链表1
            ListNode nextNode1 = l1;
            // 参与计算的链表2
            ListNode nextNode2 = l2;
            // 计算的结果链表3
            ListNode nextNode3 = null;
            // 最后一个计算位
            ListNode lastNode   = null;

            // 是否需要进位
            boolean isUp = false;
            while (nextNode1 != null || nextNode2 != null || isUp) {

                // 创建一个新节点
                ListNode currNode = new ListNode(0);

                // 是否存在结果节点
                if(nextNode3 == null) {
                    nextNode3 = currNode;
                }

                // 是否存在最后一个计算节点，没有就创建，有就链接上
                if(lastNode != null) {
                    lastNode.next = currNode;
                }

                // 取节点的值并计算
                int val1 = 0;
                int val2 = 0;
                if(nextNode1 != null) {
                    val1 = nextNode1.val;
                }
                if(nextNode2 != null) {
                    val2 = nextNode2.val;
                }
                int sum = val1 + val2;

                // 是否处理进位
                if(isUp) {
                    sum++;
                }

                // 给节点赋值
                if(sum < 10) {
                    currNode.val = sum;
                    isUp = false;
                }else {
                    currNode.val = sum % 10;
                    isUp = true;
                }

                // 继续下一个节点
                if(nextNode1!=null){
                    nextNode1 = nextNode1.next;
                }
                if(nextNode2!=null){
                    nextNode2 = nextNode2.next;
                }
                lastNode = currNode;

                // 如果没有计算节点，但还否存在进位的情况，最后一次进位后可以退出
                if(nextNode1 == null && nextNode2 == null && isUp) {
                    lastNode.next = new ListNode(1);
                    break;
                }
            }

            return nextNode3;
        }
    }
}
