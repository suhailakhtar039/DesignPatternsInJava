package com.example.helloworld.practice;

import java.util.Scanner;

public class NumberOf1bits {
    public static int solve(int n){
        int ans = 0;
        while(n!=0){
            ans += n&1;
            n>>>=1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
}
