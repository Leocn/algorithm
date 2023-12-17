package com.example.demo.atcoder.abc304;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<1000){
            n = n;
        }else if(n<10000){
            n/=10;
            n*=10;
        }else if(n<100000){
            n/=100;
            n*=100;
        }else if(n<1000000){
            n/=1000;
            n*=1000;
        }else if(n<10000000){
            n/=10000;
            n*=10000;
        }else if(n<100000000){
            n/=100000;
            n*=100000;
        }else if(n<1000000000){
            n/=1000000;
            n*=1000000;
        }
        System.out.println(n);
    }
}
