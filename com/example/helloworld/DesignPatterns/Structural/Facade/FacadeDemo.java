package com.example.helloworld.DesignPatterns.Structural.Facade;

import java.util.ArrayList;
import java.util.List;

class Buffer {
    private int lineWidth;
    private char[] characters;

    public Buffer(int lineWidth, int lineHeight) {
        this.lineWidth = lineWidth;
        characters = new char[lineHeight * lineWidth];
    }

    public char charAt(int x, int y) {
        return characters[y * lineWidth + x];
    }
}

class Viewport {
    private final Buffer buffer;
    private final int width;
    private final int height;
    private final int offSetX;
    private final int offSetY;

    public Viewport(Buffer buffer, int width, int height, int offSetX, int offSetY) {
        this.buffer = buffer;
        this.width = width;
        this.height = height;
        this.offSetX = offSetX;
        this.offSetY = offSetY;
    }

    public char charAt(int x, int y) {
        return buffer.charAt(x + offSetX, y + offSetY);
    }
}

class Console{
    private List<Viewport> viewports = new ArrayList<>();
    int width, height;

    public Console(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addViewport(Viewport viewport){
        viewports.add(viewport);
    }

    public static Console newConsole(int width,int height){
        Buffer buffer = new Buffer(width, height);
        Viewport viewport = new Viewport(buffer, width, height, 0, 0);
        Console console = new Console(width, height);
        console.addViewport(viewport);
        return console;
    }

    public void render(){
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                for(Viewport vp:viewports)
                    System.out.println(vp.charAt(x,y));
            }
            System.out.println();
        }
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        // not a facade design too many calls, we'll insert these calls into a single function
        // Buffer buffer = new Buffer(30, 20);
        // Viewport viewport = new Viewport(buffer, 30, 20, 0, 0);
        // Console console = new Console(30, 20);
        // console.addViewport(viewport);
        // console.render();

    //    this one is facade
        Console console = Console.newConsole(30, 20);
        console.render();
    }
}
