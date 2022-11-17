package com.example.helloworld.DesignPatterns.Creational.Factory;

import javafx.util.Pair;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.*;
import java.util.Set;

interface HotDrink {
    void consume();
}

class Tea implements HotDrink {
    @Override
    public void consume() {
        System.out.println("This Tea is good!!");
    }
}

class Coffee implements HotDrink {
    @Override
    public void consume() {
        System.out.println("This coffee is good!!!!!!!!!!");
    }
}

interface HotDrinkFactory {
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Preparing TEA factory with amount = " + amount);
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory{
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Preparing COFFEE factory with amount = " + amount);
        return new Coffee();
    }
}

class HotDrinkMachine{
    private List<Pair<String,HotDrinkFactory>> namedFactories = new ArrayList<>();
    public HotDrinkMachine() throws Exception {
        Set<Class<? extends HotDrinkFactory>> types = new Reflections("")
                .getSubTypesOf(HotDrinkFactory.class);
        for (Class<? extends HotDrinkFactory> type:types){
            namedFactories.add(new Pair<>(
                    type.getSimpleName().replace("Factory",""),
                    type.getDeclaredConstructor().newInstance()
            ));
        }
    }
    public HotDrink makeDrink() throws Exception {
        System.out.println("Available Drinks: ");
        for(int i = 0; i<namedFactories.size(); i++){
            Pair<String, HotDrinkFactory> item = namedFactories.get(i);
            System.out.println( i +" : "+item.getKey());
        }

    }
}

public class AbstractFactory {
}
