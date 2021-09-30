package online.javabook.algo.sorting.comparison.selection;

/**
 * 概况
 * 算法类别  排序算法
 * 数据结构  数组
 *
 * 时间复杂度
 * 平均时间复杂度	О(n²)
 * 最坏时间复杂度	О(n²)
 * 最优时间复杂度	О(n²)
 *
 * 空间复杂度
 * 总共О(n)，需要辅助空间O(1)
 *
 * 最佳解	偶尔出现
 * <p>
 * ---------------------------------------------------------------------------
 * Sorted sublist	     Unsorted sublist	    Least element in unsorted list
 * ---------------------------------------------------------------------------
 * ()	                 (5, 4, 3, 2, 1)	    1
 * (1)                   (5, 4, 3, 2)	        2
 * (1, 2)	             (5, 4, 3)	            3
 * (1, 2, 3)	         (5, 4)	                4
 * (1, 2, 3, 4)	         (5)	                5
 * (1, 2, 3, 4, 5)	     ()
 */

import online.javabook.algo.sorting.api.Sort;

public class SelectionSort extends Sort {

    @Override
    protected void abstSortAsc(Comparable[] array) {
        int length = array.length;

        // 需要n轮选择，每一轮在剩余数据中选出最小值
        for (int i = 0; i < length - 1; i++) {
            System.out.println("第[" + (i + 1) + "]轮选择");
            printArray(array);

            // 选出本轮的最小值索引
            int minJ = i;
            for (int j = i + 1; j < length; j++) {
                int comp = compare(array, minJ, j);
                if (comp > 0) {
                    minJ = j;
                }
            }

            // 交换此轮选择出的最大值和起始位置的数据
            if (minJ != i) {
                swap(array, i, minJ);
            }
            printSelectionSort(array, i, minJ);
        }
    }
}
