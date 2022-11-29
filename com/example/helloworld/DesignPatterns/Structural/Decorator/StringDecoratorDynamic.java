package com.example.helloworld.DesignPatterns.Structural.Decorator;

interface ShapeDynamic {
    String info();
}

class CircleDynamic implements ShapeDynamic {

    private float radius;

    public CircleDynamic() {
    }

    public CircleDynamic(float radius) {
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

class SquareDynamic implements ShapeDynamic {
    private float side;

    public SquareDynamic() {
    }

    public SquareDynamic(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A square of side " + side;
    }
}

// making a decorator
class ColoredShapeDynamic implements ShapeDynamic {

    private ShapeDynamic shape;
    private String color;

    public ColoredShapeDynamic(ShapeDynamic shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color of " + color;
    }
}

class TransparentShapeDynamic implements ShapeDynamic {

    private ShapeDynamic shape;
    private int transparency;

    public TransparentShapeDynamic(ShapeDynamic shape, int transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has " + transparency + "% transparency";
    }
}

public class StringDecoratorDynamic {
    public static void main(String[] args) {
        CircleDynamic circle = new CircleDynamic(10);
        System.out.println(circle.info());

        ColoredShapeDynamic blueSquare = new ColoredShapeDynamic(new SquareDynamic(10), "blue");
        System.out.println(blueSquare.info());

        TransparentShapeDynamic transparentCircle = new TransparentShapeDynamic(new CircleDynamic(8), 75);
        System.out.println(transparentCircle.info());

        TransparentShapeDynamic greenTransparentCircle = new TransparentShapeDynamic(
                new ColoredShapeDynamic(new SquareDynamic(20), "green"), 50
        );
        System.out.println(greenTransparentCircle.info());
        TransparentShapeDynamic transparentShapeWithinTransparentShape = new TransparentShapeDynamic(new TransparentShapeDynamic(new CircleDynamic(44), 90), 10);
        System.out.println(transparentShapeWithinTransparentShape.info());
    }
}
