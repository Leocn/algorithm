package com.example.demo.nowcode.N65507;

import java.math.BigInteger;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mod = (int)1e9+7;
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            if(a<x || b>y){
                continue;
            }
            cnt++;
        }
        BigInteger b = new BigInteger("2").modPow(BigInteger.valueOf(cnt), BigInteger.valueOf(mod));
        System.out.println((b.intValue()-1+ mod)%mod);
        
    }
}
