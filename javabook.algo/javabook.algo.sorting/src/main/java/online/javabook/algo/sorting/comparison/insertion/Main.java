package online.javabook.algo.sorting.comparison.insertion;

import online.javabook.algo.sorting.api.Sort;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{5, 4, 3, 2, 1};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(array);
    }
}
