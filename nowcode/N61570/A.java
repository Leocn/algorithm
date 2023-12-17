package com.example.demo.nowcode.N61570;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        long tar = 10L *x;
        long l = tar%7;
        System.out.println(tar + 7-l);
    }
}
