package com.example.demo.atcoder.abc301;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] cs = sc.next().toCharArray();
        int ans = 0;
        for (int i = 0; i < cs.length ; i++) {
            ans += (cs[i]=='T'?1:-1);
        }
        if(ans>0 || (ans==0 && cs[cs.length-1]=='A')){
            System.out.println("T");
        }else {
            System.out.println("A");
        }
    }
}
