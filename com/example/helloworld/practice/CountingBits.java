package com.example.helloworld.practice;

import java.util.Scanner;

public class CountingBits {
    public static int noOf1Bits(int n){
        int ans = 0;
        while(n!=0){
            ans += n&1;
            n>>>=1;
        }
        return ans;
    }
    public static int[] solve(int n){
        int[] ans = new int[n+1];
        for(int i=0; i<=n; i++){
            ans[i] = noOf1Bits(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i:solve(n))
            System.out.println(i);
    }
}
