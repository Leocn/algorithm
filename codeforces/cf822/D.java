package com.example.demo.codeforces.cf822;

import java.io.PrintWriter;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; i++) {
                arr[i + 1] = sc.nextInt();
            }

            if (k == 1 || k == n) {
                out.println("YES");
                continue;
            }
            long[] sum = new long[n + 1];
            for (int i = k - 1; i > 0; i--) {
                sum[i] = sum[i + 1] + arr[i];
            }
            for (int i = k + 1; i <= n; i++) {
                sum[i] = sum[i - 1] + arr[i];
            }
            int left = k - 1;
            int right = k + 1;
            long leftM = 0;
            long rightM = 0;

            while (true) {
                while (left > 0 && arr[k] + rightM + sum[left] >= 0) {
                    leftM = Math.max(leftM, sum[left]);
                    left--;

                }
                if (left == 0) {
                    break;
                }
                while (right < n+1 && arr[k] + sum[right] + leftM >= 0) {
                    rightM = Math.max(rightM, sum[right]);
                    right++;

                }
                if (right == n+1) {
                    break;
                }
                if (arr[k] + sum[right] + leftM < 0 && arr[k] + rightM + sum[left] < 0) {
                    break;
                }
            }


            if (left == 0 || right == n+1) {
                out.println("YES");
            } else {
               out.println("NO");
            }

        }
        out.close();

    }

}
