package com.example.demo.atcoder.abc280;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        int MOD = 998244353;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long p = sc.nextLong();
        long q = 100 - p;
        long[] dp = new long[n + 1];
        long inv = FermatInv(100, MOD);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = ((p * dp[i - 2] + q * dp[i - 1] +100 )%MOD) *inv %MOD;
        }
        System.out.println(dp[n]);
    }


    static long PowMod(long a, long n, long mod)
    {
        long ret = 1;
        while(n>0)
        {
            if((n & 1)>0) ret = ret * a % mod;
            a = a * a % mod;
            n >>= 1;
        }
        return ret;
    }
    //求a对mod的逆元
    static long FermatInv(long a, long mod)
    {
        return PowMod(a, mod - 2, mod);
    }
}