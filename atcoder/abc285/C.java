package com.example.demo.atcoder.abc285;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        long ans = 0;
        long p = 26;
        for (int i = 0; i <= n-2; i++) {
            ans += p;
            p*=26;
        }
        p/=26;
        int st = 0;
        while (st<n){
            char c = str.charAt(st);
            ans += p*(c-'A') ;

            p /= 26;
            st++;
        }
        ans+=1;
        System.out.println(ans);
    }
}
