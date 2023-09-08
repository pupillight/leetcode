package org.yj.lambda.stream.demo1;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStream
{
    public static void main(String[] args) {
        int[] array= new int[]{1,2,3,4,5};
//        IntStream.rangeClosed(9,10).forEach(System.out::println);
//        int[] array= {1,2,3,4,5};
        IntStream intStream =Arrays.stream(array);

        Stream<Integer> stream =intStream.boxed();


    IntSummaryStatistics statistics = stream.mapToInt(e->e).summaryStatistics();
        System.out.println(statistics);

        //String[] array =new String[]{"a","b","c"};

        //Stream<Integer> stream =Stream.of(1,2,3);

//        Boolean[] array =new Boolean[] {true,false,true};
//        Stream<Boolean> stream =Stream.of(array);
//        stream.forEach(System.out::println);

        //Stream.generate(()-> new Random().nextInt(10)).limit(10).forEach(System.out::println);
        //Stream.iterate(10,e->e+1 ).limit(10).forEach(System.out::println);
    }
}
