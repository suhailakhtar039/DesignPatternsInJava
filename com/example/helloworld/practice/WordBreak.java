package com.example.helloworld.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordBreak {
    private static boolean solve(String s,List<String> wordDict){
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Arrays.fill(dp,false);
        dp[n] = true;
        for(int i=n-1; i>=0; i--){
            for(String w:wordDict){
                if(i+w.length()<=n && w.equals(s.substring(i, i + w.length()))){
                    dp[i] = dp[i+w.length()];
                }
                if(dp[i])break;
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("s = "+s);
        int m = sc.nextInt();
        System.out.println("m = "+m);
        List<String> wordDict = new ArrayList<>();
        for(int i=0; i<m; i++){
            String temp = sc.next();
            wordDict.add(temp);
        }
        System.out.println(wordDict);
        System.out.println(solve(s,wordDict));
    }
}
