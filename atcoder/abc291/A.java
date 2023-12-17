package com.example.demo.atcoder.abc291;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str = sc.next();
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if(Character.isUpperCase(cs[i])){
                System.out.println(i+1);
            }
        }
    }
}
