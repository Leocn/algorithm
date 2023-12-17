package com.example.demo.atcoder.abc302;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong();
        System.out.println(a/b + (a%b==0?0:1));
    }
}
