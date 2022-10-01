package com.example.demo.codeforces.cf813;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] re = new int[n];
            for (int i = 0; i < n; i++) {
                re[i] = sc.nextInt();
            }
            int ans = 0;
            for (int i = 0; i <k ; i++) {
                if(re[i]>k){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
