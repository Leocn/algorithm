package com.example.demo.atcoder.abc268;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }


        int[] pre = new int[3*n];
        for(int i = 0;i < n;i++){
            int ch = (a[i] - i + n) % n;
            pre[ch+n-1]++;
            pre[ch+n+2]--;
        }
        for(int i = 0;i < 3*n-1;i++){
            pre[i+1] += pre[i];
        }
        int max = 0;
        for(int i = 0;i < n;i++){
            max = Math.max(max, pre[i] + pre[i+n] + pre[i+2*n]);
        }
        System.out.println(max);


    }
}
