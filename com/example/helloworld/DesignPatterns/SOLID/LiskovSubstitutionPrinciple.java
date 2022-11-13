package com.example.helloworld.DesignPatterns.SOLID;

class Rectangle{
    protected int width,height;
    public Rectangle(){
        System.out.println("Inside Rectangle constructor");
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    void print(){
        System.out.println("base class");
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea(){
        return height*width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}

class Square extends Rectangle{
    public Square(){
        System.out.println("Inside square constructor");
    }
    public Square(int size){
        width = height = size;
    }

    void print(){
        System.out.println("derived class");
    }
    @Override
    public void setWidth(int width) {
        super.setHeight(width);
        super.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}
// Above we've violated the principle of LiskovSubstitutionPrinciple
// Below code is one of the solution
class RectangleFactory{
    public static Rectangle newRectangle(int width,int height){
        return new Rectangle(width,height);
    }
    public static Rectangle newSquare(int side){
        return new Rectangle(side,side);
    }
}
public class LiskovSubstitutionPrinciple {
// checking below how we have violated the principle
    static void useIt(Rectangle r){
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Expected area = "+width*10+" ,but got the value of "+r.getArea());
    }
    public static void main(String[] args) {
//      this will work fine
        Rectangle r = new Rectangle(10,5);
        useIt(r);

//      Doing the same thing but using square
        Rectangle sq = new Square();
        sq.print();
        sq.setWidth(5);
        useIt(sq);
    }
}
