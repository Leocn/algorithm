package com.example.demo.atcoder.arc145;

import java.util.Scanner;

public class ARC145C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long ans = 0;
        while(n>0){
            ans += (2*n  /2 *(2*n-1))% 998244353;
            n--;
        }
        ans = ans*2% 998244353;
        System.out.println(ans);

    }
}
