package com.example.helloworld.RandomPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Lecture1 {
    public static void main(String[] args) {
//        StringBuilder s = new StringBuilder("Hello");
//        String s="SuhaiL";
//        String b=s.toLowerCase();
//        System.out.println("Hello \\\\\\");
        int a[]=new int[5];
        for(int i=0; i<a.length; i++){
            a[i]=i+(int)Math.random()*100;
        }
        String s="abc";
        String s1="def";
        s=s1;
        final List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(10);
        list.add(0,10);
        list.remove(0);
        System.out.println(list);
        System.out.println(s);
        for(int i:a)System.out.println(i);
        System.out.println();
        sum(a);
        for(int i:a)
            System.out.println(i);
    }

    public static void sum(int a[]) {
        for(int i=0; i<a.length; i++)a[i]+=5;
    }
}
