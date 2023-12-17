package com.example.demo.atcoder.abc297;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long ans = 0;
        while (a!=b){

            if(a>b){
                if(a%b!=0){
                    ans += a/b;
                    a = a%b;
                }else {
                    ans += a/b -1;
                    break;
                }

            }else {
                if(b%a!=0){
                    ans+= b/a;
                    b = b%a;
                }else {
                    ans+= b/a - 1;
                    break;
                }

            }

        }
        System.out.println(ans);

    }
}
