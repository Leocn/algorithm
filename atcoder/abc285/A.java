package com.example.demo.atcoder.abc285;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a  = sc.nextInt();
        int b = sc.nextInt();
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if(max == 2*min || max == 2*min+1){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
