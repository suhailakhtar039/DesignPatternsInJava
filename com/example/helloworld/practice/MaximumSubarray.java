package com.example.helloworld.practice;

import java.util.Scanner;

public class MaximumSubarray {
    public static int solve(int [] arr){
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum+=arr[i];
            maxSum = Math.max(maxSum,sum);
            if(sum<0)sum=0;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++)arr[i]=sc.nextInt();
        System.out.println(solve(arr));
    }
}
