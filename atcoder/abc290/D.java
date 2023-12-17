package com.example.demo.atcoder.abc290;

import java.io.PrintWriter;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-->0){
            long n = sc.nextInt();
            long d = sc.nextInt();
            long k = sc.nextInt();
            if(gcd(n,d)==1){
                out.println((d%n)*(k-1)%n);
                continue;
            }
            if(d%n==0){
                out.println(k-1);
                continue;
            }
            d %=n;
            long g = gcd(d,n);
            long r = n/g;
            long cnt = (k-1)/r;
            out.println(cnt + d*((k-1)%r)%n);


        }
        out.close();
    }
    public static long gcd(long x, long y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }

}
