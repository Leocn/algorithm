package com.example.demo.leetcode;

import java.util.*;

public class Week272 {


    public String firstPalindrome(String[] words) {
        for (String word: words){
            if(valid(word)){
                return  word;
            }
        }
        return "";
    }

    boolean valid(String word){
        int l = 0;
        int r = word.length()-1;
        while (l<r){
            if(word.charAt(l) != word.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        for(int space: spaces){
            sb.insert(space+count, " ");
            count++;
        }
        return  new String(sb);
    }

    public long getDescentPeriods(int[] prices) {
        long res = 0;
        int l = prices.length;
        long[] dp = new long[l];
        for(int i=1; i<l; i++){
            if(prices[i]- prices[i-1]==1){
                dp[i] = dp[i-1]+1;
            }
            res += dp[i];
        }
        return res +l;
    }

    public int kIncreasing(int[] arr, int k) {
        //Map<Integer, List<Integer>> map = new HashMap<>();
        int res = 0;
        //List[] ar = new List[k];
//        for(int i=0; i<k;i++){
//            ar[i] = new ArrayList<>();
//        }
        int[] dp = new int[k];
        for(int i=0; i<k;i++){
            dp[i] = Integer.MIN_VALUE;
        }
        int[] count = new int[k];
        int[] ll = new int[k];

        for(int i = 0; i<arr.length; i++){
            int dd = i%k;
            //ar[dd].add(arr[i]);
            if( dp[dd]>arr[i]){
                //dp[dd]++;
                count[dd]++;
            }
            ll[dd]++;
            dp[dd] = arr[i];
        }

        for(int i =0; i<k; i++){
            res += count[i];
        }
        return res;



    }
}
