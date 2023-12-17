package com.example.demo.atcoder.abc280;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        long[] ans = new long[n];
        ans[0] = arr[0];
        for (int i = 1; i <n ; i++) {
            ans[i] = arr[i] - arr[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);

    }
}
