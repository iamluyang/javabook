package online.javabook.algo.dsa.api.queue;

/**
 * Priority Queue implementation in Java
 */

import java.util.ArrayList;

public class PriorityQueue {

    private ArrayList<Integer> array = new ArrayList<>(10);

    /**
     * Function to insert an element into the tree
     *
     * @param newNum
     */
    public void insertNode(int newNum) {
        int size = array.size();
        if (size == 0) {
            array.add(newNum);
        } else {
            array.add(newNum);
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(i);
            }
        }
    }

    /**
     * Function to delete an element from the tree
     *
     * @param num
     */
    public void deleteNode(int num) {
        int size = array.size();
        int i;
        for (i = 0; i < size; i++) {
            if (num == array.get(i)) {
                break;
            }
        }

        int temp = array.get(i);
        array.set(i, array.get(size - 1));
        array.set(size - 1, temp);

        array.remove(size - 1);
        for (int j = size / 2 - 1; j >= 0; j--) {
            heapify(j);
        }
    }

    /**
     * Function to heapify the tree
     *
     * @param i
     */
    private void heapify(int i) {
        int size = array.size();

        // Find the largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && array.get(l) > array.get(largest)) {
            largest = l;
        }

        if (r < size && array.get(r) > array.get(largest)) {
            largest = r;
        }

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            int temp = array.get(largest);
            array.set(largest, array.get(i));
            array.set(i, temp);

            heapify(largest);
        }
    }

    /**
     * Print the tree
     */
    public void print() {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {

        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insertNode(3);
        priorityQueue.insertNode(4);
        priorityQueue.insertNode(9);
        priorityQueue.insertNode(5);
        priorityQueue.insertNode(2);

        System.out.println("添加元素后的最大堆: ");
        priorityQueue.print();

        priorityQueue.deleteNode(4);
        System.out.println("删除元素后的最大堆: ");
        priorityQueue.print();
    }
}
