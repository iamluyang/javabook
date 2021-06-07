package online.javabook.gof.behavioral.patterns8.strategy1.sort.strategy;

import java.util.Arrays;
import java.util.List;

public class ParallelSort implements ISortStrategy {
    @Override
    public Integer[] Sort(List<Integer> results) {
        System.out.println("Parallel sort results");

        Integer[] array = new Integer[results.size()];
        array = results.toArray(array);
        Arrays.parallelSort(array);
        return array;
    }
}
