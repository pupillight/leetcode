package org.yj.design.pattern.clone;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    //private ArrayList<Address> addressList= new ArrayList<>();
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person clone() {
        Person p = new Person();
        p.setName(this.getName());
        p.setAge(this.getAge());
        p.setAddress(this.getAddress());

        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Peter");
        person.setAge(30);
        Address address = new Address();
        address.setStreet("st1");
        address.setCountry("Canada");
        person.setAddress(address);

        Person p1 = person.clone();
        Person p2 = person.clone();
        System.out.println(person);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1 == person);
        System.out.println(p1 == p2);


        System.out.println("----------------");

        person.getAddress().setCountry("China");
        System.out.println(person);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1 == person);
        System.out.println(p1 == p2);
        System.out.println(p1.address == person.address);
        System.out.println(p1.address == p2.address);
       /* try {
            Person p = (Person) person.clone();
            System.out.println(p);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/
    }
}
