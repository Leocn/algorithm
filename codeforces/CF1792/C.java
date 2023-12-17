package com.example.demo.codeforces.CF1792;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n+1];
            for (int i = 0; i < n; i++) {
                arr[sc.nextInt()] = i;
            }
            int l = (n + 1) / 2, r = (n + 2) / 2;
            while (l > 0 && (l == r || (arr[l] < arr[l + 1] && arr[r - 1] < arr[r]))) {
                --l;
                ++r;
            }
            System.out.println(l);
        }
    }
}
