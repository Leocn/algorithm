package com.example.demo.nowcode.N64272;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        int now = 0;
        for (int i = 0; i < n; i++) {
            if(i+1<n && Math.abs(arr[i]-arr[i+1])<=1){
                if(now ==0){
                    now = 2;
                }else {
                    now++;
                }
            }else {
                now = 0;
            }
            ans = Math.max(now ,ans);
        }
        System.out.println(ans);
    }
}
