package com.example.demo.leetcode;

import java.util.Arrays;

public class Week403 {
    public static void main(String[] args) {

    }

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double min = Double.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, ((double) (nums[i]) + nums[nums.length-1-i])/2);
        }
        return min;
    }

    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int t = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1){
                    l = Math.min(j, l);
                    r = Math.max(j, r);
                    t = Math.min(i, t);
                    b = Math.max(i, b);
                }
            }
        }
        return (r-l+1)*(b-t+1);
    }

    public long maximumTotalCost(int[] nums) {
        long now = nums[0];
        int n = nums.length;
        long[][] dp = new long[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i <n ; i++) {
            dp[i][0] = Math.max(dp[i-1][1] - nums[i], dp[i-1][0] + nums[i]);
            dp[i][1] = dp[i-1][0] + nums[i];

        }
        return Math.max(dp[n-1][0] , dp[n-1][1]);
    }

    public int minimumSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            int f = cal(grid, 0, i, 0, m-1);

            for (int j = i+1; j <n-1 ; j++) {
                int sec = cal(grid, i+1, j, 0, m-1);
                int three = cal(grid, j+1, n-1, 0, m-1);
                ans = Math.min(ans, (f==0?1:f) + (sec==0?1:sec) + (three==0?1:three));
            }

            for (int j = 0; j <m-1 ; j++) {
                int sec = cal(grid, i+1, n-1, 0, j);
                int three = cal(grid, i+1, n-1, j+1, m-1);
                ans = Math.min(ans, (f==0?1:f) + (sec==0?1:sec) + (three==0?1:three));
            }

            f = cal(grid, i+1,n-1 , 0, m-1);
            for (int j = 0; j < m-1; j++) {
                int sec = cal(grid, 0, i, 0, j);
                int three = cal(grid, 0, i, j+1, m-1);
                ans = Math.min(ans, (f==0?1:f) + (sec==0?1:sec) + (three==0?1:three));
            }
        }

        for (int j = 0; j < m-1; j++) {


            int f = cal(grid, 0, n-1, 0, j);
            for (int i = j+1; i <m-1 ; i++) {
                int sec = cal(grid, 0, n-1, j+1, i);
                int three = cal(grid, 0, n-1, i+1, m-1);
                ans = Math.min(ans, (f==0?1:f) + (sec==0?1:sec) + (three==0?1:three));
            }

            for (int i = 0; i < n-1; i++) {
                int sec = cal(grid, 0, i, j+1, m-1);
                int three = cal(grid, i+1, n-1, j+1, m-1);
                ans = Math.min(ans, (f==0?1:f) + (sec==0?1:sec) + (three==0?1:three));
            }

            f = cal(grid, 0,n-1, j+1, m-1);

            for (int i = 0; i < n-1; i++) {
                int sec = cal(grid, 0, i, 0, j);
                int three = cal(grid, i+1, n-1, 0, j);
                ans = Math.min(ans, (f==0?1:f) + (sec==0?1:sec) + (three==0?1:three));
            }

        }
        return ans;

    }


    public int cal(int[][] grid, int T , int B, int L, int R) {
        int n = grid.length;
        int m = grid[0].length;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int t = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;

        for (int i = T; i <= B; i++) {
            for (int j = L; j <= R; j++) {
                if(grid[i][j] == 1){
                    l = Math.min(j, l);
                    r = Math.max(j, r);
                    t = Math.min(i, t);
                    b = Math.max(i, b);
                }
            }
        }
        return (r-l+1)*(b-t+1);
    }
}
