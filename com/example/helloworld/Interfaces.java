package com.example.helloworld;

interface Cycles {
    int increment(int x);

    int decrement(int x);
}

interface Bikes{
    int increment(int x);

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
    public int increment(int x) {
        return x + 1;
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
}

public class Interfaces {
    public static void main(String[] args) {
        Hero c = new Hero();
        int a=4;
        System.out.println(c.increment(a));
        c.foo();
        c.print();
    }
}
