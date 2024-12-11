package org.yj.lambda.stream.demo1;

import org.yj.application.data.design.pattern.strategy.Sorter;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Employee implements Comparable<Employee> {
    private String name;
    private String email;
    private int age;

    public Employee() {

    }

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Employee(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return (o.getAge() - this.getAge());
    }

    public int compareByName(Employee e) {
        return this.getName().compareTo(e.getName());
    }

    public int compareByName(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("yj", "yj@gmail.com", 47);
        Employee e2 = new Employee("liiuying", "liuying@gmail.com", 42);
        Employee e3 = new Employee("yzy", "yzy@gmail.com", 13);


        List<Employee> employees = new ArrayList<>();
        Collections.addAll(employees, e2, e1, e3);


        Employee[] arr = employees.stream().toArray(Employee[]::new);
        Arrays.stream(arr).sorted(Employee::compareByName).forEach(System.out::println);
        Arrays.stream(arr).sorted(Employee::compareByName).forEach(System.out::println);

        employees.stream().sorted(EmployeeComparator::compare).forEach(System.out::println);

        Supplier<Employee> supplier = () -> new Employee();
        System.out.println(supplier.get());

        BiFunction<String, String, Employee> biFunction = (name, email) -> new Employee(name, email);

        System.out.println(biFunction.apply("tt", "tt@gmail.com"));


       int[] ages= employees.stream().mapToInt(e -> e.getAge()).toArray();
        for (int age : ages) {
            System.out.println(age);
        }
    }


}

class EmployeeComparator {
    public static int compare(Employee e1, Employee e2) {
        return e1.getAge() - e2.getAge();
    }
}
