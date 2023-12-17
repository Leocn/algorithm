package com.example.demo.codeforces.CF1795;

import java.io.PrintWriter;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            boolean flag1 = false;
            boolean flag2 = false;
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                int a = arr[i][0];
                int b =arr[i][1];
//                if(a==b && a==k){
//                    out.println("YES");
//                    continue out;
//                }
                if(a==k){
                    flag1 = true;
                }
                if(b==k){
                    flag2 = true;
                }
            }
            if(flag1&& flag2){
                out.println("YES");
            }else {
                out.println("NO");
            }
        }
        out.close();
    }
}
