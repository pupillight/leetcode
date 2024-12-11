package org.yj.stream;

import java.math.BigDecimal;
import java.net.CookieManager;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {


    public void init() {
        Employee employee1 = new Employee("zhangsan", 29, Gender.MALE, 9000.53f);
        Employee employee2 = new Employee("lisi", 45, Gender.FEMALE.MALE, 10000.00f);
        Employee employee3 = new Employee("zhaoliu", 31, Gender.FEMALE.MALE, 12000);
        Employee employee4 = new Employee("tianqi", 20, Gender.MALE, 7000.50f);


    }

    public void execute() {
        init();
        //employees1.stream().filter(e -> e.getAge()<=20).forEach(e->System.out.println(e));
        // employees1.stream().filter(e -> e.getAge() > 20).forEach(System.out::println);
        //String str = "hello world";

        // list.stream().flatMap(employeeList -> employeeList.stream()).collect(Collectors.toList()).forEach(System.out::println);

<<<<<<< HEAD
        // list.stream().flatMapToInt(employeeList -> employeeList.stream().mapToInt(e->e.getAge())).forEach(System.out::println);
=======
        list.stream().flatMapToInt(employeeList -> employeeList.stream().mapToInt(e -> e.getAge())).forEach(System.out::println);
>>>>>>> 130e6cc (kkkk)
    }

    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();
        //streamTest.init();
        //streamTest.execute();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // System.out.println(list.stream().sorted().findFirst().get());

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 9, 10);

        list1.stream().filter(item->item>3).forEach(System.out::println);

        System.out.println(list1.stream().mapToInt(Integer::intValue).sum());
        System.out.println(list1.stream().collect(Collectors.summingInt(item -> item)));

<<<<<<< HEAD
        System.out.println(list1.stream().reduce( 0,(a, b) -> a + b));
        //System.out.println(list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList()));
        // System.out.println(list.stream().anyMatch(e->e<5));
        //list.stream().filter(item->item%2==0).collect(Collectors.toList()).forEach(System.out::println);

        // list.stream().map(item->item*item).collect(Collectors.toList()).forEach(System.out::println);
/*
        List<Integer> list2= new ArrayList<>();
        System.out.println(list.stream().reduce(0, (a, b) -> {

            list2.add(b*b);
            return b*b ;
        }));
        System.out.println(list2);*/


        // IntStream.range(0,5).forEach(item->System.out.println(list.get(item)));

        //List<String> fruits= Arrays.asList("kiwi","banana","apple","banana","grape",null);
        // System.out.println(fruits.stream().filter(Objects::nonNull).collect(Collectors.toList()));
        //System.out.println(fruits.stream().mapToInt(item -> item.length()).min().getAsInt());
        //System.out.println(fruits.stream().map(String::toUpperCase).distinct().sorted().collect(Collectors.toList()));
        Employee employee0 = new Employee("zhangsan", 29, Gender.MALE, 9000.53f);
        Employee employee1 = new Employee("zhangsan", 29, Gender.FEMALE, 9000.53f);
        Employee employee2 = new Employee("lisi", 45, Gender.FEMALE, 10000.00f);
        Employee employee3 = new Employee("zhaoliu", 31, Gender.MALE, 12000);
        Employee employee4 = new Employee("tianqi", 20, Gender.MALE, 7000.50f);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee0);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);


        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge))));
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList()))));

        Map<Integer,Integer> map = new HashMap();
        map.entrySet().stream().sorted((e1,e2)->e1.getValue() -e2.getValue()).collect(Collectors.toList());
        List<Map.Entry<Integer,Integer>> lista  = new ArrayList(map.entrySet());
        Collections.sort(lista, Map.Entry.comparingByValue());
        //Map map= employees.stream().collect(Collectors.groupingBy(employee -> employee.getGender(), HashMap<Gender,List<Employee>>::new ,Collectors.toList()));
/*        System.out.println(Stream.concat(Stream.of(employee0), Stream.of(employee1, employee2)).collect(Collectors.toList()));

        System.out.println(employees.stream().map(employee -> employee.getName()).collect(Collectors.toList()));
        System.out.println(employees.stream().collect(Collectors.toMap(employee -> employee.getName(), v -> 1, Integer::sum)));
        Map map = employees.stream().collect(Collectors.toMap(employee -> employee.getName(), employee -> employee.getGender(), (first, second) -> second));
        System.out.println(map);*/

        //System.out.println(employees.stream().collect(Collectors.groupingBy(employee -> employee.getGender(), Collectors.mapping(employee -> employee.getName(),Collectors.toList()))));
        //System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.toList())));
        //System.out.println(employees.stream().collect(Collectors.toMap(employee -> employee.getName(), employee -> employee.getAge())));
        //System.out.println(employees.stream().collect(Collectors.groupingBy(employee -> employee.getGender(), Collectors.maxBy((e1, e2) -> e1.getAge() - e2.getAge()))));
        //System.out.println(employees.stream().collect(Collectors.toMap(employee -> employee.getName(), employee -> employee.getAge())));
        //System.out.println(employees.stream().collect(Collectors.groupingBy(employee -> employee.getGender(),Collectors.toList())));
        // System.out.println(employees.stream().collect(Collectors.groupingBy(employee -> employee.getGender(), Collectors.mapping(employee -> employee.getName(), Collectors.toList()))));


        // System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(employee -> employee.getName(), Collectors.toList()))));
        //Map map = employees.stream().collect(Collectors.groupingBy(employee -> employee.getGender(), Collectors.averagingInt(employee->employee.getAge())));
        // Map map = employees.stream().collect(Collectors.groupingBy(employee -> employee.getGender(), Collectors.summarizingInt(employee->employee.getAge())));
        // System.out.println(map);

       /* List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
        Map<String, Long> map = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.entrySet().stream().sorted((e1,e2)-> (int) (e1.getValue() - e2.getValue())).forEach(System.out::println);*/
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("19.99"))
        );
