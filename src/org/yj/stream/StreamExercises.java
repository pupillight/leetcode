package org.yj.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExercises {

    class Item {
        private String name;
        private int qty;
        private BigDecimal price;


        public Item(String name, int qty, BigDecimal price) {
            this.name = name;
            this.qty = qty;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", qty=" + qty +
                    ", price=" + price +
                    '}';
        }
    }

    public void group() {
        Employee e1 = new Employee("John", 38);
        Employee e2 = new Employee("Tim", 33);
        Employee e3 = new Employee("Andrew", 33);
        Employee e4 = new Employee("Peter", 38);
        Employee e5 = new Employee("Nathan", 22);
        Employee e6 = new Employee("George", 23);
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);


        System.out.println(employees.stream().collect(Collectors.groupingBy(employee -> employee.getAge())));
        System.out.println(employees.stream().collect(Collectors.groupingBy(employee -> employee.getAge(), Collectors.mapping(employee -> employee.getName(), Collectors.toList()))));
        List<String> fruitNames = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        System.out.println(fruitNames.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));


        TreeMap<Integer, List<String>> treeMap = employees.stream().collect(Collectors.groupingBy(employee -> employee.getAge(), TreeMap::new, Collectors.mapping(employee -> employee.getName(), Collectors.toList())));

        System.out.println(treeMap);
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );


        System.out.println(items.stream().collect(Collectors.groupingBy(item -> new Tuple1(item.getName(), item.getQty()), Collectors.counting())));
       // System.out.println(items.stream().collect(Collectors.groupingBy(item -> item.getPrice(), Collectors.mapping(item -> item.getName(), Collectors.toSet()))));
        //System.out.println(items.stream().collect(Collectors.groupingBy(Item::getQty, Collectors.summingDouble(item -> item.getPrice().doubleValue()))));
    }

    public void calCounts() {
        List<String> colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");


        System.out.println(colors.stream().collect(Collectors.joining(",")));
        System.out.println(colors.stream().sorted((c1, c2) -> c1.compareTo(c2)).collect(Collectors.toList()));
        System.out.println(colors.stream().sorted(String::compareTo).collect(Collectors.toList()));
        System.out.println(colors.stream().sorted((c1, c2) -> c2.compareTo(c1)).collect(Collectors.toList()));
        System.out.println(colors.stream().sorted().collect(Collectors.toList()));
        System.out.println(colors.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        System.out.println(colors.stream().filter(color -> color.startsWith("B")).count());
        System.out.println(colors.stream().filter(word -> word.startsWith("B")).collect(Collectors.toList()).size());
    }

    public void calEvens() {
//        List<Integer> nums = List.of(1, 2, 6, 3);
//        System.out.println(nums.stream().reduce(0, (a, b) -> {
//            if ((b.intValue() & 1) == 0) {
//                return a + b;
//            }
//            return a;
//        }));
        //System.out.println(nums.stream().filter(num -> num % 2 != 0).mapToInt(num -> num).sum());
        //System.out.println(nums.stream().filter(num -> num % 2 == 0).mapToInt(num -> num).sum());

        List<Integer> nums = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);

        System.out.println(nums.stream().sorted().skip(1).findFirst().orElse(-1));
        System.out.println(nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1));
        System.out.println(nums.stream().mapToInt(Integer::intValue).max().getAsInt());
        System.out.println(nums.stream().mapToInt(Integer::intValue).min().getAsInt());
        System.out.println(nums.stream().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList()));
        System.out.println(nums.stream().distinct().collect(Collectors.toList()));
        System.out.println(nums.stream().distinct().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList()));
        System.out.println(nums.stream().distinct().sorted((e1, e2) -> e2 - e1).collect(Collectors.toList()));
    }

    public void average() {
        List<Integer> list = new ArrayList<>();
        List<Integer> nums = List.of(1, 2, 3);
        System.out.println(nums.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0));
        System.out.println(nums.stream().collect(Collectors.averagingDouble(num -> num.doubleValue())).doubleValue());
    }

    public void toUppercase() {
        List<String> nums = List.of("a", "b", "a");
        System.out.println(nums.stream().map(s -> s.toUpperCase()).collect(Collectors.toList()));
    }

    public void flat() {
        /*List<List<String>>  list=Arrays.asList(
        Arrays.asList("Java","c++"),
        Arrays.asList("Geeks", "For"),
        Arrays.asList("GeeksForGeeks", "A computer portal"));
        System.out.println(list.stream().flatMap(s -> s.stream()).collect(Collectors.toList()));*/


       /* List<String> words = Arrays.asList("GeeksForGeeks", "A computer portal");
        System.out.println(words.stream().flatMap(word -> Arrays.stream(word.split(""))).filter(str->str.trim().length()>0).collect(Collectors.toList()));
        //System.out.println(list.stream().flatMap(s -> s.stream()).collect(Collectors.toList()));


        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11, 13);
        // Creating a list of odd numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
        // Creating a list of even numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> list =List.of(PrimeNumbers,OddNumbers,EvenNumbers);
        System.out.println(list.stream().flatMap(item -> item.stream()).collect(Collectors.toList()));*/


        String[] arr = {"Geeks", "for", "Geeks"};

        Arrays.stream(arr).forEach(System.out::println);

        System.out.println(Stream.of(arr).collect(Collectors.toList()));

        int[] nums = {1, 2, 3, 4, 5};

        System.out.println(IntStream.of(nums).max().getAsInt());

    }

    public static void main(String[] args) {
        StreamExercises instance = new StreamExercises();
        //instance.average();
        //instance.toUppercase();
        // instance.calEvens();

        //instance.calCounts();'

        instance.group();

        //instance.flat();
    }
}

class Tuple1 {
    private String name ;
    private Integer qty;

    public Tuple1(String name, Integer qty) {
        this.name = name;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                '}';
    }
}
