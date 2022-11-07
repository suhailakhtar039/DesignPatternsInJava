package com.example.helloworld.practice;

import java.util.Scanner;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        int []ans = solve(arr);
        for(int i:ans)
            System.out.print(i+" ");
    }
    public static int[] solve(int []arr){
        int n = arr.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = arr[0];
        suf[n-1] = arr[n-1];
        for(int i=1; i<n; i++)
            pre[i] = arr[i]*pre[i-1];
        for(int i=n-2; i>=0; i--)
            suf[i] = arr[i]*suf[i+1];
        int []ans = new int[n];
        for(int i=0; i<n; i++){
            if(i==0){
                ans[i]=suf[1];
            } else if (i==n-1) {
                ans[i]=pre[n-2];
            } else{
                ans[i]=pre[i-1]*suf[i+1];
            }
        }
        return ans;
    }
}
