package com.example.helloworld.DesignPatterns.Structural.Decorator;

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
class ColoredShape implements Shape {

    private Shape shape;
    private String color;

    public ColoredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color of " + color;
    }
}

class TransparentShape implements Shape{

    private Shape shape;
    private int transparency;

    public TransparentShape(Shape shape, int transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}

public class StringDecoratorShape {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println(circle.info());

        ColoredShape blueSquare = new ColoredShape(new Square(10), "blue");
        System.out.println(blueSquare.info());

        TransparentShape transparentCircle = new TransparentShape(new Circle(8), 75);
        System.out.println(transparentCircle.info());

        TransparentShape greenTransparentCircle = new TransparentShape(
                new ColoredShape(new Square(20), "green"), 50
        );
        System.out.println(greenTransparentCircle.info());
        TransparentShape transparentShapeWithinTransparentShape = new TransparentShape(new TransparentShape(new Circle(44), 90), 10);
        System.out.println(transparentShapeWithinTransparentShape.info());
    }
}
