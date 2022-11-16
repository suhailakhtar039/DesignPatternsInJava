package com.example.helloworld.DesignPatterns.Creational.Factory;

enum CoordinateSystem{
    CARTESIAN,POLAR
}

class Point{
    private double x,y;

    /**
     *
     * @param a is x if cartesian else radius
     * @param b is y if cartesian else theta
     * @param cs is coordinate system
     */
    private Point(double a,double b,CoordinateSystem cs){
        switch (cs){
            case CARTESIAN:
                this.x = a;
                this.y = b;
                break;
            case POLAR:
                this.x = a*Math.cos(b);
                this.y = a*Math.sin(b);
                break;
        }
    }

}

public class Factory {
    public static void main(String[] args) {

    }
}
