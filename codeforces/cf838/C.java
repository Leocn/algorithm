package com.example.demo.codeforces.cf838;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        int MOD = 998244353;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            char[] cs = sc.next().toCharArray();
            long[] dp = new long[n];
            dp[0] = 1;
            long ans = 1;
            for (int i = 1; i < n; i++) {
                if(cs[i] == cs[i-1]){
                    dp[i] = (2*dp[i-1])%MOD;
                }else {
                    dp[i] = 1 ;
                }
                ans  = (ans+dp[i])%MOD;
            }
            System.out.println(ans);
        }
    }
}
