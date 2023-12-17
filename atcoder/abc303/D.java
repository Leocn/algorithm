package com.example.demo.atcoder.abc303;

import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong(), y = sc.nextLong(), z = sc.nextLong();
        char[] cs = sc.next().toCharArray();
        int n = cs.length;
        long[][] dp = new long[n+1][2];
        dp[0][0] = z;
        for (int i = 0; i <n ; i++) {
            if(cs[i]=='a'){
                dp[i+1][0] = Math.min(dp[i][1]+ x+z, dp[i][0] + y);
                dp[i+1][1] = Math.min(dp[i][1]+ x, dp[i][0] + y+z);
            }else {
                dp[i+1][0] = Math.min(dp[i][1]+ y+z, dp[i][0] + x);
                dp[i+1][1] = Math.min(dp[i][1]+ y, dp[i][0] + x+z);
            }
        }
        System.out.println(Math.min(dp[n][0], dp[n][1]));



    }
}
