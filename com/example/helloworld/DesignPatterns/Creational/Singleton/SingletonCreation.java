package com.example.helloworld.DesignPatterns.Creational.Singleton;

import java.io.*;

// Most Basic singleton
class BasicSingleton implements Serializable {
    private BasicSingleton() {
    }

    private static final BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    private int val = 0;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    protected Object readResolve(){
        return INSTANCE;
    }
}

public class SingletonCreation {

    static void saveToFile(BasicSingleton singleton, String fileName) throws Exception {
        try (FileOutputStream fileout = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileout)
        ) {
            out.writeObject(singleton);
        }
    }

    static BasicSingleton readFromFile(String fileName) throws Exception {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)
        ) {
            return (BasicSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        // 1. reflection
        // 2. serialization

        BasicSingleton singleton = BasicSingleton.getInstance();
        System.out.println(singleton);
        BasicSingleton instance = BasicSingleton.getInstance();
        System.out.println(instance);
        singleton.setVal(123);

        String fileName = "demo.txt";

        saveToFile(singleton, fileName);

        singleton.setVal(111);

        BasicSingleton singleton1 = readFromFile(fileName);

        System.out.println(singleton1 == singleton);

        System.out.println(singleton);
        System.out.println(singleton1);

        System.out.println(singleton.getVal());
        System.out.println(singleton1.getVal());
    }
}
