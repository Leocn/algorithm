package com.example.demo.codeforces.CF1726;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <n ; i++) {
                arr[i] = sc.nextInt();
                max = Math.max(arr[i], max);
                min = Math.min(arr[i], min);
            }
            int ans = arr[n-1] - arr[0];
            for (int i = 0; i < n-1; i++) {
                ans = Math.max(ans, arr[i]- arr[i+1]);
            }
            ans = Math.max(arr[n-1]-min, ans);
            ans = Math.max(max- arr[0], ans);
            System.out.println(ans);
        }
    }
}
