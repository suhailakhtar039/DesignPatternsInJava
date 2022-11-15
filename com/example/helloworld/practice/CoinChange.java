package com.example.helloworld.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CoinChange {
    private static int solve(int[] arr, int target) {
        int n = arr.length;
        if (target == 0) return target;
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            int mn = Integer.MAX_VALUE;
            for (int k : arr) {
                if (k <= i && dp[i - k] != -1) {
                    mn = Math.min(dp[i - k], mn);
                }
            }
            dp[i] = (mn == Integer.MAX_VALUE ? -1 : 1 + mn);
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(solve(arr, target));
    }
}
