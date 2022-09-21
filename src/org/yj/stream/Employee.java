package org.yj.stream;

import java.security.IdentityScope;

public class Employee implements Comparable<Employee> {

    private String name;
    private int age;
    private float salary;
    private String gender;



    public Employee() {
    }

    public Employee(String name, int age,String gender, float salary) {
        this.name = name;
        this.age = age;
        this.gender= gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int compareTo(Employee employee) {
        return this.age-employee.age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                '}';
    }
}


