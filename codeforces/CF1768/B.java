package com.example.demo.codeforces.CF1768;

import java.io.PrintWriter;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        while (t-->0){
            int n = sc.nextInt(),  k = sc.nextInt();
            int f = 1;
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                if(s==f){
                    f++;
                }
            }
            out.println((n-f+1)/k + ((n-f+1)%k==0?0:1));
        }
        out.close();
    }
}
