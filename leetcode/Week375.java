package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Week375 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{2,2}));
        System.out.println(minimumRemoval(new long[]{1,2}));
        System.out.println();
    }


    public static int minimumOperations(int[] nums) {
        int l = nums.length;
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        int ll=0, rr=0;
        for(int i=0;i<l;i++){
            if(i%2==0){
                map1.put(nums[i], map1.getOrDefault(nums[i],0)+1);
                ll++;

            }else
            {
                map2.put(nums[i], map2.getOrDefault(nums[i],0)+1);
                rr++;
            }
        }
        int ans1 =0;
        int a1 =0;
        for(Map.Entry<Integer, Integer> entry:map1.entrySet()){
            if(entry.getValue()>ans1){
                ans1 = entry.getValue();
                a1 = entry.getKey();
            }
        }


        int ans2 =0;
        int a2 =0;
        for(Map.Entry<Integer, Integer> entry:map2.entrySet()){
            if(entry.getValue()>ans2){
                ans2 = entry.getValue();
                a2 = entry.getKey();
            }
        }

        int res = 0;

        if(a1==a2){
            int ans11 =0;
            int a11 =0;
            int ans22 =0;
            int a22 =0;
            for(Map.Entry<Integer, Integer> entry:map1.entrySet()){
                if(entry.getValue()>ans11 && entry.getKey()!=a1){
                    ans11 = entry.getValue();
                    a11 = entry.getKey();
                }
            }

            for(Map.Entry<Integer, Integer> entry:map2.entrySet()){
                if(entry.getValue()>ans22&& a2!=entry.getKey()){
                    ans22 = entry.getValue();
                    a22 = entry.getKey();
                }
            }
            res = Math.min( ll-ans1 + rr-ans22, ll-ans11+ rr-ans2       );


        }else {
            res = ll-ans1 + rr-ans2;
        }
        return res;


    }

    public static long minimumRemoval(long[] beans) {
        Arrays.sort(beans);
        int l = beans.length;
        long[] sums = new long[l+1];
        for(int i=0;i<l;i++){
            sums[i+1] = beans[i]+sums[i];
        }
        long ans = Long.MAX_VALUE;

        for (int i = 0; i < l; i++) {
            int tem = i;
            while (tem<l-1 &&beans[tem]==beans[tem+1]){
                tem++;
            }
            ans = Math.min(sums[i] + sums[l]-sums[tem]-(long)(l-tem)*beans[i], ans );
            i = tem;
        }
        return ans;


    }

    public int maximumANDSum(int[] nums, int numSlots) {
        int ans = 0;
        int[] f = new int[1 << (numSlots * 2)];
        for (int i = 0; i < f.length; i++) {
            int c = Integer.bitCount(i);
            if (c >= nums.length) continue;
            for (int j = 0; j < numSlots * 2; ++j) {
                if ((i & (1 << j)) == 0) { // 枚举空篮子 j
                    int s = i | (1 << j);
                    f[s] = Math.max(f[s], f[i] + ((j / 2 + 1) & nums[c]));
                    ans = Math.max(ans, f[s]);
                }
            }
        }
        return ans;

    }
}
