package com.example.demo.atcoder.abc300;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), a= sc.nextInt(), b= sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();

        }
        for (int i = 0; i < n; i++) {
            if(arr[i]== a +b){
                System.out.println(i+1);
            }
        }
    }
}
