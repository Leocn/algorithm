package com.example.demo.codeforces.ecf133;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int m = sc.nextInt();
            int[] a = new int[m];
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
            int ans = Integer.MAX_VALUE;
            int[][] dp = new int[m][2];
            dp[0][0] = a[0]+1;
            dp[0][1] = b[0]>a[0]? b[0]+1:a[0]+2;



        }
    }
}
