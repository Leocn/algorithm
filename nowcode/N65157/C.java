package com.example.demo.nowcode.N65157;

import java.util.Scanner;
import java.util.TreeSet;

public class C {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        long a = sc.nextInt(), b = sc.nextInt();
        TreeSet<Long> set = new TreeSet<>();
        set.add(a);
        set.add(b);
        for (int i = 0; i < k-1; i++) {
            long f = set.pollFirst();
            set.add(f+a);
            set.add(f+b);
        }
        System.out.println(set.pollFirst());

    }
}
