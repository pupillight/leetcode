package org.yj.stream;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Employee e1 = new Employee("Peter", 45, Gender.MALE, 12000.00f);
        Employee e2 = new Employee("Blair", 40, Gender.FEMALE, 10000.00f);
        Employee e3 = new Employee("Alex", 35, Gender.MALE, 9000.00f);
        Employee e4 = new Employee("Bob", 50, Gender.MALE, 15000.00f);

        List<Employee> g1 = List.of(e1, e2);
        List<Employee> g2 = List.of(e3, e4);


        List<Employee> employees = List.of(e1, e2, e3, e4);

        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toSet()))));


        System.out.println(employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary)));

        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.summingInt(Employee::getAge))));
        Map map = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(employee -> employee.getName(), Collectors.toSet())));
        System.out.println(map);

        Map map1 = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getSalary, Collectors.toList())));
        System.out.println(map1);
        //Map map=  employees.stream().collect(Collectors.partitioningBy(employee -> employee.getGender()==Gender.FEMALE));
        //System.out.println(map);
 /*       IntSummaryStatistics statistics = employees.stream().mapToInt(employee -> employee.getAge()).summaryStatistics();
        System.out.println(statistics);
        System.out.println(employees.stream().collect(Collectors.summarizingDouble(e -> e.getSalary())));
        System.out.println(employees.stream().mapToInt(employee -> employee.getAge()).reduce(0, (i, j) -> i + j));
        IntStream.range(0, employees.size()).filter(i -> i > 2).forEach(i -> System.out.println(employees.get(i)));
        Set<Employee> set = employees.stream().collect(Collectors.toCollection(HashSet::new));
        System.out.println(set);
*/

        //List<List<Employee>> list = List.of(g1, g2);
        //list.stream().flatMap(employeeList->employeeList.stream()).forEach(System.out::println);
        //list.stream().forEach(System.out::println);

        //list.stream().flatMap(item -> item.stream()).forEach(System.out::println);


        /// Map<String, List<Employee>> map =

        //Map<String, List<Employee>> map = g1.stream().collect(Collectors.groupingBy(employee -> employee.getGender().name()));


        //System.out.println(map);

        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> map2 = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map2);
        map2.entrySet().stream().sorted((a, b) -> (int) (a.getValue() - b.getValue())).forEach(System.out::println);


      /*  ExecutorService executor = Executors.newFixedThreadPool(1);
        Callable<Integer> callable = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("write file ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        };

        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("write file ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        //Future<Integer> future = executor.submit(runnable, 1);

        //Future<Integer> future = executor.submit(callable);

        //if (future.isDone())
         //  System.out.println(future.get());

        executor.shutdown();

       CompletableFuture<Void> future = CompletableFuture.runAsync(runnable);

       future.join();*/
        Runnable runnable=()->System.out.println(1111);
        CompletableFuture.runAsync(runnable).thenRun(()->System.out.println(222222));
    }
}
