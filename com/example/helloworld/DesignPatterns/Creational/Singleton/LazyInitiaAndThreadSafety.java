package com.example.helloworld.DesignPatterns.Creational.Singleton;

class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("initializing lazy singleton");
    }
    // public static synchronized LazySingleton getInstance(){
    //     if (instance == null) {
    //         instance = new LazySingleton();
    //     }
    //     return instance;
    // }

    //    double checked locking
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

public class LazyInitiaAndThreadSafety {
    public static void main(String[] args) {

    }
}
