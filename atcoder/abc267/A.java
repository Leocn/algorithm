package com.example.demo.atcoder.abc267;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        if(s.startsWith("Monday")){
            System.out.println(5);
        }
        if(s.startsWith("Tuesday")){
            System.out.println(4);
        }
        if(s.startsWith("Wednesday")){
            System.out.println(3);
        }
        if(s.startsWith("Thursday")){
            System.out.println(2);
        }
        if(s.startsWith("Friday")){
            System.out.println(1);
        }
    }
}
