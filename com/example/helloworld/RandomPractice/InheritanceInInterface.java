package com.example.helloworld.RandomPractice;

interface SampleInterface{
    void meth1();
    void meth2();
}

interface childInterface extends  SampleInterface{
    void meth3();
    void meth4();
}

class MyClass implements childInterface{

    @Override
    public void meth1() {

    }

    @Override
    public void meth2() {

    }

    @Override
    public void meth3() {

    }

    @Override
    public void meth4() {

    }
}

public class InheritanceInInterface {
    public static void main(String[] args) {

    }
}
