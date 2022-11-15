package com.example.helloworld.practice;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    private static int solve(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            int mx = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i])
                    mx = Integer.max(mx, dp[j]);
            }
            dp[i] += mx;
        }
        int ans = Arrays.stream(dp).max().getAsInt();
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(solve(arr));
    }
}
