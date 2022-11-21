package com.example.helloworld.practice;

import java.util.*;

public class CombinationSum {
    private static void helper(int[] arr,List<List<Integer>> ans,int i,int temp,int target,List<Integer> tempList){
        if(temp>target)return;
        if(temp == target){
            List<Integer> l = new ArrayList<>(tempList);
            ans.add(l);
            return;
        }
        for(int j=i; j<arr.length; j++){
            tempList.add(arr[j]);
            helper(arr,ans,j,temp+arr[j],target,tempList);
            tempList.remove(tempList.size()-1);
        }
    }
    private static List<List<Integer>> solve(int[] arr,int target){
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int i=0,temp=0;
        helper(arr,ans,i,temp,target,tempList);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        List<List<Integer>> ans = solve(arr,target);
        System.out.println(ans.size());
        System.out.println(ans);
        for(List<Integer> i:ans){
            for(int j:i){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
