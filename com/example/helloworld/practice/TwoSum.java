package com.example.helloworld.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
class Abc {
    private int a;
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abc abc = (Abc) o;
        return a == abc.a;
    }

    @Override
    public int hashCode() {
        return a;
    }
}
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
        Abc a = new Abc();
        a.setA(3);
        Abc b = new Abc();
        b.setA(4);
        System.out.println(a.getClass());
        Map<Abc,Integer> m = new HashMap<>();
        m.put(a,1);
        m.put(b,1);
        System.out.println(m.size());
        for(Map.Entry<Abc,Integer> q:m.entrySet()){
            System.out.println(q.getKey()+"-"+q.getValue());
        }
    }
}
