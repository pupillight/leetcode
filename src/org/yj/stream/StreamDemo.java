package org.yj.stream;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

 /*       String[] words= {"apple", "banana", "apple", "orange", "banana", "apple"};

        System.out.println(Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));


        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 1);

        System.out.println(numbers.stream().distinct().sorted((l1, l2) -> l2 - l1).collect(Collectors.toList()));
        System.out.println(numbers.stream().distinct().sorted(Comparator.comparingInt(Integer::intValue).reversed()).collect(Collectors.toList()));

        List<String> list = Arrays.asList("apple", "banana", "orange", "kiwi", "strawberry");

        System.out.println(list.stream().reduce("", (s1, s2) -> {
            if (s1.length() >= s2.length()) {
                return s1;
            }
            return s2;
        }));
        System.out.println(list.stream().max(Comparator.comparingInt(item -> item.length())).get());

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4, 5);

        System.out.println(Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList()));
        List<String> list = Arrays.asList("Hello", " ", "world", "!");
        System.out.println(list.stream().collect(Collectors.joining("-")));*/

/*        List<String> list = Arrays.asList("apple", "banana", "orange", "kiwi");
        char specificChar = 'a';

        list.stream().filter(item->!item.contains(String.valueOf(specificChar))).collect(Collectors.toList());*/

/*        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println(numbers.stream().collect(Collectors.partitioningBy(item -> item % 2 == 0)));*/

/*        List<Integer> list = Arrays.asList(1, 12, 44, 32, 52, 81, 59, 84, 72, 37);

        int k = 4;
        System.out.println(list.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).collect(Collectors.toList()));
        System.out.println(list.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).skip(k - 1).findFirst().get());*/


        List<String> list = List.of("level", "hello", "radar", "world", "madam", "java", "Malayalam");

        Predicate<String> predicate = str -> {

            StringBuilder builder = new StringBuilder(str);
            return builder.reverse().toString().equalsIgnoreCase(str);

        };
        System.out.println(list.stream().filter(predicate).sorted(Comparator.comparingInt(String::length).reversed()).findFirst());

    }
}
