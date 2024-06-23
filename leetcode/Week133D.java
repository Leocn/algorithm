package com.example.demo.leetcode;

import java.util.Arrays;

public class Week133D {
    public static void main(String[] args) {

    }

    public int minimumOperations(int[] nums) {
        int ans = 0;
        for(int n: nums){
            ans += Math.min(n%3, 3-n%3);
        }
        return ans;
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if((nums[i] == 1 && (c&1)==0) || (nums[i] == 0 && (c&1)==1)) continue;
            ans ++;
            c++;
        }
        return ans;

    }
    int mod = (int)1e9+7;
    public int numberOfPermutations(int n, int[][] requirements) {
        int[] cnt = new int[n];
        Arrays.fill(cnt, -1);
        for(int[] r: requirements){
            cnt[r[0]] = r[1];
        }

        int max = 401;
        long[][] dp = new long[n+1][max];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            int l = 0, r = 400;
            if(cnt[i]!=-1){
                l = cnt[i];
                r = cnt[i];
            }
            for (int j = l; j <=r ; j++) {
                for (int k = 0; k <=j && k<= i ; k++) {
                    dp[i+1][j] =  (dp[i+1][j] +  dp[i][j-k])%mod;
                }

            }
        }
        return (int)(dp[n][cnt[n-1]]%mod);
    }
}
