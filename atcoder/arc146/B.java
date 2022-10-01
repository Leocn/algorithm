package com.example.demo.atcoder.arc146;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextInt();
        long k = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        long[][] dp = new long[n][32];
        int[] sum = new int[n];
        for (int i = 0; i <n ; i++) {
            long c = 0;
            for (int j = 0; j <32 ; j++) {
                if((arr[i]& (1<<j)) == 0 ){
                    c += (1<<j);
                    dp[i][j] = c;
                }

            }
        }
        long mBit = 1;
        int count = 0;
        while(m/mBit+ sum[count]>k){
            mBit *= 2;
            count++;
        }
        System.out.println(mBit);




    }
}
