package com.example.demo.leetcode;

import java.util.*;

public class Week109D {
    public static void main(String[] args) {

    }

    public boolean isGood(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        if(n==1) return false;
        int c = 0;
        for (int num : nums) {
            if (num <= n - 2) {
                set.add(num);
            }
            if (num == n - 1) {
                c++;
            }
        }
        return c == 2 && set.size() == n - 2;

    }

    public String sortVowels(String s) {
        char[] cs = s.toCharArray();

        List<Integer> list = new ArrayList<>();
        List<Character> a = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(cs[i]== 'a' || cs[i]== 'e' || cs[i]== 'i'|| cs[i]== 'o'|| cs[i]== 'u'|| cs[i]== 'A'|| cs[i]== 'E'|| cs[i]== 'I'|| cs[i]== 'O'|| cs[i]== 'U'){
                a.add(cs[i]);
                list.add(i);
            }
        }
        Collections.sort(a);
        for (int i = 0; i < list.size();i++) {
            cs[list.get(i)] = a.get(i);
        }

        return new String(cs);


    }

    public long maxScore(int[] nums, int x) {
        long ans = nums[0];
        int n = nums.length;
        long[][] dp = new long[n][2];
        if(nums[0]%2==0){
            dp[0][0] = nums[0];
            dp[0][1] = Long.MIN_VALUE/2;
        }else {
            dp[0][1] = nums[0];
            dp[0][0] = Long.MIN_VALUE/2;
        }
        for (int i = 1; i < n; i++) {
            if(nums[i]%2==0){
                dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1] - x) + nums[i];
                dp[i][1] = dp[i-1][1];
            }else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - x) + nums[i];
            }
            ans = Math.max(ans, dp[i][0]);
            ans = Math.max(ans, dp[i][1]);
        }
        return ans;


    }
    static long[][][] mem;
   static int mod = (int)1e9+7;
    static  int[][] dp = new int[301][6];


    static {
        mem = new long[301][301][6];
        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 301; j++) {
                Arrays.fill(mem[i][j],-1);
            }


        }
        for(int i=1; i<=300; i++){
            for (int j = 1; j <=5 ; j++) {
                dp[i][j] = (int)dfs(i,j,1);
            }
        }
    }


    public static int numberOfWays(int n, int _x) {
        return dp[n][_x];
    }
    private static long dfs(long n, int x,int  f){
        if(n==0) return 1;
        if(f>n){
            return 0;
        }
        if(mem[(int)n][f][x]!=-1){
            return mem[(int)n][f][x];
        }
        long ans = 0;
        for (int i = f; i <=n ; i++) {
            long p = (long)Math.pow(i,x);
            if(p> n){
                break;
            }
            ans = ans + dfs(n-p, x,i+1)%mod;
        }
        mem[(int)n][f][x] = ans;
        return ans;
    }

}
