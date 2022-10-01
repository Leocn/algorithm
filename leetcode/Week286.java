package com.example.demo.leetcode;

import java.util.*;

public class Week286 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kthPalindrome(new int[]{2,4,6}, 4)));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num: nums1){
            set1.add(num);
        }
        Set<Integer> ans2 = new HashSet<>();
        Set<Integer> ans1 = new HashSet<>();

        for(int num: nums2){
            if(!set1.contains(num)){
                ans2.add(num);
            }
            set2.add(num);
        }
        for(int num: nums1){
           if(!set2.contains(num)){
               ans1.add(num);
           }
        }
        ans.add(new ArrayList<>(ans1));
        ans.add(new ArrayList<>(ans2));
        return  ans;


    }

    /**
     比如5位数
     10001, 可以由100 和 01 组成
     10101，可以由101 和 01 组成
     10201，可以由102 和 01 组成

     99999, 可以由999 和 99 组成
     */
    public static long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] ans = new long[n];
        for(int i = 0; i<queries.length;i++){
            String s = (long)Math.pow(10, (intLength-1)/2)+ queries[i]-1 +"";
            if(s.length() > (intLength + 1) / 2){
                // 判断条件也可以是 queries[i]>Math.pow(10, (intLength+1)/2-1 ) * 9
                ans[i] =-1;
            }else {
                // new StringBuilder().append(s).reverse().substring( intLength%2)
                // 先反转s，根据intLength 是否为偶数，截取s
                ans[i] = Long.valueOf(s + new StringBuilder().append(s).reverse().substring( intLength%2));
            }

        }
        return ans;
    }


    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int m = piles.size();
        int[][] dp =  new int[m+1][k+1];
        for(int j=1 ;j<=m ;j++){
            List<Integer> pile = piles.get(j-1);

            for(int i=1; i<=k; i++){
                for(int h=0, sum =0; h<=Math.min(i, pile.size()); h++){
                    dp[j][i] = Math.max(dp[j][i], dp[j-1][i-h] + sum);
                    if(h<pile.size()){
                        sum += pile.get(h);
                    }
                }

            }
        }
        return  dp[m-1][k];
    }
}
