package com.example.demo.codeforces.cf821;

import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            long ans = 0;
            for (int i = 0; i <k ; i++) {
                long max = 0;
                for (int j = i; j <n ; j+=k) {
                    max = Math.max(arr[j], max);
                }
                ans += max;
            }
            out.println(ans);
        }
        out.close();
    }
}
