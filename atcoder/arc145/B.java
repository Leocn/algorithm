package com.example.demo.atcoder.arc145;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        if(n<a){
            System.out.println(0);
            return;
        }
        if(b>=a){
            System.out.println(n-a+1);
            return;
        }
        long  ans = 0;
        long d = n / a;
        long l = n % a;
        ans = (d-1)* b + Math.min(l+1, b);
        System.out.println(ans);



    }
}
