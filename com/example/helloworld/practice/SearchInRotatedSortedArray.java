package com.example.helloworld.practice;

import java.util.Scanner;

public class SearchInRotatedSortedArray {
    public static int solve(int[] arr,int target){
        int n = arr.length;
        int st = 0, en = n-1;
        while(st<=en){
            int mid = (st+en)/2;
            if(arr[mid]==target)return mid;
            if(arr[mid]>=arr[st])//left array is sorted
            {
                if(target>=arr[st] && target<=arr[mid])
                    en = mid-1;
                else
                    st = mid+1;
            }
            else{//right array is sorted
                if(target>=arr[mid] && target<=arr[en])
                    st = mid+1;
                else
                    en = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)arr[i] = sc.nextInt();
        System.out.println(solve(arr,target));
    }
}

