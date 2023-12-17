package com.example.demo.codeforces.CF1787;

import java.io.PrintWriter;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);

        while (t-->0){
           int n = sc.nextInt();
           int s = sc.nextInt();
           long[] A = new long[n+1];
           long[] B = new long[n+1];
           for (int i = 1; i <= n; i++) {
               long c = sc.nextInt();
                if(i==1 || i==n){
                    A[i] = c;
                    B[i] = c;
                }else if(c<s){
                    A[i] = c;
                }else {
                    A[i] = s;
                    B[i] = c-s;
                }
           }
            long[][] dp = new long[n+1][2];
            for(int i=2; i<=n; i++) {
                dp[i][0]=Math.min(dp[i-1][0]+B[i-1]*A[i],dp[i-1][1]+A[i-1]*A[i]);
                dp[i][1]=Math.min(dp[i-1][0]+B[i-1]*B[i],dp[i-1][1]+A[i-1]*B[i]);
            }
            out.println(dp[n][0]);

            
        }
        out.close();
    }
}
