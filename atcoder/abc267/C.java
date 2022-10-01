package com.example.demo.atcoder.abc267;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <=n; i++) {
            arr[i] = sc.nextInt();
        }

        long[] sum = new long[n+1];
        for (int i = 1; i <=n ; i++) {
            sum[i] = sum[i-1]+arr[i];
        }
        long ans = Long.MIN_VALUE;

        long all =0;
        for (int i = 1; i <= m; i++) {
            all +=(long) (i)* arr[i];
            ans = all;
        }


        for (int i = m+1; i <=n ; i++) {
            all -= (sum[i-1]- sum[i-m-1]);
            all += (long) m * arr[i];
            ans = Math.max(all, ans);
        }
        System.out.println(ans);




    }
}