=======
//        stream.collect(Collectors.toMap(employee -> employee.getName(),employee -> employee.getSalary()))
//                .forEach((k,v)->System.out.println(k+"="+v));
        //Map<String,List<Employee>> map=stream.collect(Collectors.groupingBy(employee -> employee.getGender()));
>>>>>>> 130e6cc (kkkk)


/*
        System.out.println(items.stream()
                .filter(item -> item.getQty() > 10)
                .peek(item -> System.out.println("filter1" + item))
                .filter(item -> item.getPrice().compareTo(BigDecimal.valueOf(10.00)) > 0)
                .peek(item -> System.out.println("filter2" + item))
                .collect(Collectors.toList()));
*/


<<<<<<< HEAD
       // System.out.println(items.stream().collect(Collectors.groupingBy(item -> item.getName(), Collectors.mapping(item -> item.getQty(), Collectors.toList()))));
      /* Map map1 =items.stream().collect(Collectors.toMap(item -> item.getName(), n -> 1, Integer::sum, TreeMap::new));
        System.out.println(map1);
=======
        // System.out.println(stream.mapToInt(employee -> employee.getAge()).reduce(0, (n1, n2) -> Integer.max(n1, n2)));
>>>>>>> 130e6cc (kkkk)

        System.out.println(items.stream().collect(Collectors.toMap(item -> item.getName(), n -> 1, Integer::sum)));
        System.out.println(items.stream().collect(Collectors.groupingBy(item -> item.getQty(), Collectors.counting())));
        Map res = items.stream().collect(Collectors.groupingBy(Item::getQty, TreeMap::new,Collectors.mapping(item -> item.getName(),Collectors.toList())));

        System.out.println(res);
        System.out.println(items.stream().collect(Collectors.groupingBy(item -> item.getName(), Collectors.maxBy(Comparator.comparing(Item::getPrice)))));*/
        //System.out.println(items.stream().collect(Collectors.groupingBy(item -> item.getName(), Collectors.summingInt(item -> item.getQty()))));
        // System.out.println(items.stream().collect(Collectors.groupingBy(item -> item.getName(), Collectors.summingDouble(item -> item.getPrice().doubleValue()))));
        // System.out.println(items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.mapping(item -> item.getPrice(), Collectors.toList()))));
        //System.out.println(items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(item->item.getQty()))));

        // System.out.println(items.stream().collect(Collectors.groupingBy(Item::getName,Collectors.toList())));
        //Map map=items.stream().collect(Collectors.groupingBy(Item::getPrice, TreeMap::new, Collectors.mapping(item -> item.getName(), Collectors.toList())));
        // System.out.println(map);
        //System.out.println();





/*        List<String> words =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        System.out.println(words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        System.out.println(words.stream().collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum)));
        //System.out.println(words.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum)));

        System.out.println(words.stream().reduce( (a, b) -> b).orElse(null));
        System.out.println(words.stream().collect(Collectors.joining("-")));*/

        List<String> words = Arrays.asList("hello", "world", "stream");
        ;
        Optional<String> str = words.stream().reduce((acc, word) ->{
            System.out.println(acc);
            System.out.println(word);
            System.out.println("-------");
            return  acc.isEmpty() ? word : acc + "," + word;
        });

<<<<<<< HEAD
/*        List<String> words =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
=======
        System.out.println(str.get());
>>>>>>> 130e6cc (kkkk)


        System.out.println(words.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
        System.out.println("------");*/
       // System.out.println(words.stream().flatMap(word -> Arrays.stream(word.split(""))).collect(Collectors.toList()));

       // System.out.println(words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
/*        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

<<<<<<< HEAD
        System.out.println(listOfLists.stream().flatMap(item -> item.stream()).mapToInt(item -> item).sum());

        System.out.println(Stream.iterate(0, n -> n + 1).skip(5).limit(10).collect(Collectors.toList()));
        System.out.println(Stream.generate(() -> 1).limit(10).collect(Collectors.toList()));*/
=======
        //nums.stream().peek(e -> System.out.println(e)).map(e -> e * 2).forEach(System.out::println);
>>>>>>> 130e6cc (kkkk)

    }

    static class Item {

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
//constructors, getter/setters
    }
}
