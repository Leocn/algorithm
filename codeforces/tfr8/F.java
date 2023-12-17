package com.example.demo.codeforces.tfr8;

import java.io.PrintWriter;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-->0){
            long n = sc.nextLong();
            long ans = n*6, k = 3;
            out.println(ans + " " + k);
            out.println(n + " " + n*2 + " " + n*3);

        }
        out.close();
    }

}
