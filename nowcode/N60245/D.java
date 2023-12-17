package com.example.demo.nowcode.N60245;


import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cs = sc.next().toCharArray();
        int n = cs.length;
        int MOD = (int) 1e9+7;
        if(n==0){
            System.out.println(0);
            return;
        }

        long[][] dp = new long[n+1][9];
        dp[1][cs[0]-'0']++;
        for (int i = 1; i <n; i++) {
            int c = cs[i]-'0';
            for (int j = 0; j < 9; j++) {
                dp[i+1][j] = dp[i][j];
            }
            dp[i+1][c%9]++;
            for (int j = 0; j < 9; j++) {
                dp[i+1][(c+j*10)%9] = (dp[i+1][(c+j*10)%9]+ dp[i][j])%MOD;

            }
        }
        System.out.println(dp[n][0]%MOD);

    }
}
