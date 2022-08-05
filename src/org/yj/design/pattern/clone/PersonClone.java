package org.yj.design.pattern.clone;


import java.io.*;

public class PersonClone implements Cloneable,Serializable {
    private String name;
    private int age;
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

    @Override
    public String toString() {
        return "PersonClone{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    @Override
    protected PersonClone clone() throws CloneNotSupportedException {
        return (PersonClone) super.clone();
    }

    protected PersonClone cloneInDepth() throws IOException, ClassNotFoundException {

        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        ObjectOutputStream objOutStream = new ObjectOutputStream(byteOutStream);
        objOutStream.writeObject(this);

        ByteArrayInputStream byteInStream = new ByteArrayInputStream(byteOutStream.toByteArray());
        ObjectInputStream objectInStream = new ObjectInputStream(byteInStream);

        return (PersonClone) objectInStream.readObject();
    }

    public static void main(String[] args) {
        PersonClone person = new PersonClone();
        person.setAge(40);

        person.setName("Alice");
        Address address = new Address();
        address.setStreet("st1");
        address.setCountry("Canada");
        person.setAddress(address);
        try {
            PersonClone p1 = person.cloneInDepth();
            System.out.println(person);
            person.setName("yj");
            person.getAddress().setCountry("China");
            System.out.println(person);
            System.out.println(p1);
            System.out.println(person == p1);
            System.out.println(person.address == p1.address);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
