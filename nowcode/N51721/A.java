package com.example.demo.nowcode.N51721;

import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-->0){
            long n = sc.nextInt();
            if(n==1 || n==2 || n==3){
                out.println(n);
                continue;
            }
            out.println(2+ (n%2));
        }
        out.close();
    }
}
