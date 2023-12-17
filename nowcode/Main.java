package com.example.demo.nowcode;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author Leon
 * @Date 2023/2/24
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n =sc.nextInt();
            int arr[] = new int[n];
            int arrB[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arrB[i] = sc.nextInt();
            }
            double dp[] = new double[n+1];
            dp[n] = Integer.MAX_VALUE;
            for (int i = n-1; i >=0; i--) {
                int max = Math.max(arr[i], arrB[i]);
                int min = Math.min(arr[i], arrB[i]);
                if(min>=dp[i+1]){
                    dp[i] = dp[i+1];
                }else if(max<=dp[i+1]){
                    dp[i] = (double) (arr[i]+ arrB[i])/2;
                }else {
                    dp[i] = (dp[i+1] + min)/2;
                }
            }
            System.out.println(dp[0]);
        }
    }
}