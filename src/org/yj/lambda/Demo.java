package org.yj.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Demo {

/*    public void filterEmployees(List<Employee> employees,Filter<Employee> filter){
        for(Employee e:employees){
            if(filter.test(e)){
                System.out.println(e);
            }
        }
    }*/

    public void filterEmployees(List<Employee> employees, Function<Employee,Employee> function ){
        for(Employee e:employees){
            function.apply(e);
        }
    }

/*    public void filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
        for (Employee e : employees) {
            if (predicate.test(e)) {
                System.out.println(e);
            }
        }
    }*/

    public static void main(String[] args) {
        Employee employee1 = new Employee("zhangsan", 29, 9000.53f);
        Employee employee2 = new Employee("lisi", 45, 10000.00f);
        Employee employee3 = new Employee("zhaoliu", 31, 12000);
        Employee employee4 = new Employee("tianqi", 20, 7000.50f);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);


        //Collections.sort(employees);

/*        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary()-o2.getSalary());
            }
        });*/

/*        Collections.sort(employees, (e1, e2) -> e1.getAge() - e2.getAge());
        System.out.println(employees);*/

        Demo demo = new Demo();
        demo.filterEmployees(employees,e->{
            if(e.getName().equals("tianqi")){
                e.setName("tianqi2");
            }
            return e;
        });

        System.out.println(employees);

       // Thread thread = new Thread(()->System.out.println("--------"));
        //thread.start();

    }

}
