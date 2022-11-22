package com.example.helloworld.DesignPatterns.Creational.Singleton;

import java.util.HashMap;

enum Subsystem{
    PRIMARY,
    AUXILIARY,
    FALLBACK
}

class Printer{
    private static int instanceCount = 0;
    private Printer(){
        instanceCount++;
        System.out.println("A total of " + instanceCount + " instance has been created.");
    }
    private static HashMap<Subsystem,Printer> instances = new HashMap<>();
    public static Printer get(Subsystem ss){
        if(instances.containsKey(ss))
            return instances.get(ss);
        Printer instance = new Printer();
        instances.put(ss,instance);
        return instance;
    }
}

public class Multiton {
    public static void main(String[] args) {
        Printer primary = Printer.get(Subsystem.PRIMARY);
        Printer aux = Printer.get(Subsystem.AUXILIARY);
        Printer aux2 = Printer.get(Subsystem.AUXILIARY);
        Printer fallback = Printer.get(Subsystem.FALLBACK);
    }
}
