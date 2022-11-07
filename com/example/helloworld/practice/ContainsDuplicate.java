package com.example.helloworld.practice;

import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++)arr[i] = sc.nextInt();
        System.out.println(solve(arr));
    }

    private static boolean solve(int[] arr) {
        Map<Integer,Integer> m = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(m.containsKey(arr[i])){
                int val = m.get(arr[i]);
                m.put(arr[i],val+1);
            }else{
                m.put(arr[i],1);
            }
        }
        Iterator<Map.Entry<Integer,Integer>> itr = m.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry<Integer,Integer> t = itr.next();
            if(t.getValue()>1)
                return true;
        }
        return false;
    }
}
