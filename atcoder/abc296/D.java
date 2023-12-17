package com.example.demo.atcoder.abc296;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), m = sc.nextLong();
        if(n<1e7 && n*n<m){
            System.out.println(-1);
            return;
        }
        if(m<=n){
            System.out.println(m);
            return;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 1; i <= Math.min(1e7,n); i++) {

            long d = m/i;
            if(m%i!=0){
                d++;
            }
            if(d>n){
                continue;
            }
            ans = Math.min(d* i, ans );
        }
        if(ans==Long.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(ans);
        }


    }
}
