package online.javabook.design.gof.behavioral8.strategy1.sort.strategy;

import java.util.Arrays;
import java.util.List;

public class DefaultSort implements ISortStrategy {
    @Override
    public Integer[] Sort(List<Integer> results) {
        System.out.println("Quick sort results");

        Integer[] array = new Integer[results.size()];
        array = results.toArray(array);
        Arrays.sort(array);
        return array;
    }
}
