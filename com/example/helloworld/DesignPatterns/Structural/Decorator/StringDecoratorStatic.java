package com.example.helloworld.DesignPatterns.Structural.Decorator;

interface Shape {
    String info();
}

class Circle implements ShapeDynamic {

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

class Square implements ShapeDynamic {
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
class ColoredShape implements ShapeDynamic {

    private ShapeDynamic shape;
    private String color;

    public ColoredShape(ShapeDynamic shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color of " + color;
    }
}

class TransparentShape implements ShapeDynamic {

    private ShapeDynamic shape;
    private int transparency;

    public TransparentShape(ShapeDynamic shape, int transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}

public class StringDecoratorStatic {
    public static void main(String[] args) {

    }
}
