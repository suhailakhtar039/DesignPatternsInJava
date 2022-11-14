package com.example.helloworld.practice;

import java.util.Scanner;

public class MissingNumber {
    private static int solve(int[] arr){
        int n = arr.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            ans ^= i;
            ans ^= arr[i];
        }
        ans ^= n;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)arr[i] = sc.nextInt();
        System.out.println(solve(arr));
    }
}
