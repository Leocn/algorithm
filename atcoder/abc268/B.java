package com.example.demo.atcoder.abc268;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        String ss = sc.next();
        if(ss.startsWith(s)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
