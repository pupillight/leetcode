package org.yj.application.data.design.pattern;

import org.yj.application.data.design.pattern.observer.ObserverA;
import org.yj.application.data.design.pattern.observer.ObserverB;
import org.yj.application.data.design.pattern.observer.Subject;
import org.yj.application.data.design.pattern.singleton.Singleton;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tester {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
/*        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Callable<Singleton> callable = () -> {
                Singleton singleton = Singleton.getInstance();
                return singleton;
            };
            Singleton instance = service.submit(callable).get();
            System.out.println(instance);
        }

        service.shutdown();*/


/*        Subject subject = new Subject();
        subject.addObserver(new ObserverA());
        subject.addObserver(new ObserverB());
        subject.notice();*/


        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));
        // List<String> words =   Arrays.asList("Jeff", "Bezos").stream().flatMap(word-> Arrays.stream(word.split(""))).collect(Collectors.toList());
        //List<String> words =     Arrays.asList("Jeff", "Bezos").stream().flatMap(word-> Stream.of(word.split(""))).collect(Collectors.toList());
        //System.out.println(words);
        //List<String> res=  namesNested.stream().flatMap(item->item.stream()).collect(Collectors.toList());
        List<String> res = namesNested.stream().flatMap(Collection::stream).collect(Collectors.toList());
        namesNested.stream().flatMapToInt(item -> IntStream.of(item.size())).forEach(System.out::println);
        System.out.println(res);
        Stream<String> strings = Stream.of("1,2,3", "4,5");
        strings.flatMap(str -> Arrays.stream(str.split(","))).mapToInt(it -> Integer.parseInt(it)).boxed().collect(Collectors.toList());//.forEach(System.out::println);
        // IntStream intStream =
        //IntStream intStream = strings.flatMapToInt(str-> Arrays.stream(str.split(",")).mapToInt(Integer::parseInt));
        //intStream.forEach(System.out::println);

    }
}
