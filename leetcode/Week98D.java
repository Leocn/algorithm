package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Week98D {
    public static void main(String[] args) {
    }
    public static int minMaxDifference(int num) {
        int n = (""+num).length();
        char c = 'r';
        char[] cs = (""+num).toCharArray();
        char[] cs2 = (""+num).toCharArray();
        for (int i = 0; i < n; i++) {
            if(c=='r' && cs[i]<'9'){
                c = cs[i];
                cs[i]='9';
            }
            if(cs[i]==c){
                cs[i] ='9';
            }
        }
        c = cs2[0];
        for (int i = 1; i < n; i++) {
            if(cs2[i]==cs2[0]){
                cs2[i] ='0';
            }
        }
        cs2[0] ='0';
        String s = (String.valueOf(cs));
        String s2 = (String.valueOf(cs2));
        System.out.println(s2);
        return Integer.parseInt(s) - Integer.parseInt(s2);

    }


    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int  n = nums.length;
        return  Math.min(nums[n-3] -nums[0], nums[n-1] -nums[2]);
    }
    public int minImpossibleOR(int[] nums) {
        Set<Integer> set= new HashSet<Integer>();
        for(int t: nums){
            set.add(t);
        }
        int n =1;
        while (set.contains(n)){
            n*=2;
        }
        return n;

    }
}
