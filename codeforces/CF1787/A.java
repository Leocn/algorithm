package com.example.demo.codeforces.CF1787;

import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);

        out: while (t-->0){
            long n = sc.nextInt();
            if(n%2==0){
                out.println(1+ " "+ n/2);
                continue;
            }
            o:for (long i = 2; i <=32 ; i++) {
                for (int j = 2; j <=32 ; j++) {
                    long s = (long) ((long)j *Math.pow(i,j) + (long)i*Math.pow(j,i));
                    if(s>n){
                        continue o;
                    }
                    if(s==n){
                        out.println(i + " "+ j);
                        continue out;
                    }
                }
            }
            out.println(-1);
        }
        out.close();
    }
}
