package com.example.demo.nowcode.N63585;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt(), y = sc.nextInt();
        for (int i = 0; i < n-1; i++) {
            if(arr[i]==x && arr[i+1]==y){
                System.out.println("Yes");
                return;
            }
            if(arr[i]==y && arr[i+1] == x){
                System.out.println("Yes");
                return;
            }

        }
        System.out.println("No");
    }
}
