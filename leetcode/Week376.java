package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Week376 {
    public static void main(String[] args) {

    }
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] vis = new int[n*n];
        for(int[] g: grid){
            for(int c: g){
                vis[c-1]++;
            }
        }
        int[] ans = new int[2];
        for (int i = 0; i < n*n; i++) {
            if(vis[i] == 0){
                ans[1] = i+1;
            }
            if(vis[i] == 2){
                ans[0] = i+1;
            }
        }
        return ans;
    }
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n/3][3];
        for (int i = 0; i < n; i+=3) {
            if(nums[i+2]-nums[i]>k){
                return  new int[][]{};
            }
            ans[i/3] = new int[]{nums[i], nums[i+1], nums[i+2]};
        }
        return ans;
    }

    public long minimumCost(int[] nums) {
        long ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n/2];
        int max = (int)1e9+(int)1e6;
        for(int i= a; i<=max;i++){
            if(isPalindrome(i)){
                ans = cal(nums, i);
                break;
            }
        }
        for(int i=a; i>=0; i--){
            if(isPalindrome(i)){
                ans = Math.min(cal(nums, i),ans);
                break;
            }
        }

        return ans;
    }
    /**
     * 从小到大生成回文数字
     * */
    private static final int[] pal = new int[109999];

    static {
        // 严格按顺序从小到大生成所有回文数（不用字符串转换）
        int palIdx = 0;
        for (int base = 1; base <= 10000; base *= 10) {
            // 生成奇数长度回文数
            for (int i = base; i < base * 10; i++) {
                int x = i;
                for (int t = i / 10; t > 0; t /= 10) {
                    x = x * 10 + t % 10;
                }
                pal[palIdx++] = x;
            }
            // 生成偶数长度回文数
            if (base <= 1000) {
                for (int i = base; i < base * 10; i++) {
                    int x = i;
                    for (int t = i; t > 0; t /= 10) {
                        x = x * 10 + t % 10;
                    }
                    pal[palIdx++] = x;
                }
            }
        }
        pal[palIdx++] = 1_000_000_001; // 哨兵，防止下面代码中的 i 下标越界
    }


    long cal(int[]g, int x){
        long ans = 0;
        for(int num: g){
            ans += Math.abs(num-(x));
        }
        return ans;
    }
    public boolean isPalindrome(int x) {
        if(x<0){return false;}
        int res = 0;
        int cur = x;
        while(cur>0){
            res = res*10 + cur%10;
            cur= cur/10;
        }

        return x==res;
    }
    public int maxFrequencyScore(int[] nums, long k) {
        int ans = 0, loc = 0;
        Arrays.sort(nums);
        int n = nums.length;
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += nums[i] - nums[(i+loc)/2];
            while (s>k){
                s += nums[loc] - nums[loc+i+1];
                loc++;
            }
            ans = Math.max(ans, i-loc+1);
        }
        return ans;
    }

}
