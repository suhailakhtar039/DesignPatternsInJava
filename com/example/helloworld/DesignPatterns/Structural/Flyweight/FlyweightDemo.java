package com.example.helloworld.DesignPatterns.Structural.Flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class User{
    private String fullName;

    public User(String fullName) {
        this.fullName = fullName;
    }
}

class User2{
    static List<String> strings = new ArrayList<>();
    private int[] names;
    public User2(String fullName){
        Function<String, Integer> getOrAdd = (String s)->{
            int idx = strings.indexOf(s);
            if(idx != -1)return idx;
            strings.add(s);
            return strings.size()-1;
        };

        names = Arrays.stream(fullName.split(" "))
                .mapToInt(s -> getOrAdd.apply(s))
                .toArray();

    }
}

public class FlyweightDemo {
    public static void main(String[] args) {
        User2 u1 = new User2("Suhail Akhtar");
    }
}
