package online.javabook.algo.sorting.comparison.insertion;

import online.javabook.algo.sorting.api.Sort;

/**
 * -----------------------------------------------------------------
 * 算法概况
 * 算法类别  排序算法
 * 数据结构  数组
 *
 * 时间复杂度
 * 平均时间复杂度	O(n^{2})
 * 最坏时间复杂度	O(n^{2})
 * 最优时间复杂度	O(n)
 *
 * 空间复杂度     总共O(n)，需要辅助空间O(1)
 * 最佳解	No
 * -----------------------------------------------------------------
 */
public class InsertionSort extends Sort {

    @Override
    protected void abstSortAsc(Comparable[] array) {
        // 数组长度
        int length = array.length;

        // 外层循环用于确定等待插入的数据项
        for (int i = 1; i < length; ++i) {

            System.out.println("第[" + i + "]轮插入");
            printArray(array);

            Comparable indexElement = array[i];

            int j = i - 1;
            while (j >= 0) {
                Comparable replaceElement = array[j];
                if (indexElement.compareTo(replaceElement) < 0) {
                    array[j + 1] = replaceElement;
                    j--;
                } else {
                    break;
                }
                printInsertionSort(array, j, i);
            }

            array[j + 1] = indexElement;
            swaps.incrementAndGet();
            printArray(array);
        }
    }
}
