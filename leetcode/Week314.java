package com.example.demo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Week314 {
    public static void main(String[] args) {

    }

    public int hardestWorker(int n, int[][] logs) {
        int ans = logs[0][0];
        int min = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            int tem = logs[i][1]-logs[i-1][1];
            if(tem>min){

                min = tem;

                ans = logs[i][0];
            }else if(tem == min){
                ans = Math.min(ans, logs[i][0]);
            }
        }
        return ans;
    }

    public int[] findArray(int[] pref) {
        int n  = pref.length;
        int[] ans = new int[n];
        ans[0] = pref[0];
        for(int i = 1; i<n ;i++){
            ans[i] = pref[i-1]^pref[i];
        }
        return ans;
    }
    public String robotWithString(String s) {
        int[] sum = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            sum[c - 'a']++;
        }
        int min = 0;
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            int loc = c - 'a';
            sum[loc]--;
            deque.push(c);
            while (min<25 && sum[min]==0) {
                min++;
            }
            while (deque.size()>0 && deque.peekFirst()-'a'<=min){
                sb.append(deque.pop());
            }
        }
        return sb.toString();

    }
    /**
     * 超时
     * */
//    int k = 0;
//    int[][] g;
//    int MOD = (int)1e9+7;
//    public int numberOfPaths(int[][] grid, int _k) {
//        int ans = 0;
//        int n = grid.length;
//        int m = grid[0].length;
//        g = new int[n][m];
//        k = _k;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                g[i][j] = grid[i][j]%k;
//            }
//        }
//
//
//        ans = (dfs(n-1, m-1, 0))%MOD;
//        return  ans;
//
//    }
//    private  int dfs(int x, int y, int sum){
//        if(x<0|| y<0){
//            return 0;
//        }
//        if(x==0 && y==0 ){
//            return (sum+k -g[x][y])%k==0?1:0;
//        }
//        return (dfs(x-1, y, (sum+k -g[x][y])%k))%MOD + (dfs(x, y-1, (sum+k -g[x][y])%k))%MOD;
//    }


    int MOD = (int)1e9+7;

    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp  = new int[n][m][k];
        dp[0][0][grid[0][0]%k]=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int u = 0; u < k; u++) {
                    if (j + 1 < m) {
                        int t = (u + grid[i][j + 1]) % k;
                        dp[i][j + 1][t] =
                                (dp[i][j + 1][t] + dp[i][j][u]) % MOD;
                    }
                    if (i + 1 < n) {
                        int t = (u + grid[i + 1][j]) % k;
                        dp[i + 1][j][t] =
                                (dp[i + 1][j][t] + dp[i][j][u]) % MOD;
                    }
                }
            }
        }
        return dp[n - 1][m - 1][0];
    }
}
