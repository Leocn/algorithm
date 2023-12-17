package com.example.demo.codeforces.CF1788;

import java.io.PrintWriter;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int a = 0, b = 0;
            int sumA = 0, sumB = 0;
            int tag = 1;
            while (n>=1){
                int l = n%10;
                int aP = 0, bP = 0;
                if(l%2==0 ) {
                    aP = l / 2;
                    bP = l / 2;
                }else {
                    if(sumA>=sumB){
                        aP = l/2;
                        bP = l/2+1;
                    }else {
                        aP = l/2+1;
                        bP = l/2;
                    }
                }
                sumA+= aP;
                sumB += bP;
                a += tag*aP;
                b += tag*bP;


                n/=10;
                tag*=10;
            }
            out.println(a +" " + b);

        }
        out.close();
    }
}
