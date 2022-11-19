package com.example.helloworld.DesignPatterns.Creational.Prototype;

import java.util.Arrays;

class AddressUsingClone implements Cloneable {
    public String streetNumber;
    public int houseNumber;

    public AddressUsingClone(String streetNumber, int houseNumber) {
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
    public AddressUsingClone clone() {
        return new AddressUsingClone(streetNumber,houseNumber);
    }
}
class PersonUsingClone implements Cloneable {
    public String[] names;
    public AddressUsingClone addressUsingClone;

    public PersonUsingClone(String[] names, AddressUsingClone addressUsingClone) {
        this.names = names;
        this.addressUsingClone = addressUsingClone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + Arrays.toString(names) +
                ", address=" + addressUsingClone +
                '}';
    }

    @Override
    public Object clone() {
        return new PersonUsingClone(
                names.clone(),
                (AddressUsingClone) addressUsingClone.clone()
        );
    }
}
public class Prototype {
    public static void main(String[] args) {
        PersonUsingClone suhail = new PersonUsingClone(new String[]{"Suhail","Akhtar", "Hello"},
                new AddressUsingClone("Nihal Vihar", 240));
        System.out.println(suhail);
        PersonUsingClone p2 = (PersonUsingClone) suhail.clone();
        p2.addressUsingClone.streetNumber = "def";
        p2.names[0]="abrakadabra";
        System.out.println(suhail);
        System.out.println(p2);
        AddressUsingClone a1 = new AddressUsingClone("abc", 123);
        System.out.println("before = " + a1);
        AddressUsingClone a2 = a1.clone();
        a2.houseNumber = 4;
        a2.streetNumber = "def";
        System.out.println(a1);
        System.out.println(a2);
    }
}
