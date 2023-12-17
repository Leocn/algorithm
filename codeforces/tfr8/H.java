package com.example.demo.codeforces.tfr8;

import java.io.PrintWriter;
import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-->0){
            long p = sc.nextInt(), q = sc.nextInt(), x = sc.nextInt(), y= sc.nextInt();
            long a = p*x - q*y;
            long b = q-p;
            if(q==p){
                if(x!=y){
                    out.println(-1);
                }else {
                    out.println(0);
                }
                continue;
            }
            if(a%b==0 && a/b>=0){
                out.println(a/b);
            }else {
                out.println(-1);
            }


        }
        out.close();
    }

}
