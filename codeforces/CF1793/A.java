package com.example.demo.codeforces.CF1793;

import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-->0){
            long a = sc.nextInt();
            long b = sc.nextInt();
            long n = sc.nextInt();
            long m = sc.nextInt();

            long ans = (n/(m+1) *m + (n%(m+1)))*a;
            ans = Math.min((n*b),ans);
            ans = Math.min(n/(m+1) *m*a+ n%(m+1)*b,ans);
            out.println(ans);
        }
        out.close();
    }
}
