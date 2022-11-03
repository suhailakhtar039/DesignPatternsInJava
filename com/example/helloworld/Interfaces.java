package com.example.helloworld;

interface Cycles {
    int increment(int x);

    int decrement(int x);
}

interface Bikes{
    int x = 0;
    int increment();
    void printX();

    //default methods
    default void print(){
        System.out.println("Printing...");
    }
}

class Bases{
    public void foo(){
        System.out.println("Hello word");
    }

    public void print(){
        System.out.println("Printing in base class...");
    }
}

class Hero extends Bases implements Cycles,Bikes {

    @Override
    public int increment() {
        return x + 1;
    }

    @Override
    public int increment(int x) {
        return 0;
    }

    @Override
    public int decrement(int x) {
        return x - 1;
    }

    @Override
    public void foo() {
        super.foo();
        System.out.println("Whats up");
    }

    @Override
    public void printX() {
        System.out.println(x);
    }
}

public class Interfaces {
    public static void main(String[] args) {
        Bases b = new Hero();
        b.foo();
        Bikes b1 = new Hero();
        int x = 4;
        b1.increment();
        Hero c = new Hero();
        int a=4;
        System.out.println(c.increment(a));
        c.foo();
        c.print();
    }
}
