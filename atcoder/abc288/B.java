package com.example.demo.atcoder.abc288;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        String[] ans = new String[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        Arrays.sort(ans);
        for (int i = 0; i < k; i++) {
            System.out.println(ans[i]);
        }
    }
}
