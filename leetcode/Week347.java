package com.example.demo.leetcode;

import java.util.*;

public class Week347 {
    public static void main(String[] args) {

    }
    public String removeTrailingZeros(String num) {
        char[] cs = num.toCharArray();
        int n = cs.length;
        if(n==1){
            return num;
        }
        for(int i=n-1; i>=0 ;i--){
            if(cs[i] == '0'){
            }else {
                return num.substring(0, i+1);
            }
        }
        return "";
    }

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = i, y = j;
                Set<Integer> set = new HashSet<>();
                while (x>0 && y>0){
                    set.add(grid[x-1][y-1]);
                    x--;
                    y--;
                }
                Set<Integer> set2 = new HashSet<>();
                int x1 = i, y1 = j;
                while (x1<n-1 && y1<m-1){
                    set2.add(grid[x+1][y+1]);
                    x1++;
                    y1++;
                }
                ans[i][j] = Math.abs(set.size()-set2.size());

            }
        }
        return ans;

    }


    public long minimumCost(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        long ans = Long.MAX_VALUE;
        long[][] dp = new long[n+1][2];
        for (int i = 0; i < n; i++) {
            if(cs[i]=='0'){
                dp[i+1][0] = Math.min(dp[i][0], dp[i][1]+i );
                dp[i+1][1] = Math.min(dp[i][0]+i+1, dp[i][1]+i+i+1 );
            }else {
                dp[i+1][0] = Math.min(dp[i][0]+i+i+1, dp[i][1]+i+1 );
                dp[i+1][1] = Math.min(dp[i][0]+i, dp[i][1] );
            }
        }
        long[][] dp2 = new long[n+1][2];
        for (int i = n-1; i >=0 ; i--) {
            if(cs[i]=='0'){
                dp2[i][0] = Math.min(dp2[i+1][0], dp2[i+1][1]+n-i-1 );
                dp2[i][1] = Math.min(dp2[i+1][0]+n-i, dp2[i+1][1]+n-i-1 + n-i );
            }else {
                dp2[i][0] = Math.min(dp2[i+1][0]+n-i-1 + n-i , dp2[i+1][1]+n-i);
                dp2[i][1] = Math.min(dp2[i+1][0]+n-i-1, dp2[i+1][1] );
            }
        }
        for (int i = 0; i <=n; i++) {
            ans = Math.min(ans, dp[i][0]+ dp2[i][0]);
            ans = Math.min(ans, dp[i][1]+ dp2[i][1]);
        }
        return ans;
    }

    public int maxIncreasingCells(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        TreeMap<Integer, ArrayList<int[]>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.putIfAbsent(mat[i][j], new ArrayList<>());
                map.get(mat[i][j]).add(new int[]{i,j});
            }
        }
        int[] sum = new int[n];
        int[] cnt = new int[m];
        int ans = 0;
        for(Map.Entry<Integer, ArrayList<int[]>> e: map.entrySet()){

            Map<Integer, Integer> mapR = new HashMap<>();
            Map<Integer, Integer> mapC = new HashMap<>();
            for(int[] next : e.getValue()){
                int max = Math.max(cnt[next[1]]+1,sum[next[0]]+1);
                ans = Math.max(ans, max);
                sum[next[0]] = Math.max(sum[next[0]], max);
                cnt[next[1]] = Math.max(cnt[next[1]], max);

            }
//            for(Map.Entry<Integer, Integer> entry: mapR.entrySet()){
//                sum[entry.getKey()] = entry.getValue();
//                ans = Math.max(sum[entry.getKey()], ans);
//
//            }
//            for(Map.Entry<Integer, Integer> entry: mapC.entrySet()){
//                cnt[entry.getKey()] = entry.getValue();
//                ans = Math.max(cnt[entry.getKey()], ans);
//
//            }

        }
        return ans;


    }


}
