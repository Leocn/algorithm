package com.example.demo.codeforces.CF1802;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[][] arr = new long[n][m];
            for (int i = 0; i < arr.length; i += 2) {
                long num = (1l << 30) * (i + 1);
                for (int j = 0; j < arr[0].length; j += 2) {
                    for (int j2 = 0; j2 < 2; j2++) {
                        for (int k = 0; k < 2; k++) {
                            if (i + j2 < arr.length && j + k < arr[0].length)
                                arr[i + j2][j + k] = num;
                            num++;
                        }
                    }
                }
            }
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < m-1; j++) {
                    out.println(arr[i][j]^arr[i+1][j] ^ arr[i+1][j+1] ^arr[i][j+1]);
                }
            }
            out.println(n * m);
            out.println(Arrays.deepToString(arr));
        }
        out.close();
    }
}
