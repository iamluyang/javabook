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
 * [1]	[2]	[3]	[4]	[5]
 * Sort{comparisons=4, swaps=0}
 * -----------------------------------------------------------------
 */
public class OptimizBubbleSort extends Sort {

    @Override
    protected void abstSortAsc(Comparable[] array) {
        int length = array.length;

        // 外部循环表示要要执行多少轮冒泡算法
        for (int i = 0; i < length - 1; i++) {

            System.out.println("第[" + (i + 1) + "]轮冒泡");
            printArray(array);

            // 内部循环指定执行每一轮冒泡算法的数据区间
            boolean swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                int compare = compare(array, j, j + 1);

                if (compare > 0) {
                    swap(array, j, j + 1);
                    swapped = true;

                    printBubbleSort(array, j, j + 1);
                }
            }

            // 如果这一轮冒泡没有出现任何一次交换，说明当前这一轮的数据已经处于有序状态
            if (!swapped) {
                break;
            }
        }
    }
}
