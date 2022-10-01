package com.example.demo.atcoder.abc262;

import java.util.Scanner;

public class ABC262D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] s = new int[n+1];
        for (int i = 1; i <= n; i++) {
            s[i] = scanner.nextInt();
        }
        int[][] re = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for (int j = 1; j <=n ; j++) {
                re[i][j] = s[j]%i;
            }
        }
        long ans =0;



    }

}
