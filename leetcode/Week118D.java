package com.example.demo.leetcode;


import javax.print.DocFlavor;
import java.util.*;

public class Week118D {
    public static void main(String[] args) {

    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int k = 0; k < words.length ; k++) {
            String s = words[k];
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if(cs[i] == x){
                    set.add(k);
                }
            }
        }

        ans = new ArrayList<>(set);
        return ans;
    }


    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        //Arrays.sort(hBars);
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(n+2);
        for(int h : hBars){
            a.add(h);
        }

        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(m+2);
        for(int v : vBars){
            b.add(v);
        }

        Collections.sort(a);
        Collections.sort(b);

        int s = a.size();
        int maxA = 0;
        for (int i = 0; i <s ; i++) {
            int j = i+1;
            while (j<s && a.get(j) == a.get(j-1)+1){
                j++;
            }
            maxA = Math.max(j-i, maxA);
            i = j-1;
        }

        s = b.size();
        int maxB = 0;

        for (int i = 0; i <s ; i++) {
            int j = i+1;
            while (j<s && b.get(j) == b.get(j-1)+1){
                j++;
            }
            maxB = Math.max(j-i, maxB);
            i = j-1;
        }
        System.out.println(maxA);
        System.out.println(maxB);

        int ans = Math.min(maxA, maxB) - 1;
        return  ans*ans;

    }

    public int minimumCoins(int[] prices) {
        int ans = 0;
        int n = prices.length;
        long[][] dp = new long[n][2];
        for(long[] d: dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dp[0][0] = prices[0];
        dp[0][1] = Integer.MAX_VALUE;
        for (int i = 1; i <n ; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(j+(j+1)>=i){
                    dp[i][1] = Math.min(dp[j][0],dp[i][1]);
                }

            }
            dp[i][0] = Math.min(dp[i-1][0] ,dp[i-1][0])+ prices[i];

        }
        return(int) Math.min(dp[n-1][0], dp[n-1][1]);
    }


    public static int findMaximumLength(int[] a) {
        int n = a.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + a[i];
        }

        long[] f = new long[n + 1];
        int[] pre = new int[n + 2];
        int j = 0;
        for (int i = 1; i <= n; i++) {
            j = Math.max(j, pre[i]);
            f[i] = f[j] + 1;
            int k = Arrays.binarySearch(sum, sum[i] * 2 - sum[j]);
            if (k < 0) {
                k = -(k + 1);
            }
            pre[k] = i;
        }
        return (int)(f[n]);
    }

}
