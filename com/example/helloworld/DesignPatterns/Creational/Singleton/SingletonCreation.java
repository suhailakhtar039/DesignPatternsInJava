package com.example.helloworld.DesignPatterns.Creational.Singleton;
//Most Basic singleton
class BasicSingleton{
    private BasicSingleton(){}
    private static final BasicSingleton INSTANCE = new BasicSingleton();
    public static BasicSingleton getInstance(){
        return INSTANCE;
    }
    private int val = 0;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

public class SingletonCreation {
    public static void main(String[] args) {
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setVal(123);
        System.out.println(singleton.getVal());
    }
}
