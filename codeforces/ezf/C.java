package com.example.demo.codeforces.ezf;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if(n==1){
            System.out.println(1000000000);
            return;
        }
        int[] pre = new int[n+1];
        int[] suf = new int[n+1];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = gcd(pre[i-1], arr[i]);
        }
        suf[n-1] = arr[n-1];
        for (int i = n-2; i >=0 ; i--) {
            suf[i] = gcd(suf[i+1], arr[i]);
        }
        int ans = Math.max(pre[n-2],suf[1]);
        for (int i = 1; i < n-1; i++) {
            ans = Math.max(ans, gcd(pre[i-1], suf[i+1]));
        }
        System.out.println(ans);
    }


    public static int gcd(int x, int y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }

}
