package com.example.demo.leetcode;

import java.util.Arrays;

public class Week353 {
    public static void main(String[] args) {
        checkArray(new int[]{2,2,3,1,1,0},3);
    }

    public int theMaximumAchievableX(int num, int t) {
        return num + 2*t;
    }

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n+1];
        for (int i = 1; i < n; i++) {
            long t =  nums[i]-nums[0];
            if(t>=-target && t<=target){
                dp[i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                long t =  nums[j]-nums[i];
                if(t>=-target && t<=target && dp[i]>0){
                    dp[j] = Math.max(dp[i]+1,dp[j]);
                }
            }
        }
        return dp[n-1] == 0?-1:dp[n-1];
    }

    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length, ans = 1;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],1);
        }
        for (int i = 1; i < n; i++) {
            if(nums1[i]>=nums1[i-1]){
                dp[i][0] = Math.max(dp[i-1][0]+1, dp[i][0]);
            }
            if(nums1[i]>=nums2[i-1]){
                dp[i][0] = Math.max(dp[i-1][1]+1, dp[i][0]);
            }

            if(nums2[i]>=nums1[i-1]){
                dp[i][1] = Math.max(dp[i-1][0]+1, dp[i][1]);
            }
            if(nums2[i]>=nums2[i-1]){
                dp[i][1] = Math.max(dp[i-1][1]+1, dp[i][1]);
            }
            ans = Math.max(dp[i][1], ans);
            ans = Math.max(dp[i][0], ans);

        }
        return ans;
    }


    public static boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        long[] cnt = new long[n+1];
        cnt[0] = -nums[0];
        cnt[k] = nums[0];
        long sum = cnt[0];
        for (int i = 1; i < n-k; i++) {
            sum += cnt[i];
            long d = sum+ nums[i];
            cnt[i]-= d;
            cnt[i+k] += d;
            sum -=d;
        }
        for (int i = n-k; i < n; i++) {
            sum += cnt[i];
            nums[i]+=sum;
        }
        for (int i = n-k; i <n-1 ; i++) {
            if(nums[i]!=nums[i+1]) return false;
        }
        return true;
    }
}
