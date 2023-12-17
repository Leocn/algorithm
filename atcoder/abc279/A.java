package com.example.demo.atcoder.abc279;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] cs = str.toCharArray();
        int ans = 0;
        for(char c: cs){
            if(c=='v'){
                ans++;
            }else{
                ans+=2;
            }
        }
        System.out.println(ans);
    }
}
