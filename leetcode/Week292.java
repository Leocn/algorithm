package com.example.demo.leetcode;

import java.util.Arrays;

public class Week292 {
    public String largestGoodInteger(String num) {
        char c = '+';
        int n = num.length();
        char[] cs = num.toCharArray();
        for (int i = 0; i < n-2; i++) {
            if(cs[i] == cs[i+1] && cs[i+1] == cs[i+2]){
                if(cs[i]-c>=0){
                    c = cs[i];
                }
            }
        }
        return c=='+'? "" :(c+"").repeat(3);
    }

    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return  res;
    }
    private int[] dfs(TreeNode root){
        if(root==null){
            return new int[2];
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if((left[0]+right[0] + root.val)/(left[1]+right[1]+1) == root.val){
            res++;
        }
        return new int[]{left[0]+right[0] + root.val, left[1]+right[1]+1};
    }

    int MOD = (int)1e9+7;
    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=n ; i++) {
            dp[i] =( (dp[i-1] + dp[i-2])%MOD + dp[i-3])%MOD;
        }
        long[] dp2 = new long[n+1];
        dp2[0] = 1;
        dp2[1] = 1;
        dp2[2] = 2;
        dp2[3] = 4;
        for (int i = 4; i <n ; i++) {
            dp2[i] = ((dp2[i-4] + dp2[i-3])%MOD + (dp2[i-2] + dp2[i-1])%MOD)%MOD;
        }
        long ans = 1;
        for (int i = 0; i <n ; i++) {
            int cnt = 1;
            while (i<n-1&& pressedKeys.charAt(i) == pressedKeys.charAt(i+1)){
                cnt++;
                i++;
            }
            if(pressedKeys.charAt(i)=='7' || pressedKeys.charAt(i)=='9'){
                ans = (ans*dp2[cnt])%MOD;
            }else {
                ans = (ans*dp[cnt])%MOD;
            }
        }
        return  (int)ans;
    }


    class Solution {
        int[][] record;
        int[][] record2;
        public boolean hasValidPath(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            if((m + n) % 2 == 0 || grid[0][0] == ')' || grid[n-1][m-1] == '('){
                return false;
            }
            record = new int[n+1][m+1];
            Arrays.fill(record[0], -1000);
            for(int i=0; i<n; i++){
                record[i][0] = -1000;
            }
            record[1][1] = 1;
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <m ; j++) {
                    if(i==0 && j==0) continue;
                    int next =( grid[i][j]=='('?1:-1);
                    record[i+1][j+1] = Math.max(record[i][j+1], record[i+1][j])+next;
                    if(record[i+1][j+1]<0){
                        record[i+1][j+1] = -1000;
                    }
                }
            }
            if(record[n][m]<0){
                return false;
            }

            return dfs(n-1, m-1, 1, grid);


        }
        private boolean dfs(int x, int y, int cnt , char[][] grid){
            // if(x>0 &&record[x][y+1]-cnt<0 && y>0 && record[x+1][y]-cnt<0){
            //     return false;
            // }
            if(cnt <0){
                return false;
            }
            if(x==0 && y==0 && cnt==0){
                return true;
            }

            if(x>0){
                char c = grid[x-1][y];
                int next =( c=='('?-1:1);
                if(record[x][y+1]-cnt<0){
                    return false;
                }
                if(dfs(x-1, y, cnt+next,grid)){
                    //System.out.println(x + " " + y+ " " + cnt);
                    return true;

                }
            }
            if(y>0){
                char c = grid[x][y-1];
                int next =( c=='('?-1:1);
                if(record[x+1][y]-cnt<0){
                    return false;
                }
                if(dfs(x, y - 1, cnt + next, grid)){
                    //System.out.println(x + " " + y + " " + cnt);
                    return true;
                }

            }
            return false;

        }
    }
}
