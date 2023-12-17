package com.example.demo.atcoder.abc311;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] cs = sc.next().toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(cs[i]);
            if(set.size()==3){
                System.out.println(i+1);
                return;
            }
        }
    }
}

