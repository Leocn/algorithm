package com.example.demo.codeforces.CF991;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        char[][] arr = new char[2][n];
        arr[0] = str.toCharArray();
        arr[1] = sc.next().toCharArray();
        int[][] dp = new int[n][4];
        Arrays.fill(dp[0],Integer.MIN_VALUE);
        if(arr[0][0] == 'X' && arr[1][0] =='X'){
            dp[0][3] = 0;
        }else if(arr[0][0]=='X') {
            dp[0][1] = 0;
        }else if(arr[1][0]=='X'){
            dp[0][2] = 0;
        }else {
            dp[0][0] = 0;
        }
        for (int i = 1; i < n; i++) {
            if(arr[0][i] == 'X' && arr[1][i] =='X'){
                dp[i][3] =  Math.max(dp[i-1][3], Math.max(dp[i-1][2], Math.max(dp[i-1][0], dp[i-1][1])));
                dp[i][1] = Integer.MIN_VALUE;
                dp[i][2] = Integer.MIN_VALUE;
                dp[i][0] = Integer.MIN_VALUE;
            }else if(arr[0][i]=='X'){
                dp[i][1] = Math.max(dp[i-1][3], Math.max(dp[i-1][2], Math.max(dp[i-1][0], dp[i-1][1])));
                dp[i][3] = dp[i-1][0] + 1;
                dp[i][2] = Integer.MIN_VALUE;
                dp[i][0] = Integer.MIN_VALUE;

            }else if(arr[1][i]=='X'){
                dp[i][2] = Math.max(dp[i-1][3], Math.max(dp[i-1][2], Math.max(dp[i-1][0], dp[i-1][1])));
                dp[i][3] = dp[i-1][0] + 1;
                dp[i][1] = Integer.MIN_VALUE;
                dp[i][0] = Integer.MIN_VALUE;
            }else {
                dp[i][0] = Math.max(dp[i-1][3], Math.max(dp[i-1][2], Math.max(dp[i-1][0], dp[i-1][1])));
                dp[i][1] = dp[i-1][0] + 1;
                dp[i][2] = dp[i-1][0] + 1;
                dp[i][3] = Math.max(Math.max(dp[i-1][0],dp[i-1][1]),dp[i-1][2]) + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans = Math.max(dp[n-1][i],ans);
        }
        System.out.println(ans);

    }
}
