package com.example.demo.atcoder.abc290;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int[] arr  = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i+1] = sc.nextInt();
        }
        long ans = 0;
        while (m-->0){
            ans += arr[sc.nextInt()];
        }
        System.out.println(ans);

    }
}
