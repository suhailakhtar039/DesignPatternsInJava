package com.example.helloworld;

class MyThread extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (i++ < 4000) {
            System.out.println("My thread is running");
            System.out.println("I am happy");
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (i++ < 4000) {
            System.out.println("Thread 2 is good");
            System.out.println("I am sad");
        }
    }
}

// creating thread using runnable interface
class MyThreadRunnable1 implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (++i < 100) {
            System.out.println("I am a thread in 1 aabrakadabra");
        }
    }
}

class MyThreadRunnable2 implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while (++i < 100) {
            System.out.println("I am in thread 2 ye lo bhai");
        }
    }
}

public class ThreadForPractice {
    public static void main(String[] args) {
//        MyThread myThread1 = new MyThread();
//        MyThread2 myThread2 = new MyThread2();
//        myThread1.start();
//        myThread2.start();
//        Runnable interface starts from here

        MyThreadRunnable1 bullet1 = new MyThreadRunnable1();
        Thread gun1 = new Thread(bullet1);

        MyThreadRunnable2 bullet2 = new MyThreadRunnable2();
        Thread gun2 = new Thread(bullet2);

        gun1.start();
        gun2.start();

    }
}
