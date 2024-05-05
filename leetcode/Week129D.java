package com.example.demo.leetcode;

import java.util.Arrays;
public class Week129D {

    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int a = 0;
                for (int k = i; k <i+2 ; k++) {
                    for (int l = j; l < j +2 ; l++) {
                        if(grid[k][l] == 'B'){
                            a++;
                        }
                    }
                }
                if(a == 0 || a == 4 || a == 1 || a == 3 ){
                    return true;
                }
            }
        }
        return false;
    }

    public long numberOfRightTriangles(int[][] grid) {
        long ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        long[][] pre = new long[n+1][m];
        long[][] suf = new long[n][m+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[j+1][i] = pre[j][i] + grid[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                suf[i][j+1] = suf[i][j] + grid[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 0) continue;
                ans += (pre[n][j]-grid[i][j])*(suf[i][m] - grid[i][j]);
            }
        }

        return ans;
    }


//    int mod = (int)1e9+7;
//    long[][][][] dp;
//    public int numberOfStableArrays(int zero, int one, int limit) {
//        dp = new long[zero+2][one+2][2][limit+2];
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                for (int k = 0; k < dp[0][0].length; k++) {
//                    Arrays.fill(dp[i][j][k],-1);
//                }
//            }
//        }
//
//        long ans = dfs(zero, one-1, 1,1, limit) + dfs(zero-1, one, 0,1, limit);
//        return (int)(ans%mod);
//    }
//
//    private long dfs(int zero, int one, int now, int size, int limit ){
//        String s = zero + " " + one + " " + now + " " + size;
//        if(dp[zero][one][now][size]!=-1){
//            return dp[zero][one][now][size];
//        }
//        if(zero == 0 && one == 0){
//
//            return 1;
//        }
//        long res = 0;
//        if(size<limit){
//            if(now == 1 ){
//                if(one> 0){
//                    res = (res + dfs(zero, one -1, 1, size + 1, limit))%mod;
//                }
//                if(zero>0){
//                    res = (res + dfs(zero-1, one , 0, 1, limit))%mod;
//                }
//
//            }else {
//                if(zero >0){
//                    res = (res + dfs(zero-1, one, 0, size + 1, limit))%mod;
//                }
//                if(one>0){
//                    res = (res + dfs(zero, one-1 , 1, 1, limit))%mod;
//                }
//            }
//
//
//
//        }else if(size== limit){
//            if(now == 1){
//                if(zero>0){
//                    res = (res + dfs(zero-1, one , 0, 1, limit))%mod;
//                }
//            }else{
//                if(one>0){
//                    res = (res + dfs(zero, one-1 , 1, 1, limit))%mod;
//                }
//            }
//        }
//
//        dp[zero][one][now][size] = res;
//        return res;
//    }
    int mod = (int)1e9+7;
    int limit;
    long[][][] dp;
    public int numberOfStableArrays(int zero, int one, int l) {
        limit = l;
        dp = new long[zero+1][one+1][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return (int)((dfs(zero, one, 0) + dfs(zero, one, 1))%mod);
    }
    private long dfs(int z, int o, int k){
        if(z<0 || o<0){
            return  0;
        }
        if(dp[z][o][k]!=-1){
            return dp[z][o][k];
        }
        if(z==0 ){
            return ((k==1 && o>limit) || (k==0))?0:1;
        }
        if(o == 0){
            return  ((k==0 && z>limit) || (k==1))?0:1;
        }

        long res = 0;
        if(k==1){
            res = (dfs(z, o-1, 1)  + dfs(z, o-1, 0) - dfs(z,o-limit-1, 0))%mod;
        }else {
            res = (dfs(z-1, o, 1)  + dfs(z-1, o, 0) - dfs(z-limit-1,o, 1))%mod;
        }
        return dp[z][o][k] = (res + mod)%mod;
    }

}
