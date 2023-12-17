package com.example.demo.atcoder.abc295;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            if(arr[i].equals("and") || arr[i].equals("not")|| arr[i].equals("that")|| arr[i].equals("the")|| arr[i].equals("you")){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
