package com.example.helloworld.practice;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> solve(int[] arr){
        Arrays.sort(arr);
        Map<Integer,Integer> m = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for(int i=0; i<n; i++)
            m.put(arr[i],i );
        for(int i=0; i<n-2; i++){
            if(i>0 && arr[i]==arr[i-1])continue;
            if(arr[i]>0)return ans;
            for(int j= i+1; j<n-1;j++){
                if (j != i + 1 && arr[j] == arr[j - 1]) continue;
                int key = -(arr[i]+arr[j]);
                if(m.containsKey(key) && m.get(key)>j){
                    List<Integer> l = new ArrayList<>();
                    l.add(arr[i]);
                    l.add(arr[j]);
                    l.add(key);
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)arr[i] = sc.nextInt();
        List<List<Integer>> l = solve(arr);
        System.out.println(l.size());
        for(List<Integer> i:l){
//            System.out.println("inside first loop i = "+i);
            for(Integer j:i){
//                System.out.println("inside second loop");
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
