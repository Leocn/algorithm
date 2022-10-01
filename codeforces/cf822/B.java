package com.example.demo.codeforces.cf822;

import java.io.PrintWriter;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    if(j==0|| j==i-1){
                        sb.append(1).append(" ");
                    }else {
                        sb.append(0).append(" ");
                    }
                }
                out.println(sb);
            }
        }
        out.close();
    }
}
