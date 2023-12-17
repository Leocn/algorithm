package com.example.demo.nowcode.N65259;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), k = sc.nextLong();
        int q = sc.nextInt();
        a = a%2;
        k = k%2;
        while(q-->0){
            long from = sc.nextLong(), to = sc.nextLong();
            from = (from-1)%2;
            to = (to-1)%2;

            long f = a+k*from, t = a+k*to;
            if(f%2==1 && t%2==1){
                System.out.println(1);
            }else if(f%2==0 && t%2==0){
                System.out.println(-1);
            }else {
                System.out.println(0);
            }

        }
    }
}
