package com.example.demo.nowcode.N55352;

import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        long[][] arr = new long[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = (long) a[i] *b[j];
            }
        }
        long[][] sum = new long[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                sum[i][j] = arr[i-1][j-1] +sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        int q = sc.nextInt();
        while (q-->0){
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
            long ans = sum[x2][y2] -sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
            System.out.println(ans);
        }

    }
}
