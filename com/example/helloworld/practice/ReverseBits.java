package com.example.helloworld.practice;

import java.util.Scanner;

public class ReverseBits {
    private static int solve(int n){
        int ans = 0;
        for(int i=0; i<32; i++){
            ans<<=1;
            if((n&1)==1){
                ans ^= 1;
            }
            n>>=1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
}
