package com.example.demo.atcoder.abc311;

import java.util.Scanner;


public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        boolean[][] st = new boolean[n + 5][m + 5];
        long[][] dp = new long[n + 5][m + 5];
        for (int i = 1; i <= p; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            st[a][b] = true;
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!st[i][j]) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    res += dp[i][j];
                }
            }
        }
        System.out.println(res);

    }
}

