package com.example.helloworld.practice;

import java.util.Scanner;

public class MinimumInRotatedSortedArray {
    public static int solve(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int n = arr.length;
        int st = 0, en = n - 1;
        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[st] < arr[en]) return arr[st];
            if (arr[mid] >= arr[st])
                st = mid + 1;
            else
                en = mid;
        }
        return arr[st];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(solve(arr));
    }
}
