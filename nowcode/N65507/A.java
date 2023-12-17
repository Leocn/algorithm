package com.example.demo.nowcode.N65507;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int tem = arr[i][j];
                arr[i][j] = arr[n-i-1][j];
                arr[n-i-1][j] = tem;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int tem = arr[i][j];
                arr[i][j] = arr[i][n-j-1];
                arr[i][n-j-1] = tem;
            }
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");

            }
            System.out.println(sb);
        }

    }
}
