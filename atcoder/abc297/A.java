package com.example.demo.atcoder.abc297;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            if(arr[i+1]-arr[i]<=k){
                System.out.println(arr[i+1]);
                return;
            }
        }
        System.out.println(-1);
    }
}
