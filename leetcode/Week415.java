package com.example.demo.leetcode;

import java.util.*;

public class Week415 {
    public static void main(String[] args) {

    }
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] ans = new int[2];
        int loc = 0;
        for (int i = 0; i < n-1; i++) {
            if(nums[i] == nums[i+1]){
                ans[loc++] = nums[i];
            }
        }
        return ans;
    }

    public long maxScore(int[] a, int[] b) {
        long ans = Long.MIN_VALUE/10;
        long[] dp = new long[4];
        int n = b.length;
        Arrays.fill(dp, Long.MIN_VALUE/10);
        dp[0] = (long)a[0] * b[0];
        for (int i =1; i<n; i++) {
            for (int j = Math.min(3,i); j >=0 ; j--) {
                if(j>0){
                    dp[j] = Math.max(dp[j-1] + (long)a[j] * b[i], dp[j]);
                }else {
                    dp[j] = Math.max( (long)a[j] * b[i], dp[j]);
                }

            }
            ans = Math.max(dp[3], ans);
        }
        return ans;
    }

    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        Set<Integer>[] g = new Set[n];
        for (int i = 0; i < n; i++) {
            g[i] = new HashSet<>();
        }
        for(String w:words){
            help(w, g, target);
        }
        int[] f = new int[n+1];
        Arrays.fill(f, Integer.MAX_VALUE/10);
        f[0] = 0;
        for (int i = 1; i < n+1; i++) {
            for(int j : g[i-1]){
                if(f[i-j] + 1< f[i]){
                    f[i] = f[i-j] + 1;
                }
            }
        }
        return f[n]<=n?f[n]:-1;
    }
    private void help(String word, Set<Integer>[] g, String target){
        String s = word + "$" + target;
        int k = word.length();
        int m = s.length();
        int[] pi = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j>0 && s.charAt(i)!=s.charAt(j)){
                j = pi[j-1];
            }
            j += s.charAt(i) == s.charAt(j)?1:0;
            pi[i] = j;
            if(i>k && j>0){
                g[i-k-1].add(j);
            }
        }
    }

}
