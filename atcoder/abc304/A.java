package com.example.demo.atcoder.abc304;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        String[] arr = new String[n];
        int[] a = new int[n];
        int loc = 0, min  = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
            a[i] = sc.nextInt();
            if(min>a[i]){
                loc = i;
                min = a[i];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[(i+loc)%n]);
        }
    }
}
