package online.javabook.jdk.java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello world", "java and spring");
        List<String> words = strings.stream()
                .map(str -> str.split(" "))
                .flatMap((strs) -> Arrays.stream(strs))
                .collect(Collectors.toList());
        words.forEach(System.out::println);
    }
}
