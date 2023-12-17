package com.example.demo.leetcode;

import java.math.BigInteger;
import java.util.*;

public class Week375 {
    public static void main(String[] args) {

    }

    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(batteryPercentages[i]>0){
                ans ++;
                for (int j = i+1; j <n ; j++) {
                    batteryPercentages[j] = Math.max(batteryPercentages[j]-1, 0);
                }
            }
        }
        return ans;
    }
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] v = variables[i];
            int a = v[0], b = v[1], c = v[2], d = v[3];
            BigInteger res = (BigInteger.valueOf(a).modPow(BigInteger.valueOf(b), BigInteger.valueOf(10))).modPow(BigInteger.valueOf(c),BigInteger.valueOf(d));
            if(res.intValue() == target){
                ans.add(i);
            }
        }
        return ans;
    }
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i]>max){
                max = nums[i];
            }
        }
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + (nums[i] == max?1:0);
        }
        int loc = 0;
        for (int i = 1; i <= n; i++) {
            if(sum[i]>=k){
                int d = sum[i] - k;
                while (sum[loc]<=d){
                    loc++;
                }
                ans += (loc);
            }
        }
        return ans;
    }

    public int numberOfGoodPartitions(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        List<int[]> g = new ArrayList<>();
        for (int i = n-1; i >=0; i--) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if(set.contains(nums[i])){
                continue;
            }
            if(map.containsKey(nums[i])){
                set.add(nums[i]);
                if(map.get(nums[i])!=i){
                    g.add(new int[]{i, map.get(nums[i])});
                    map.remove(nums[i]);
                }
            }
        }
        g.sort((a, b) -> {
            if (a[0] - b[0] == 0) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for (int i = 0; i <g.size(); i++) {
            int loc = i+1;
            while (loc<g.size()){
                if(g.get(loc)[0]<g.get(loc-1)[1]){
                    loc++;
                }
            }
            n -= g.get(loc-1)[1] - g.get(i)[0];

            i = loc-1;

        }
        BigInteger ans = BigInteger.valueOf(2).modPow(BigInteger.valueOf(n-1), BigInteger.valueOf((int)1e9+7));
        return ans.intValue();

    }

}
