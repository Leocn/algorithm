package com.example.demo.nowcode.N55352;

import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x= sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i]  = sc.nextInt();
        }
        int loc = 0;
        long s = 1;
        int ans = n+1;
        for (int i = 0; i < n; i++) {
            s *= arr[i];
            while (loc<=s && s>=x){
                ans = Math.min(ans, i-loc+1);
                s/=arr[loc];
                loc++;
            }
        }
        System.out.println(ans == n+1?-1:ans);
    }
}
