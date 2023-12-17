package com.example.demo.atcoder.arc159;

import java.io.PrintWriter;
import java.util.*;

public class B {
    static int  c = 0;
    static Map<Long, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long a = sc.nextLong(), b = sc.nextLong();
        int cnt = 0;
        while (a>=1 && b>=1){
            long g = gcd(a,b);

            a -= g;
            b -= g;


            cnt ++;
            map.put(g, cnt);

         //   System.out.println(c);
            System.out.println(g);

        }
        out.println(cnt);
        out.close();
    }
    public static long gcd(long x, long y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }

}
