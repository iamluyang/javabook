package online.javabook.algo.sorting.comparison.selection;

import online.javabook.algo.sorting.api.Sort;

public class Main {
    public static void main(String[] args) {

        Integer[] array1 = new Integer[]{5, 4, 3, 2, 1};
        Integer[] array2 = new Integer[]{5, 6, 7, 8, 9};
        Sort sort = new SelectionSort();

        sort.sortAsc(array1);
        sort.printArray(array1);
    }
}
