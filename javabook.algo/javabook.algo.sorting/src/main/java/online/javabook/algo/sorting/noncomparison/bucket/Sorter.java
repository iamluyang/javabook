package online.javabook.algo.sorting.noncomparison.bucket;

import java.util.List;

public interface Sorter<T> {

    List<T> sort(List<T> arrayToSort);
}
