package com.example.demo.leetcode;

import java.util.Arrays;

public class Week104D {
    public static void main(String[] args) {

    }

    public int countSeniors(String[] details) {
        int ans = 0;
        for(String d: details){
            int a = Integer.valueOf(d.substring(11,13));
            if(a>60) ans++;
        }
        return ans;
    }

    public int matrixSum(int[][] nums) {
        int ans = 0;
        int n = nums.length;
        int m = nums[0].length;
        for(int[] num : nums){
            Arrays.sort(num);
        }
        for (int i = 0; i < m; i++) {
            int max = -1;
            for (int j = 0; j < n; j++) {
                max = Math.max(nums[j][i], max);
            }
            ans += max;
        }
        return ans;

    }

    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        int[][] record = new int[n][32];
        int[] sum = new int[32];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int loc = 0;
            while (num>0){
                record[i][loc] = num%2;
                sum[loc++] += num%2;
                num/=2;
            }
        }
        for (int i = 0; i < n; i++) {
            long m = nums[i];
            for (int j = 0; j < k; j++) {
                m*=2;
            }
            for (int j = 0; j < 32; j++) {
                if(sum[j]-record[i][j]>0){
                    m|= (1L<<j);
                }
            }
            ans = Math.max(m, ans);
        }
        return ans;

    }

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int MOD = (int)1E9+7;
        int n = nums.length;
        long ans = 0;
        for(int num:nums){
            long m = (long)num*num%MOD;
            m = m*num%MOD;
            ans = (ans+m)%MOD;
        }

        long sum =0;
        sum = nums[0];
        for (int i = 1; i <n ; i++) {
            ans = (ans + ((long)nums[i] * nums[i]%MOD) * sum%MOD)%MOD;

            sum = sum*2 %MOD;
            sum= (sum + nums[i])%MOD;
        }

        return (int)ans;


    }
}
