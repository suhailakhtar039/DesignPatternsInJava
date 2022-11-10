package com.example.helloworld;

interface BasicAnimal{
    void eat();
    void sleep();
}

abstract class Pen{
    abstract void write();

    abstract void refill();
}
class Monkey{
    void jump(){
        System.out.println("Jump method");
    }
    void bite(){
        System.out.println("Bite");
    }

}
class FountainPen extends Pen{

    @Override
    void write() {
        System.out.println("Writing....");
    }

    @Override
    void refill() {
        System.out.println("Refilling......");
    }

    void changeNib(){
        System.out.println("Changing nib....");
    }
}

class Human extends Monkey implements BasicAnimal{

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void jump(){
        System.out.println("Jump in base class");
    }
}

public class PracticeOnAbstractAndInterfaces {
    public static void main(String[] args) {
//        FountainPen p = new FountainPen();
        Monkey m = new Human();
        m.jump();


    }
}
