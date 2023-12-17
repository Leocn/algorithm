package com.example.demo.atcoder.abc309;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if(m-n==1 &&  (m!=1 && m!=4 && m!=7)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
}
