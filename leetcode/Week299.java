package com.example.demo.leetcode;

public class Week299 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        for (int i = 0; i < n  ; i++) {
            vis[i][i] = true;
            vis[i][n-i-1] = true;
            if(grid[i][i] ==0 || grid[i][n-i-1] ==0 ){
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(vis[i][j]) continue;
                if(grid[i][j]!=0) return false;
            }
        }
        return  true;
    }

    int MOD = (int) 1e9+7;
//    public int countHousePlacements(int n) {
//        int[][] dp = new int[n+1][n+1];
//        dp[1][1] = 1;
//        for(int i =2; i<=n; i++){
//            for(int j=1; j<=(i+1)/2; i++){
//                dp[i][j] = dp[i-1][j]
//
//            }
//        }
//    }
}
