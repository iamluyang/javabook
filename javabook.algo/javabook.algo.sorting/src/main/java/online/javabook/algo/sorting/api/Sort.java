package online.javabook.algo.sorting.api;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Sort<T extends Comparable<T>> {

    protected AtomicInteger comparisons = new AtomicInteger();

    protected AtomicInteger swaps = new AtomicInteger();

    /**
     *
     * @param array
     */
    public void sortAsc(T[] array) {
        comparisons.set(0);
        swaps.set(0);
        abstSortAsc(array);
    }

    /**
     *
     * @param array
     */
    protected abstract void abstSortAsc(T[] array);

    /**
     * @param array
     * @param aIndex
     * @param bIndex
     * @return
     */
    protected int compare(T[] array, int aIndex, int bIndex) {
        comparisons.incrementAndGet();
        return array[aIndex].compareTo(array[bIndex]);
    }

    /**
     * @param array
     * @param aIndex
     * @param bIndex
     */
    protected void swap(T[] array, int aIndex, int bIndex) {
        T aObject = array[aIndex];
        array[aIndex] = array[bIndex];
        array[bIndex] = aObject;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "comparisons=" + comparisons +
                ", swaps=" + swaps +
                '}';
    }

    /**
     *
     * @param array
     */
    public void printArray(T[] array) {
        for (Comparable comparable : array) {
            System.out.print("[" + comparable + "]");
            System.out.print("\t");
        }
        System.out.println();
    }

    /**
     * @param array
     * @param aIndex
     * @param bIndex
     */
    protected void printBubbleSort(T[] array, int aIndex, int bIndex) {
        swaps.incrementAndGet();

        printTab(aIndex);
        System.out.println("  \\ /");
        printTab(aIndex);
        System.out.println("  c&s");
        printTab(aIndex);
        System.out.println("  / \\");

        printArray(array);
    }

    /**
     * @param array
     * @param aIndex
     * @param bIndex
     */
    protected void printSelectionSort(T[] array, int aIndex, int bIndex) {
        swaps.incrementAndGet();

        printTab(aIndex);
        System.out.print(" ^\t");
        printTab(bIndex - aIndex - 1);
        System.out.print(" ^\t");
        System.out.println("");
        printArray(array);
    }

    /**
     *
     * @param array
     * @param aIndex
     * @param bIndex
     */
    protected void printInsertionSort(T[] array, int aIndex, int bIndex) {
        comparisons.incrementAndGet();

        printTab(aIndex + 1);
        System.out.print("     ^");
        printTab(aIndex + 1);
        System.out.println();
        printArray(array);
    }

    /**
     * @param count
     */
    private void printTab(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("\t");
        }
    }
}
