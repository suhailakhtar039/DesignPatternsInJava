package com.example.helloworld.practice;

import java.util.Scanner;

public class MaximumProductSubarray {
    private static int ans;

    public static int solve(int[] arr) {
        int n = arr.length;
        int prod = 1;
        int ans = Integer.MIN_VALUE;
        for (int j : arr) {
            prod *= j;
            ans = Integer.max(prod, ans);
            if (prod == 0) prod = 1;
        }
        prod = 1;
        for (int i = n - 1; i >= 0; i--) {
            prod *= arr[i];
            ans = Integer.max(prod, ans);
            if (prod == 0) prod = 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(solve(arr));
    }
}
