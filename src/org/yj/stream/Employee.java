package org.yj.stream;


public class Employee implements Comparable<Employee> {

    private String name;
    private int age;
    private float salary;
    private Gender gender;



    public Employee() {
    }

    public Employee(String name, int age,Gender gender, float salary) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public  void modify(Employee employee)
    {
        employee.setName("Peter");
    }
    public  void modify(String name)
    {
        name="Peter";
    }
    public static void main(String[] args) {
        Employee employee = new Employee();

        employee.setName("Jian");
        employee.setAge(45);
        System.out.println(employee);
        employee.modify(employee);
        System.out.println(employee);

        String name="yinjian";
        System.out.println(name);
        employee.modify(name);
        System.out.println(name);
    }


}


