package com.example.demo.codeforces.CF698;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr  = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[3];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] next = new int[3];
            next[0] = Math.min(dp[0], Math.min(dp[1], dp[2]))+1;
            if(arr[i] == 1 || arr[i]==3){
                next[2] = Math.min(dp[0], dp[1]);
            }else {
                next[2] = Integer.MAX_VALUE;
            }
            if(arr[i]==2 || arr[i] == 3){
                next[1] = Math.min(dp[0], dp[2]);
            }else {
                next[1] = Integer.MAX_VALUE;
            }

            dp = next;
        }

        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);

    }

}
