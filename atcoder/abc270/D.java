package com.example.demo.atcoder.abc270;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];


        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                if (i - arr[j] < 0) {
                    continue;
                }
                dp[i]=Math.max(dp[i],i-dp[i-arr[j]]);
            }

        }


        System.out.println(dp[n]);
    }
}
