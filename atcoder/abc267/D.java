package com.example.demo.atcoder.abc267;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <=n; i++) {
            arr[i] = sc.nextInt();
        }
        if(n==1){
            System.out.println(arr[1]);
            return;
        }
        long ans = Long.MIN_VALUE;
        long[][] dp = new long[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
           dp[i][1] = arr[i];
        }

        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j <=Math.min(i,m) ; j++) {
                if(j<=i-1){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + (long) j *arr[i]);
                }else{
                    dp[i][j] =  dp[i-1][j-1] + (long) j *arr[i];
                }

                if(j==m){
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.println(ans);

    }
}
