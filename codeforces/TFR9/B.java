package com.example.demo.codeforces.TFR9;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] cs = sc.next().toCharArray();
        long ans = 1;
        long m = (long) 1e9+7;
        for(char c: cs){
            ans = ans*(c-'a'+1)%m;
        }
        System.out.println(ans);
    }
}
