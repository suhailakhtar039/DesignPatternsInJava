package com.example.helloworld.DesignPatterns.Creational.Factory;

class Point {
    private double x, y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point newCartesianPoint(double x,double y){
        return new Point(x,y);
    }

    public static Point newPolarPoint(double rho,double theta){
        return new Point(rho*Math.cos(theta),rho*Math.sin(theta));
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class Factory {
    public static void main(String[] args) {
        Point point = Point.newPolarPoint(4, 2);
        point = Point.newCartesianPoint(4,5);
        System.out.println(point);
    }
}
