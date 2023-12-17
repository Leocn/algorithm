package com.example.demo.atcoder.abc281;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        //前i个数余数为l的j个数最大值
        long[][][] dp = new long[n+1][k+1][d];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], -1);

            }
        }
        dp[0][0][0] = 0;

        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            for (int j = 0; j < Math.min(k,i+1); j++) {

                System.arraycopy(dp[i][j + 1], 0, dp[i + 1][j + 1], 0, d);
                for (int l = 0; l < d; l++) {
                    if( dp[i][j][l]==-1){
                        continue;
                    }
                    int t = (int)((arr[i] +  l)%d);
                    dp[i+1][j+1][t] = Math.max(dp[i+1][j+1][t], dp[i][j][l] + arr[i]);
                }
            }

        }
        if(dp[n][k][0]<0){
            System.out.println("-1");
        }else {
            System.out.println(dp[n][k][0]) ;
        }

    }
}
