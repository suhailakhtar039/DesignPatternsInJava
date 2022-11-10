package com.example.helloworld.practice;

import java.util.Scanner;

public class ContainerWithMostWater {
    public static int solve(int[] arr){
        int n = arr.length;
        int first = 0, last = n-1;
        int max = Math.min(arr[first],arr[last])*(last-first);
        while(first<=last){
            int area = Math.min(arr[first],arr[last])*(last-first);
            max = Math.max(max,area);
            if(arr[first]<=arr[last])first++;
            else last--;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++)arr[i] = sc.nextInt();
        System.out.println(solve(arr));
    }
}
