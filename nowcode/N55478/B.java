package com.example.demo.nowcode.N55478;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int MOD = (int)1E9 + 7;
        int[] dp = new int[1000000+2];
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 0; i < 1000000; i++) {
            dp[i+2] = (2*dp[i]%MOD + dp[i+1]%MOD)%MOD;
        }

        while (t-->0){
            int n = sc.nextInt();
            System.out.println(dp[n-1]%MOD);
        }
    }
}
