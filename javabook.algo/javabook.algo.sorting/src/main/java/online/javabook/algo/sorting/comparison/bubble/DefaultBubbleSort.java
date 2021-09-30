package online.javabook.algo.sorting.comparison.bubble;

import online.javabook.algo.sorting.api.Sort;

/**
 * 算法概况
 * 算法类别	    排序
 * 数据结构	    数组
 *
 * 时间复杂度
 * 最优时间复杂度	O(n)
 * 最坏时间复杂度	O(n^2)
 * 平均时间复杂度	O(n^2)
 *
 * 空间复杂度
 * 总共O(n)，需要辅助空间O(1)
 * 最佳解	    No
 * -----------------------------------------------------------------
 * 第[1]轮冒泡
 * [5]	[4]	[3]	[2]	[1]
 * \ /
 * c&s
 * / \
 * [4]	[5]	[3]	[2]	[1]
 * \ /
 * c&s
 * / \
 * [4]	[3]	[5]	[2]	[1]
 * \ /
 * c&s
 * / \
 * [4]	[3]	[2]	[5]	[1]
 * \ /
 * c&s
 * / \
 * [4]	[3]	[2]	[1]	[5]
 * 第[2]轮冒泡
 * [4]	[3]	[2]	[1]	[5]
 * \ /
 * c&s
 * / \
 * [3]	[4]	[2]	[1]	[5]
 * \ /
 * c&s
 * / \
 * [3]	[2]	[4]	[1]	[5]
 * \ /
 * c&s
 * / \
 * [3]	[2]	[1]	[4]	[5]
 * 第[3]轮冒泡
 * [3]	[2]	[1]	[4]	[5]
 * \ /
 * c&s
 * / \
 * [2]	[3]	[1]	[4]	[5]
 * \ /
 * c&s
 * / \
 * [2]	[1]	[3]	[4]	[5]
 * 第[4]轮冒泡
 * [2]	[1]	[3]	[4]	[5]
 * \ /
 * c&s
 * / \
 * [1]	[2]	[3]	[4]	[5]
 * Sort{comparisons=10, swaps=10}
 * <p>
 * -----------------------------------------------------------------
 */
public class DefaultBubbleSort extends Sort {

    @Override
    protected void abstSortAsc(Comparable[] array) {
        int length = array.length;

        // 外部循环表示要要执行多少轮冒泡算法
        for (int i = 0; i < length - 1; i++) {

            System.out.println("第[" + (i + 1) + "]轮冒泡");
            printArray(array);

            // 内部循环指定执行每一轮冒泡算法的数据区间
            for (int j = 0; j < length - i - 1; j++) {
                int compare = compare(array, j, j + 1);

                if (compare > 0) {
                    swap(array, j, j + 1);
                    printBubbleSort(array, j, j + 1);
                }
            }
        }
    }
}
