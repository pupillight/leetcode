package org.yj.stream;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    List<List<Employee>> list = new ArrayList<>();
    List<Employee> employees1 = new ArrayList<>();
    List<Employee> employees2 = new ArrayList<>();

    public void init() {
        Employee employee1 = new Employee("zhangsan", 29, Gender.MALE, 9000.53f);
        Employee employee2 = new Employee("lisi", 45, Gender.FEMALE.MALE, 10000.00f);
        Employee employee3 = new Employee("zhaoliu", 31, Gender.FEMALE.MALE, 12000);
        Employee employee4 = new Employee("tianqi", 20, Gender.MALE, 7000.50f);

        employees1.add(employee1);
        employees1.add(employee2);
        list.add(employees1);

        employees2.add(employee3);
        employees2.add(employee4);
        list.add(employees2);
    }

    public void execute() {
        init();
        //employees1.stream().filter(e -> e.getAge()<=20).forEach(e->System.out.println(e));
       // employees1.stream().filter(e -> e.getAge() > 20).forEach(System.out::println);
        //String str = "hello world";

        list.stream().flatMap(employeeList -> employeeList.stream()).collect(Collectors.toList()).forEach(System.out::println);

        list.stream().flatMapToInt(employeeList -> employeeList.stream().mapToInt(e->e.getAge())).forEach(System.out::println);
    }

    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();

        //streamTest.init();
        streamTest.execute();



    /*
        Employee employee1 = new Employee("zhangsan", 29, "male", 9000.53f);
        Employee employee2 = new Employee("lisi", 45, "female", 10000.00f);
        Employee employee3 = new Employee("zhaoliu", 31, "female", 12000);
        Employee employee4 = new Employee("tianqi", 20, "male", 7000.50f);
        *//*List<Employee> employees =List.of(employee1,employee2,employee3,employee4);
        Stream.of(employees).;*//*
        Stream<Employee> stream = Stream.of(employee1, employee2, employee3, employee4);

        String[] names =stream.map(employee -> employee.getName()).toArray(size->new String[size]);*/







//        stream.collect(Collectors.toMap(employee -> employee.getName(),employee -> employee.getSalary()))
//                .forEach((k,v)->System.out.println(k+"="+v));
        //Map<String,List<Employee>> map=stream.collect(Collectors.groupingBy(employee -> employee.getGender()));

        //IntSummaryStatistics stats = stream.collect(Collectors.summarizingInt(e->e.getAge()));
/*
        Map<String, List<Employee>> map1 = stream.collect(Collectors.groupingBy(employee -> employee.getGender()));
        System.out.println(map1);

        Map<String, DoubleSummaryStatistics> map2 = stream.collect(Collectors.
        groupingBy(employee -> employee.getGender(), Collectors.summarizingDouble(e -> e.getSalary())));
        System.out.println(map2);*/

//        Map<String, Double> map3 = stream.collect(Collectors.groupingBy(employee -> employee.getGender(), Collectors.averagingDouble(e -> e.getAge())));
//        System.out.println(map3);

       // System.out.println(stream.mapToInt(employee -> employee.getAge()).reduce(0, (n1, n2) -> Integer.max(n1, n2)));


/*        IntSummaryStatistics stats = stream.mapToInt(employee -> employee.getAge()).summaryStatistics();
        System.out.println(stats.getAverage());

        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());
        System.out.println(stats.getCount());*/

        //System.out.println(stream.map(employee -> employee.getAge()).reduce(0, (n1, n2) ->Math.max(n1,n2)));


        // Map<String,List<Employee>> map =stream.collect(Collectors.groupingBy(e->e.getGender()));
        //Map<String, Double> map = stream.collect(Collectors.groupingBy(e -> e.getGender(), Collectors.averagingDouble(e -> e.getAge())));
        //map.forEach((k, v) -> System.out.println(k + ":" + v));
        //System.out.println(stream.mapToDouble(employee -> employee.getSalary()).reduce(0.0, Double::sum));
//38001.0302734375
        // System.out.println(stream.map(employee -> employee.getName()).collect(Collectors.joining("-")));

        //DoubleSummaryStatistics stats = stream.collect(Collectors.summarizingDouble(Employee::getSalary));
        //System.out.println(stats.getSum());


        //stream.collect(Collectors.groupingBy(e -> new Character(e.))
//        streamTest.init();
//        streamTest.list.stream().
//                map(employeeList -> employeeList.size()).forEach(System.out::println);
//
//
//        streamTest.list.stream().
//                flatMap(employeeList -> employeeList.stream()).forEach(System.out::println);
        //        .toArray(size->new String[size]))
        //.forEach(System.out::println);
        //flatMap(employeeList -> employeeList.stream()).forEach(System.out::println);

        // .map(employee -> employee.getName())
        //.toArray(size->new String[size]);



/*

        String text = "Perter ,Alex ,Bob,Eric";
        String[] names =Stream.of(text.split(",")).map(name -> name.trim().toUpperCase()).toArray(size -> new String[size]);
*/



        //nums.stream().peek(e -> System.out.println(e)).map(e -> e * 2).forEach(System.out::println);

/*
        System.out.println( nums.stream().allMatch(num->num%2==0));
        System.out.println(nums.stream().anyMatch(n -> n % 2 == 0));
        System.out.println(nums.stream().noneMatch(n -> n % 3 == 0));*/
    }


}
