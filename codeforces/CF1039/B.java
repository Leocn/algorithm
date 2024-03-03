package com.example.demo.codeforces.CF1039;

import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static Random gen = new SecureRandom();
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {


        long n = sc.nextLong();
        int k = sc.nextInt();
        long l = 1 , r = n;
        while (true){

            while (r - l>45){
                long m = l + r >>1;
                if(check(l, m)){
                    r = m;
                }else {
                    l = m;
                }
                l = Math.max(l-k, 1);
                r = Math.min(r+k, n);
            }
            long x = l + gen.nextInt ((int)(r-l+1));
            if(check(x,x)){
                break;
            }
            l = Math.max(l-k, 1);
            r = Math.min(r+k, n);
        }
        out.close();

    }

    private static boolean check(long l, long r){
        out.println(l + " " + r);
        out.flush();
        String res = sc.next();
        return res.equals("Yes");
    }
}
