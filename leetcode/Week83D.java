package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Week83D {
    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{
                0,0,0,2,0,0
        }));
    }
    public String bestHand(int[] ranks, char[] suits) {
        int count =0;
        for(int i =1; i<suits.length; i++){
            if(suits[i] == suits[i-1]){
                count++;
            }
        }
        if (count==4){
            return "Flush";
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int r: ranks){
            int n = map.getOrDefault(r, 0);
            max = Math.max(max, n+1);
            map.put(r, n+1);
        }
        if(max>2){
            return "Three of a Kind";
        }else if(max ==2) {
            return "Pair";
        }
        return "High Card";
    }


    public static long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        for(int i=0;i<n; i++){
            if(nums[i] ==0){
                long count  = 0;
                while (i<n&&nums[i]==0){
                    count++;
                    i++;
                }
                map.put( count, map.getOrDefault(count, 0L) +1);
            }
        }
        long  ans = 0;
        for(long l: map.keySet()){
            ans += map.get(l) * l*(l+1) /2;
        }
        return ans;
    }


    public int shortestSequence(int[] rolls, int k) {
        int ans =0;
        Set<Integer> set = new HashSet<>();
        for(int r: rolls){
            set.add(r);
            if(set.size()==k){
                ans ++;
                set.clear();
            }
        }
        return ans+1;

    }
}
