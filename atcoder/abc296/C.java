package com.example.demo.atcoder.abc296;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        Set<Integer> set1= new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            set1.add(a-d);
            set2.add(a+d);
            if(set1.contains(a) || set2.contains(a)){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");

    }
}
