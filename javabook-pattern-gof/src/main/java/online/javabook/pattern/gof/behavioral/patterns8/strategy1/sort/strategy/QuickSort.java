package online.javabook.pattern.gof.behavioral.patterns8.strategy1.sort.strategy;

import java.util.Arrays;
import java.util.List;

public class QuickSort implements ISortStrategy {
    @Override
    public Integer[] Sort(List<Integer> results) {
        System.out.println("Quick sort results");

        Integer[] array = new Integer[results.size()];
        array = results.toArray(array);
        Arrays.sort(array);
        return array;
    }
}
