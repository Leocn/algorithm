package com.example.demo.codeforces.CF131;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), t = sc.nextInt();
        long ans = 0;
        for (int i = 4; i <= Math.min(t-1,n) ; i++) {
            long s = 1;
            for (int j = 1; j <= i; j++) {
                s*=(n-j+1);
                s/=j;
            }

            long b = 1;
            for (int j = 1; j <=(t-i) ; j++) {
                b*=m-j+1;
                b/=j;
            }


            ans += s*b;
        }
        System.out.println(ans);
    }
}
