package com.example.demo.nowcode.N62912;

import java.math.BigInteger;
import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        BigInteger c = new BigInteger(sc.next());

        if(a.compareTo(b)<=0){
            System.out.println(1);

        }else {
           if(b.compareTo(c)<=0){
               System.out.println(-1);
           }else {
               BigInteger d = a.subtract(b);
               b = b.subtract(c);
               BigInteger ans = d.divide(b);
               BigInteger left = d.remainder(b);
               if(left.compareTo(new BigInteger("0"))==0){
                   System.out.println(ans.add(new BigInteger("1")).toString());
               }else {
                   System.out.println(ans.add(new BigInteger("2")).toString());
               }
           }
        }
    }
}
