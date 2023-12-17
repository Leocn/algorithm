package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Week300 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char start = 'a';
        map.put(' ', ' ');
        for(char c : key.toCharArray()){
            if(!map.containsKey(c)){
                map. put(c, start++);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char c: message.toCharArray()){
            ans.append(map.get(c));
        }
        return new String(ans);
    }
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        //每位都赋值-1
        for(int i=0; i<ans.length; i++){
            Arrays.fill(ans[i], -1);
        }
        //起始方向
        int direction = 0;
        //起始位置
        int x = 0, y = -1;
        //每个方向
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(head!=null){
            int[] now = directions[direction];
            x += now[0];
            y += now[1];
            //如果超出方向，则转到下个方向
            if(x>=m || x<0 || y >=n || y<0 || ans[x][y]!=-1){
                if(direction==3){
                    direction =0;
                }else{
                    direction++;
                }
                x -= now[0];
                y -= now[1];
                int[] newD = directions[direction];
                x += newD[0];
                y += newD[1];
            }
            ans[x][y] = head.val;
            head = head.next;
        }
        return ans;
    }


    private static final int MOD = (int)1e9+7;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            long t = i >= delay ? dp[i - delay] : 0;
            t -= i >= forget ? dp[i - forget] : 0 ;
            t += MOD;
            dp[i] = (dp[i - 1] + t ) % MOD;
        }
        return (int)(dp[n] - dp[n - forget] +MOD) % MOD;

    }

    int[][] dp;
    int[][] g;
    int m, n;
    int ans = 0;
    int[][] dirs =new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        g = grid;
        dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i =0; i<m; i++){
            for (int j = 0; j < n; j++) {
                ans = (ans + dfs(i,j))%MOD;
            }
        }
        return  ans;

    }
    private int dfs(int i, int j){
        if(dp[i][j]!=-1){
            return  dp[i][j];
        }
        int res = 1;
        for(int[] d: dirs){
            int x = d[0] + i, y = d[1] + j;
            if(x>=0 && x<m && y>=0 && y<n && g[x][y]> g[i][j]){
                res =  (res + dfs(x,y))%MOD;
            }

        }
        dp[i][j] = res;
        return res;
    }

}
