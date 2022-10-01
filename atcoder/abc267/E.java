package com.example.demo.atcoder.abc267;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long ans = 0;
        long[] arr = new long[n+1];
        for (int i = 1; i <=n ; i++) {
            arr[i] = sc.nextInt();
        }
        long[] sum = new long[n+1];
        for (int i = 0; i <m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            sum[from] += arr[to];
            sum[to] += arr[from];
        }

    }
}
