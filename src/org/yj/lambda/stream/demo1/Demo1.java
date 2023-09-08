package org.yj.lambda.stream.demo1;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@FunctionalInterface
interface Printable {
    void print(String s);
}

class Printer {
    void printLine(String s) {
        System.out.println(s);
    }
}

public class Demo1 {


    public static void main(String[] args) {

 /*       print(new Printable() {
            @Override
            public void print(String s) {
                System.out.println(s);
            }
        });*/
        //print("hello", s-> System.out.println(s));
        //Printer printer = new Printer();
        //print("Jian",new Printer()::printLine);
        //print("!",System.out::println);

        Employee[] employees = {
                new Employee("Alexandru", "alexandru@gmail.com", 20),
                new Employee("Emanuela", "ema@gmail.com", 20),
                new Employee("George", "george@gmail.com", 32),
                new Employee("John", "john123@gmail.com", 45),
                new Employee("Liam", "liam123@gmail.com", 45),
                new Employee("Noah", "noah@outlook.com", 30),
                new Employee("Oliver", "oliver@yahoo.com", 30)
        };


        // Arrays.stream(employees).sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName)).forEach(System.out::println);
        // Optional<Employee> res =Arrays.stream(employees).max(Comparator.comparing(Employee::getAge));
        // System.out.println(res.orElse(null));
        //Comparator<Employee> comparator =Comparator.comparing(emp->emp.getAge());
        //  System.out.println(Arrays.stream(employees).max(comparator));

      /*  Arrays.stream(employees)
                .filter(employee -> employee.getEmail().endsWith("@gmail.com"))
                .peek(employee -> System.out.println("filter1:"+employee))
                .filter(employee -> employee.getAge()>40)
                .peek(employee -> System.out.println("filter2:"+employee))
                .sorted(Comparator.comparing(employee->employee.getName()))
                .collect(Collectors.toList());*/

/*      Map<String ,List<Employee>> map =Arrays.stream(employees).collect(Collectors.groupingBy(Employee::getEmail));

      map.entrySet().stream().forEach(System.out::println);*/

    /*    IntStream stream = IntStream.range(0, employees.length);

        List<Employee> list = stream.filter(i -> i % 2 == 0).mapToObj(i -> employees[i]).collect(Collectors.toList());

        list.forEach(System.out::println);*/

        int res = Stream.of(1, 2, 3, 4, 5).reduce(0, (a, b) -> {
            System.out.println(a);
            System.out.println(b);
            System.out.println("--------");
            return b;
        });

      /* Optional<Integer> res =Stream.of(1, 2, 3, 4, 5).reduce(0,(a,b)->a+b).reduce((a,b)->{
           System.out.println(a);
           System.out.println(b);
           System.out.println("--------");
           return  b;
        });*/
        System.out.println(res);

        ArrayList<Integer> numbersList
                = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
        Map<Integer, Long> elementCountMap = Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8).stream().collect(Collectors.toMap(Function.identity(),v->1l, Long::sum));
       /* Map<Integer, Long> elementCountMap = numbersList.stream()
                .collect(Collectors.toMap(Function.identity(), v -> 1l, Long::sum));*/

        System.out.println(elementCountMap);
    }

    public static void print(String s, Printable printable) {
        printable.print(s);
    }

}

