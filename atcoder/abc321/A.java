package com.example.demo.atcoder.abc321;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = -1;
        while (n>0){
            int a = n%10;
            if(a<=s){
                System.out.println("No");
                return;
            }
            s = a;
            n/=10;
        }
        System.out.println("Yes");
    }
}
