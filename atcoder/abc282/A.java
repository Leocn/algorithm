package com.example.demo.atcoder.abc282;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        char c = 'A';
        StringBuilder sb = new StringBuilder();
        while (c-'A'<t){
            sb.append(c);
            c++;
        }
        System.out.println(sb);
    }
}
