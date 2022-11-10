package com.example.helloworld.practice;

import java.util.Scanner;

public class SumOfTwoIntegers {
    public static int solve(int x,int y){
        while(y!=0){
            int carry = x&y;
            x = x^y;
            y = carry<<1;
        }
        return x;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println(solve(a,b));
    }
}
