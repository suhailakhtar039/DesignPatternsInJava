package com.example.helloworld;

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
