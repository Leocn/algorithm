package com.example.demo.atcoder.abc307;

import java.util.Scanner;

public class E {
    static int MOD = 998244353;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt(), m = sc.nextInt();
        long[][] dp = new long[n][2];
        dp[0][1] = m;
        for (int i = 1; i < n; i++) {
            dp[i][0] += dp[i-1][1]*(m-1);
            dp[i][0] += dp[i-1][0] *(m-2);
            dp[i][1]  = dp[i-1][0];
            dp[i][0] %=MOD;
            dp[i][1] %=MOD;
        }
        System.out.println(dp[n-1][0]);

    }
}
