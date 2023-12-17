package com.example.demo.nowcode.N65157;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println(new BigDecimal("3.1415926535897932384626433").multiply(new BigDecimal(Math.pow(a+b,2))).setScale(10, RoundingMode.HALF_UP).toString());
    }
}
