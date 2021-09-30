package online.javabook.algo.dsa.api.heap;

// Max-Heap data structure in Java

import java.util.ArrayList;

public class MaxHeap {

    private ArrayList<Integer> array = new ArrayList<>();

    /**
     * insert node
     * @param insertValue
     */
    public void insertNode(int insertValue) {
        int size = array.size();
        if (size == 0) {
            array.add(insertValue);
        } else {
            array.add(insertValue);
            // 向上堆化
            heapify(array.size() - 1, insertValue);
        }
    }

    /**
     * delete node
     * @param deleteValue
     */
    public void deleteNode(int deleteValue) {

        // 获取最后一个元素的索引位置和值
        int tailIndex = array.size() - 1;
        int tailValue = array.get(tailIndex);

        // 获取被删除节点的索引位置
        int deleteIndex = array.indexOf(deleteValue);
        if(deleteIndex != -1) {
            // 将最后一个元素移动到被删除元素的位置
            array.set(deleteIndex, tailValue);

            // 删除掉最后一个元素
            array.remove(tailIndex);

            // 如果存在元素则向上堆化
            if(array.size() != 0) {
                heapify(deleteIndex, tailValue);
            }
        }
    }

    /**
     *
     * heapify
     * @param insertIndex
     * @param insertValue
     */
    private void heapify(int insertIndex, int insertValue) {
        // 获取当前节点的父节点索引位置和父节点的值
        int parentIndex = (insertIndex - 1) / 2;
        int parentValue = array.get(parentIndex);

        // 如果当前节点比父节点大，则交换两个节点的位置，并继续向上重复这个操作
        if (insertValue > parentValue) {
            array.set(insertIndex, parentValue);
            array.set(parentIndex, insertValue);
            heapify(parentIndex, insertValue);
        }
    }

    /**
     *
     */
    public void printHeap() {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        MaxHeap heap = new MaxHeap();
        heap.insertNode(35);
        heap.insertNode(33);
        heap.insertNode(42);
        heap.insertNode(10);
        heap.insertNode(14);
        heap.insertNode(19);
        heap.insertNode(27);
        heap.insertNode(44);
        heap.insertNode(26);
        heap.insertNode(31);

        System.out.println("1.Create Max-Heap: ");
        heap.printHeap();

        heap.deleteNode(44);
        System.out.println("2.Delete Max-Heap-Top: ");
        heap.printHeap();
    }
}
