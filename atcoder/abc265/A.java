package com.example.demo.atcoder.abc265;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();

        long ans =  Math.min((long) n / 3 * y + (long) n % 3 * x, (long) n *x);
        System.out.println( ans);

    }
}
