package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Week366 {
    public int differenceOfSums(int n, int m) {
        int a = 0, b = 0;
        for (int i = 1; i <= n ; i++) {
            if(i%m==0){
                a+=i;
            }else {
                b+=i;
            }
        }
        return  b-a;
    }
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        List<Integer> list = new ArrayList<>();
        for(int p: processorTime){
            for (int i = 0; i < 4; i++) {
                list.add(p);
            }
        }
        Collections.sort(list);
        tasks.sort((a, b) -> b - a);
        int ans = 0;
        for(int i =0; i<tasks.size(); i++){
            ans = Math.max(ans, list.get(i)+ tasks.get(i));
        }
        return ans;
    }


    public int maxSum(List<Integer> nums, int k) {
        long ans = 0;
        int[] cnt = new int[32];
        for(int num: nums){
            int c = 0;
            while (num>0){
                cnt[c++] += num&1;
                num/=2;
            }
        }
        int mod = (int)1e9+7;
        for (int i = 0; i < k; i++) {
            long a = 0;
            for (int j = 0; j < 32; j++) {
                if(cnt[j]>0){
                    a+= (1<<j);
                    cnt[j]--;
                }

            }
            ans = (ans + a*a)%mod;
        }
        return (int) ans;
    }

    public int minOperations(String s1, String s2, int x) {
        return 1;
    }
}
