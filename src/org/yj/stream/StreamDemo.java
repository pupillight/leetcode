package org.yj.stream;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        Employee e1 = new Employee("Peter", 45, Gender.MALE, 12000.00f);
        Employee e2 = new Employee("Blair", 40, Gender.FEMALE, 10000.00f);
        Employee e3 = new Employee("Alex", 35, Gender.MALE, 9000.00f);
        Employee e4 = new Employee("Bob", 50, Gender.MALE, 15000.00f);

        List<Employee> g1 = List.of(e1, e2);
        List<Employee> g2 = List.of(e3, e4);
        List<List<Employee>> list = List.of(g1, g2);
        //list.stream().flatMap(employeeList->employeeList.stream()).forEach(System.out::println);
        //list.stream().forEach(System.out::println);



/*


        Stream<Employee> stream = sBuilder.build();
        List<Employee> list = stream.filter(employee -> employee.getAge() > 40).collect(Collectors.toList());*/
/*        DoubleSummaryStatistics statistics = list.stream().collect(Collectors.summarizingDouble(employee -> employee.getSalary()));
        System.out.println(statistics.getMax());*/

        /*        System.out.println(list.stream().mapToDouble(employee -> employee.getSalary()).sum());*/

       /* Map<Gender, String> map = stream.
                collect(Collectors.groupingBy(employee -> employee.getGender(),
                        Collectors.mapping(employee -> employee.getName(), Collectors.joining("-"))));
        map.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println(map);*/
    }
}
