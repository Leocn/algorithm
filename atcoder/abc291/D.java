package com.example.demo.atcoder.abc291;

import java.util.Scanner;

public class D {
    static int mod = 998244353;
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int arrA[] = new int[n];
        int arrB[] = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
            arrB[i] = sc.nextInt();

        }
        long[][] dp = new long[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i <n ; i++) {
            if(arrA[i]!=arrA[i-1]){
                dp[i][0] += dp[i-1][0];
            }
            if(arrA[i]!=arrB[i-1]){
                dp[i][0] += dp[i-1][1];
            }
            if(arrB[i]!=arrA[i-1]){
                dp[i][1] += dp[i-1][0];
            }
            if(arrB[i]!=arrB[i-1]){
                dp[i][1] += dp[i-1][1];
            }
            dp[i][0]= dp[i][0]%mod;
            dp[i][1]= dp[i][1]%mod;
        }
        long ans  = (dp[n-1][0] + dp[n-1][1])%mod;
        System.out.println(ans);


    }
}
