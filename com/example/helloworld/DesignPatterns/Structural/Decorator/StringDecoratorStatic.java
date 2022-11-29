package com.example.helloworld.DesignPatterns.Structural.Decorator;

import java.util.function.Supplier;

interface Shape {
    String info();
}

class Circle implements Shape {

    private float radius;

    public Circle() {
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "A circle of radius " + radius;
    }
}

class Square implements Shape {
    private float side;

    public Square() {
    }

    public Square(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A square of side " + side;
    }
}

// making a decorator
class ColoredShape<T extends Shape> implements Shape {

    private Shape shape;
    private String color;

    public ColoredShape(Supplier<? extends T> ctor,String color) {
        shape = ctor.get();
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has a color " + color;
    }
}

class TransparentShape<T extends Shape> implements Shape{

    private Shape shape;
    private int transparency;
    public TransparentShape(Supplier<? extends T> ctor,int transparency){
        shape = ctor.get();
        this.transparency = transparency;
    }
    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}

public class StringDecoratorStatic {
    public static void main(String[] args) {
        ColoredShape<Square> blueSquare = new ColoredShape<>(
                () -> new Square(10),
                "blue"
        );
        System.out.println(blueSquare.info());

        TransparentShape<ColoredShape<Circle>> myCircle = new TransparentShape<>(()->
                new ColoredShape<>(()->new Circle(20),"green"),50);
        System.out.println(myCircle.info());
    }
}
