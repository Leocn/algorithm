package com.example.demo.nowcode.N61571;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (k-->0){
            sb.append("you");
            n-=3;
        }
        if(n<0){
            System.out.println(-1);
            return;
        }
        while (n-->0){
            sb.append("u");
        }
        System.out.println(sb);

    }
}
