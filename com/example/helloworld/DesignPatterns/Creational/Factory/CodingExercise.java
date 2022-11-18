package com.example.helloworld.DesignPatterns.Creational.Factory;

class Person
{
    public int id;
    public String name;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

class PersonFactory
{
    static int id = 0;
    public void getVal(){
        System.out.println("id = "+ id);
    }
    public Person createPerson(String name)
    {
        return new Person(id++,name);
    }
}

public class CodingExercise {
    public static void main(String[] args) {
        PersonFactory pf1 = new PersonFactory();
        Person person = pf1.createPerson("suhail");
        Person p2 = pf1.createPerson("Akhtar");
        pf1.getVal();
    }
}
