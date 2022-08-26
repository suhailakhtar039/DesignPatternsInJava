package com.example.helloworld;

class Base{
    int x;
    Base(){
        System.out.println("Inside base constructor");
    }
    Base(int a){
        System.out.println("Inside base constructor with value of a= "+a);
    }
    public void printMe(){
        System.out.println("Hello there from printMe");
    }
}

class Derived extends Base{
    int y;
    Derived(){
        super(4);
        System.out.println("Inside derived constructor");
    }
    @Override
    public void printMe(){
        System.out.println("Hello there from printMe derived");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Derived derived = new Derived();
//        Base b = new Base();
//        derived.printMe();
//        b.printMe();
        Base d = new Derived();
        d.printMe();
        d.x = 4;
//        d.y = 5;--error
    }
}
