package com.example.demo.codeforces.ecf136;

import java.math.BigDecimal;
import java.util.Scanner;

public class C {
    static  BigDecimal[][] dp = new BigDecimal[61][3];
    static {
        dp[2][0] = new BigDecimal(1);
        dp[2][1] = new BigDecimal(0);
        dp[2][2] = new BigDecimal(1);
        for (int i = 4; i <=60 ; i+=2) {
            BigDecimal a = new BigDecimal(1);
            for (int j = i-1; j >=i/2+1; j--) {
                a = a.multiply(new BigDecimal(j+""));
            }

            for (int j = 1; j <= i/2-1; j++) {
                a = a.divide(new BigDecimal(j+""));
            }

            BigDecimal all = new BigDecimal(1);
            for (int j = i; j >=i/2+1; j--) {
                all = all.multiply(new BigDecimal(j+""));
            }
            for (int j = 1; j <= i/2; j++) {
                all = all.divide(new BigDecimal(j+""));
            }



            dp[i][0] = dp[i-2][1].add(a);
            dp[i][1] = all.subtract(dp[i][0]).subtract(new BigDecimal(1));
            dp[i][2] = new BigDecimal(1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            BigDecimal a = dp[n][0];
            BigDecimal b = dp[n][1];

            BigDecimal[] d  = a.divideAndRemainder(new BigDecimal(998244353 ));
            BigDecimal[] e  = b.divideAndRemainder(new BigDecimal(998244353 ));

            System.out.println(d[1].intValue() + " " + e[1].intValue() + " "+ dp[n][2].intValue());
        }
    }
}
