package com.example.demo.codeforces.tfr8;

import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        while (t-->0){
            long n = sc.nextLong();
            if(n%3==0){
                out.println("Urvik");
            }else {
                out.println("Dhruv");
            }
        }
        out.close();
    }
}
