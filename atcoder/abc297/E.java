package com.example.demo.atcoder.abc297;

import java.util.Scanner;
import java.util.TreeSet;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        TreeSet<Long> dq = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            dq.add((long)arr[i]);
        }
        long ans = 0;
        while (k-->0){
            ans = dq.pollFirst();
            for (int i = 0; i < n; i++) {
                dq.add(ans+arr[i]);
            }
        }
        System.out.println(ans);
    }
}
