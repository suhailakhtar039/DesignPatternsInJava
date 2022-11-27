package com.example.helloworld.DesignPatterns.Structural.Composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GraphicObject {
    protected String name = "Group";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GraphicObject() {
    }

    public String color;
    public List<GraphicObject> children = new ArrayList<>();

    private void print(StringBuilder stringBuilder, int depth) {
        stringBuilder.append(String.join("", Collections.nCopies(depth, "*")))
                .append(depth > 0 ? " " : "")
                .append((color == null || color.isEmpty()) ? "" : color + " ")
                .append(getName())
                .append(System.lineSeparator());
        for (GraphicObject child : children)
            child.print(stringBuilder, depth + 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        print(sb, 0);
        return sb.toString();
    }
}

class Circle extends GraphicObject {
    public Circle(String color){
        name = "Circle";
        this.color = color;
    }
}

class Square extends GraphicObject {
    public Square(String color){
        name = "Square";
        this.color = color;
    }
}

public class CompositePattern {
    public static <g> void main(String[] args) {
        // GraphicObject child1 = new GraphicObject();
        // child1.color = "red";
        // child1.name = "child1";
        //
        // GraphicObject child2 = new GraphicObject();
        // child2.color = "green";
        // child2.name = "child2";
        //
        // GraphicObject par = new GraphicObject();
        // par.children.add(child1);
        // par.children.add(child2);
        // System.out.println(par);

        GraphicObject drawing = new GraphicObject();
        drawing.setName("My drawing");
        drawing.children.add(new Square("Red"));
        drawing.children.add(new Circle("Yellow"));

        GraphicObject group = new GraphicObject();
        group.setName("level 2");
        group.children.add(new Circle("Blue"));
        group.children.add(new Square("Blue"));
        drawing.children.add(group);
        System.out.println(drawing.children.size());
        System.out.println(drawing);
    }
}
