package com.example.helloworld.RandomPractice;

abstract class Base1{
    Base1(){
        System.out.println("I am from base2");
    }
    public void sayHello(){
        System.out.println("Hello");
    }
    abstract public void sayNo();
}

class Derived1 extends Base1{

    @Override
    public void sayNo() {

    }
}

public class Abstract {
    public static void main(String[] args) {

    }
}
