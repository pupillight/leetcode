package org.yj.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    List<List<Employee>> list = new ArrayList<>();
    List<Employee> employees1 = new ArrayList<>();
    List<Employee> employees2 = new ArrayList<>();

    public void init() {
        Employee employee1 = new Employee("zhangsan", 29, 9000.53f);
        Employee employee2 = new Employee("lisi", 45, 10000.00f);
        Employee employee3 = new Employee("zhaoliu", 31, 12000);
        Employee employee4 = new Employee("tianqi", 20, 7000.50f);

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
        employees1.stream().filter(e -> e.getAge() > 20).forEach(System.out::println);

        //employees.stream().sorted((e1, e2) -> e1.getAge() - e2.getAge()).forEach(System.out::println);
        //System.out.println(employees.stream().max((e1, e2) -> e1.getAge() - e2.getAge()).get());
        //System.out.println(employees.stream()..count());

      /*  Stream<Float> stream= employees.stream().map(e->e.getSalary());//.forEach(System.out::println);
        stream.forEach(System.out::println);

        employees.stream().map(employee -> employee.getAge()).forEach(e-> System.out.println(e));
*/

        //employees.stream().mapToInt(e-> e.getAge()).forEach(System.out::println);
        //employees.stream().flatMap(employee -> employees.stream()).forEach(System.out::println);
        // employees1.stream().map(employee -> employee.getAge()).forEach(e-> System.out.println(e));

/*
        String[] words={"hello","world"};
        Arrays.stream(words).forEach(word->System.out.println(word));
        Arrays.stream(words).map(word->word).forEach(System.out::println);
        Arrays.stream(words).map(word->word.split("")).flatMap(Arrays::stream ).forEach(System.out::println);
*/
        //employees1.stream().forEach(System.out::println);
        //list.stream().flatMap(list -> list.stream()).map(employee -> employee.getAge()).forEach(System.out::println);

        String str = "hello world";
/*

      List<String> words=  Arrays.stream(str.split("")).collect(Collectors.toList());

      words.stream().filter(word -> word.trim().length() !=0).forEach(System.out::println);
      System.out.println(words);
*/


        Arrays.stream(str.split(" ")).
                forEach(word->System.out.println(word));

        Arrays.stream(str.split(" ")).map(word->word.split(" ")).forEach(chars->System.out.println(chars));
        Arrays.stream(str.split(" "))
                .map(word->word.split(""))
                .map(letters->Arrays.stream(letters))
                .forEach(stream->stream.forEach(System.out::println));

        System.out.println("--------");
        List<String> letters = Arrays.stream(str.split(" ")).flatMap(word -> Arrays.stream(word.split(""))).collect(Collectors.toList());
        letters.stream().forEach(letter -> System.out.println(letter));

    }

    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();
        streamTest.execute();
    }


}
