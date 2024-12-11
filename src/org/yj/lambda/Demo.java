package org.yj.lambda;

import org.yj.stream.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

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

    public static void arr2List1(String[] names){

       List<String> list =Arrays.asList(names);
      // list.add("d");
        System.out.println(list.getClass().getName());
    }
    public static void arr2List2(String[] names){

        List<String> list = new ArrayList<>(Arrays.asList(names));
        list.add("d");
        System.out.println(list);
        System.out.println(list.getClass().getName());
    }
    public static void arr2List3(String[] names){

        List<String> list =List.of(names);
        //list.add("d");
        System.out.println(list);
        System.out.println(list.getClass().getName());
    }
    public static void arr2List4(String[] names){

        List<String> list = new ArrayList<>();
        Collections.addAll(list,names);
        list.add("d");
        System.out.println(list);
        System.out.println(list.getClass().getName());
        List<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "c","b");
        System.out.println(list1);
    }

    public static void  list2Arr1(List<Integer> list){
        System.out.println("list2Arr1");
       Object[] arr = list.toArray();
       Arrays.stream(arr).forEach(System.out::println);
    }
    public static void  list2Arr2(List<Integer> list){
        System.out.println("list2Arr2");
        Integer[] arr = list.toArray(new Integer[5]);
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static void  list2Arr3(List<Integer> list){
        System.out.println("list2Arr3");
        Integer[] arr = list.toArray(Integer[]::new);
       // Integer[] arr = (Integer[]) list.toArray(()->new Integer[0]);
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static void  list2Arr4(List<Integer> list){
        System.out.println("list2Arr4");
       //Integer[] arr = list.stream().toArray(Integer[]::new);
        Integer[] arr = list.stream().toArray(a->{
            System.out.println(a);
            return new Integer[a];
        });
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static void  list2Arr5(List<Integer> list){
        System.out.println("list2Arr5");
        //Integer[] arr = list.stream().toArray(Integer[]::new);
        Integer[] arr=list.stream().map(item->item.intValue()).toArray(Integer[]::new);//mapToInt(item->item.intValue()).toArray();
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static void  list2Arr6(List<Integer> list){
        System.out.println("list2Arr5");
        //Integer[] arr = list.stream().toArray(Integer[]::new);
        int[] arr=list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {

        String names[]={"a","b","c"};

        arr2List1(names);
        arr2List2(names);
        arr2List3(names);
        arr2List4(names);


        List list = List.of(3,5,1,8);
        list2Arr1(list);
        list2Arr2(list);
        list2Arr3(list);
        list2Arr4(list);
        list2Arr5(list);

    }

}
