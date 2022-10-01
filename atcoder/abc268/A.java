package com.example.demo.atcoder.abc268;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set.add(sc.nextInt());
        }
        System.out.println(set.size());
    }
}
