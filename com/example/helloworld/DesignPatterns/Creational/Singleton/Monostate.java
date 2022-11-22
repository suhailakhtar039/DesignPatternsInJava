package com.example.helloworld.DesignPatterns.Creational.Singleton;

class ChiefExecutiveOfficer{
    private static String name;
    private static int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ChiefExecutiveOfficer.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        ChiefExecutiveOfficer.age = age;
    }

    @Override
    public String toString() {
        return "ChiefExecutiveOfficer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Monostate {
    public static void main(String[] args) {
        ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
        ceo.setAge(40);
        ceo.setName("suhail");
        ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
        ceo2.setName("akhtar");
        System.out.println(ceo);
        System.out.println(ceo2);
    }
}
