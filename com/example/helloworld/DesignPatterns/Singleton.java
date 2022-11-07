package com.example.helloworld.DesignPatterns;
class Single{
    static int a;
}
public class Singleton {
    public static void main(String[] args) {
        Single s = new Single();
        Single a = new Single();
        System.out.println(s);
        Single.a = 3;
        System.out.println(a);
        if(s==a){
            System.out.println("Both are same");
        }else{
            System.out.println("Both are different");
        }
    }
}
