package com.example.demo.atcoder.abc266;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        long n = Long.parseLong(s);
        //(n - x)%(998244353) ==0
        if(n==0 || Math.abs(n)%998244353 ==0 ) {
            System.out.println(0);
            return;
        }
        if(n>0){
            System.out.println(n%998244353);
            return;
        }
        System.out.println(998244353 - (-n%998244353));


    }
}
