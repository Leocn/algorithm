package com.example.demo.atcoder.abc293;


import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] cs = str.toCharArray();
        int n = str.length();
        for (int i = 0; i < n; i+=2) {
            char c = cs[i];
            cs[i] = cs[i+1];
            cs[i+1] = c;
        }
        System.out.println(new String(cs));

    }
}
