package com.example.demo.atcoder.abc284;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        for (int i = n-1; i >=0; i--) {
            System.out.println(arr[i]);
        }
    }
}
