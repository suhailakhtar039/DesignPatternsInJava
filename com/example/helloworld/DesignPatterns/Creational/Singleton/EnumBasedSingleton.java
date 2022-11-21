package com.example.helloworld.DesignPatterns.Creational.Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

enum EnumsSingleton{
    INSTANCE;

    EnumsSingleton() {
        value = 42;
    }
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class EnumBasedSingleton {
    static void saveToFile(EnumsSingleton singleton, String fileName) throws Exception {
        try (FileOutputStream fileout = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileout)
        ) {
            out.writeObject(singleton);
        }
    }

    static EnumsSingleton readFromFile(String fileName) throws Exception {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)
        ) {
            return (EnumsSingleton) in.readObject();
        }
    }
    public static void main(String[] args) throws Exception {
        String fileName = "myfile.bin";
        EnumsSingleton singleton = EnumsSingleton.INSTANCE;
        singleton.setValue(111);
        saveToFile(singleton,fileName);

        EnumsSingleton singleton1 = readFromFile(fileName);
        System.out.println(singleton1.getValue());
    }
}
