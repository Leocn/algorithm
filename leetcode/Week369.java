package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Week369 {
    public static void main(String[] args) {

    }

    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for(int num: nums){
                if((num&(1<<i)) == (1<<i)){
                    cnt ++;
                }
            }
            if(cnt>=k){
                ans += 1<<i;
            }
        }
        return  ans;
    }


    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        int c1 = 0;
        for(int num: nums1){
            if(num == 0){
                sum1+=1;
                c1++;
            }else {
                sum1+=num;
            }
        }
        long sum2 = 0;
        int c2 = 0;
        for(int num:nums2){
            if(num==0){
                sum2 += 1;
                c2 ++;
            }else {
                sum2 += num;
            }
        }
        if(sum1<sum2&&c1 ==0){
            return -1;
        }

        if(sum2<sum1 && c2 ==0){
            return -1;
        }
        return Math.max(sum1, sum2);

    }

    public long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n+1];
        Arrays.fill(dp,Long.MAX_VALUE/4);
        dp[0] = 0;
        long[] cnt = new long[n];

        for (int i = 0; i < n; i++) {
            cnt[i] = Math.max(0, k-nums[i]);
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < 3; j++) {
                 dp[i+1] = Math.min(dp[i+1], cnt[i] + dp[Math.max(0, i-j)] );
            }

        }
        return dp[n];
    }

    int[][] mem;
    int k;
    public int maximumPoints(int[][] edges, int[] coins, int _k) {
        k = _k;
        int n = coins.length;
        mem = new int[n][20];
        for(int[] m: mem){
            Arrays.fill(m,-1);
        }
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] e:edges){
            int a = e[0], b= e[1];
            g[a].add(b);
            g[b].add(a);
        }

        return dfs(0, -1, g, coins, 0);

    }
    private int dfs(int cur, int p, ArrayList<Integer>[] g, int[] coins, int cnt){
        if(mem[cur][cnt]!=-1){
            return mem[cur][cnt];
        }
        int res = coins[cur] / (1<<cnt), resA = coins[cur]- k;
        for(int next : g[cur]){
            if(next==p){
                continue;
            }
            if(cnt>19){
                res += dfs(next, cur, g, coins, cnt);
            }else {
                res += dfs(next, cur, g, coins, cnt+1);
                resA += dfs(next, cur, g, coins, cnt);
            }


        }
        mem[cur][cnt] = Math.max(res, resA);
        return mem[cur][cnt];
    }
}
