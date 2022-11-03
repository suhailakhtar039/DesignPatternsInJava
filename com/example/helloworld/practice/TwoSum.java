package com.example.helloworld.practice;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    public static int[] twosum(int[] nums,int target){
        int n = nums.length;
        int []ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(map.containsKey(target - nums[i])){
                ans[0] = map.get(target-nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],i );
        }
        return ans;
    }
    public static void main(String[] args) {
        int n,target;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        target = sc.nextInt();
        int []a = new int[n];
        for(int i=0; i<n; i++)
            a[i] = sc.nextInt();
        int []ans;
        ans = twosum(a,target);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
