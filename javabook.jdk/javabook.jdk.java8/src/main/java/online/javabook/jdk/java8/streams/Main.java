package online.javabook.jdk.java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "", "d", "e", "f", "g");

        // filter
        List<String> filtered = strings.stream().filter((str) -> !str.isEmpty()).collect(Collectors.toList());

        // forEach
        filtered.forEach(System.out::println);

        // map
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> squaresList = numbers.stream().map( i -> i*i ).sorted(Comparator.comparingInt(a -> a)).collect(Collectors.toList());
        squaresList.forEach(System.out::println);

        // mapToInt
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(stats);

        // limit
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

    }
}
