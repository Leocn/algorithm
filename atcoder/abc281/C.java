package com.example.demo.atcoder.abc281;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long t = sc.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextLong();
        }
        long[] sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + arr[i];
        }
        t %= sum[n];
        for (int i = 0; i < n; i++) {
            if(t>=sum[i] && t<sum[i+1]){
                System.out.println((i+1) + " " + (t-sum[i]));

            }
        }



    }
}
