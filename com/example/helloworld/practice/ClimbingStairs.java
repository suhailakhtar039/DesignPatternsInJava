package com.example.helloworld.practice;

import java.util.Scanner;

public class ClimbingStairs {
    private static int solve(int n){
        int[] ans = new int[n+1];
        ans[0] = 1;
        ans[1] = 1;
        for(int i=2; i<=n; i++)
            ans[i] = ans[i-1]+ans[i-2];
        return ans[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
}
