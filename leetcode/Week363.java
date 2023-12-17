package com.example.demo.leetcode;

import java.util.*;

public class Week363 {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            int c = Integer.bitCount(i);
            if(c==k){
                ans+= nums.get(i);
            }
        }
        return ans;
    }

    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int n = nums.size();
        int ans = 1;
        for (int i = 0; i < n-1; i++) {
            int c = i+1;
            if(c>nums.get(i) && c<nums.get(i+1)){
                ans++;
            }

        }
        if(nums.get(0)!=0 ) ans++;
        return ans;
    }


    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int ans = 0;
        for(List<Integer> list : composition){
            long l = 0 , r = Integer.MAX_VALUE;
            while (l<r){
                long mid = l+r>>1;
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    if(mid*list.get(i)>stock.get(i)){
                        sum += (long)cost.get(i) *((long) mid *list.get(i)-stock.get(i));
                    }
                }
                if(sum>budget){
                    r = mid;
                }else {
                    l = mid+1;
                }
            }
            ans = Math.max(ans, (int)l-1);
        }
        return ans;


    }



}
