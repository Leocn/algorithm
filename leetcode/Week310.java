package com.example.demo.leetcode;


import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;
import java.util.TreeSet;

public class Week310 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{4,2,1,4,3,4,5,8,15},3));
    }

    public int mostFrequentEven(int[] nums) {
        int[] arr = new int[100006];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==0){
                arr[nums[i]]++;
            }
        }
        int max = 0;
        int ans = -1;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]>max){
                max = arr[i];
                ans = i;
            }
        }
        return ans;

    }


    public int partitionString(String s) {
        int[] re = new int[26];
        Arrays.fill(re, -1);
        char[] cs = s.toCharArray();
        int cnt = 0;
        for(int i =0; i<cs.length; i++){
            int index = cs[i] -'a';
            if(re[index]==-1){
                re[index] = i;
            }else{
                cnt++;
                Arrays.fill(re, -1);
                re[index] = i;
            }
        }
        return cnt+1;
    }

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals);
        TreeMap<Integer,Integer> set = new TreeMap<>();
        set.put(intervals[0][1], 1);
        set.put(0, 0);
        for (int i = 1; i < intervals.length; i++) {
            int[] p = intervals[i];
            int cnt = set.lowerKey(p[0]);
            if(cnt==0 ){
                set.put(p[1], set.getOrDefault(p[1], 0)+1);
                continue;
            }

            set.put(cnt, set.getOrDefault(cnt,0)-1);
            if(set.get(cnt)==0){
                set.remove(cnt);
            }

            set.put(p[1], set.getOrDefault(p[1], 0)+1);

        }
        int ans = 0;
        for (int key: set.keySet()) {
            ans += set.get(key);
        }
        return ans;
    }

    public static int lengthOfLIS(int[] nums, int k) {
        return 1;
        //TODO

    }
}
