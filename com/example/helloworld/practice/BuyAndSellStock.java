package com.example.helloworld.practice;

import java.util.Scanner;

public class BuyAndSellStock {
    public static int solve(int []nums){
        int n = nums.length;
        int buy = nums[0],maxProfit = 0;
        for(int i=1; i<n; i++){
            if(nums[i]<buy)
                buy = nums[i];
            else if(nums[i]-buy>maxProfit)
                maxProfit = nums[i]-buy;
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []nums = new int[n];
        for(int i=0; i<n; i++)nums[i] = sc.nextInt();
        System.out.println(solve(nums));
    }
}
