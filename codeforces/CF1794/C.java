package com.example.demo.codeforces.CF1794;

import java.io.PrintWriter;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[] ans = new int[n];
            int loc = 0;
            for (int i = 0; i < n; i++) {
                while (i-loc+1> arr[loc]){
                    loc++;
                }
                ans[i] = i-loc+1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(" ");
            }
            out.println(sb);

        }
        out.close();

    }

}
