package com.example.helloworld.DesignPatterns.Creational.Prototype;

import java.util.Arrays;

class Address implements Cloneable {
    public String streetNumber;
    public int houseNumber;

    public Address(String streetNumber, int houseNumber) {
        this.streetNumber = streetNumber;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNumber='" + streetNumber + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
    // deep copy
    @Override
    public Address clone() {
        return new Address(streetNumber,houseNumber);
    }
}
class Person implements Cloneable {
    public String[] names;
    public Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", address=" + address +
                '}';
    }

    @Override
    public Object clone() {
        return new Person(
                names.clone(),
                (Address) address.clone()
        );
    }
}
public class Prototype {
    public static void main(String[] args) {
        Person suhail = new Person(new String[]{"Suhail","Akhtar", "Hello"},
                new Address("Nihal Vihar", 240));
        System.out.println(suhail);
        Person p2 = (Person) suhail.clone();
        p2.address.streetNumber = "def";
        p2.names[0]="abrakadabra";
        System.out.println(suhail);
        System.out.println(p2);
        Address a1 = new Address("abc", 123);
        System.out.println("before = " + a1);
        Address a2 = a1.clone();
        a2.houseNumber = 4;
        a2.streetNumber = "def";
        System.out.println(a1);
        System.out.println(a2);
    }
}
