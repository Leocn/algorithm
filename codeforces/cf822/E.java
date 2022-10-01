package com.example.demo.codeforces.cf822;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * */
public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            ans[i][i] = arr[i];
            for (int j = i-1; j >=0; j--) {
                ans[i][j] = (ans[i][j+1]-i+n)%n;
            }
            for (int j = i+1; j <n ; j++) {
                ans[i][j] = (ans[i][j-1]+i)%n;
            }
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb  = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append( ans[i][j]).append(" ");
            }
            out.println(sb);
        }

        out.close();
    }
}
