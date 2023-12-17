package com.example.demo.atcoder.abc296;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] cs = str.toCharArray();
        for (int i = 0; i < n-1; i++) {
            if(cs[i]==cs[i+1]){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
