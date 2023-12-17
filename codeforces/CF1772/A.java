package com.example.demo.codeforces.CF1772;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int ans = Integer.parseInt(s.split("\\+")[0]) + Integer.parseInt(s.split("\\+")[1]);
            System.out.println(ans);
        }
    }
}
