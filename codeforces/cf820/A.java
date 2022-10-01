package com.example.demo.codeforces.cf820;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            var a = sc.nextInt();
            var b = sc.nextInt();
            var c = sc.nextInt();
            var h = a-1;
            var s = Math.abs(b-c) + c-1;
            if(h<s){
                System.out.println("1");
            }else if(s<h){
                System.out.println("2");
            }else {
                System.out.println("3");
            }
        }
    }
}
