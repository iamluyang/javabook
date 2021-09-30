package online.javabook.algo.sorting.noncomparison.bucket;

import online.javabook.algo.sorting.api.Sort;

/**
 * 类别	        排序算法
 * 数据结构	    数组
 * 平均时间复杂度	O(n+k)
 * 最坏时间复杂度	O(n^2)
 * 空间复杂度	    O(n*k)
 * 最佳解	    O(n)
 * -----------------------------------------------------------------
 * 步骤1：将数据分配到桶中
 * -----------------------------------------------------------------
 * 29     25      3    49     9       37      21      43
 * ________    ________    ________    ________    ________
 * /_______/|  /_______/|  /_______/|  /_______/|  /_______/|
 * | 3     ||  |       ||  | 29    ||  |       ||  | 49    ||
 * |  9    ||  |       ||  |   25  ||  |   37  ||  |   43  ||
 * |       ||  |       ||  | 21    ||  |       ||  |       ||
 * |_______|/  |_______|/  |_______|/  |_______|/  |_______|/
 * 0-9        10-19       20-29       30-39       40-49
 * -----------------------------------------------------------------
 * 步骤2：将桶里的数据排序
 * -----------------------------------------------------------------
 * ________    ________    ________    ________    ________
 * /_______/|  /_______/|  /_______/|  /_______/|  /_______/|
 * | 3     ||  |       ||  | 21    ||  |       ||  | 43    ||
 * |  9    ||  |       ||  |   25  ||  |   37  ||  |   49  ||
 * |       ||  |       ||  |     29||  |       ||  |       ||
 * |_______|/  |_______|/  |_______|/  |_______|/  |_______|/
 * 0-9        10-19       20-29       30-39       40-49
 * <p>
 * 39,                   21,25,29,    30,39,      40,49
 * -----------------------------------------------------------------
 */
public class IntegerKeysBucketSort extends Sort {

    @Override
    protected void abstSortAsc(Comparable[] array) {

    }
}
