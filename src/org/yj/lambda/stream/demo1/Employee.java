package org.yj.lambda.stream.demo1;

public class Employee {
    private String name;
    private String email;
    private int age;


    public Employee(String name, String email, int age) {

        super();
        System.out.println("111");
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
}
