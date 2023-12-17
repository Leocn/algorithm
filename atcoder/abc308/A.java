package com.example.demo.atcoder.abc308;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 8;
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
            if(arr[i]%25!=0 || arr[i]<100 || arr[i]>675) {
                System.out.println("No");
                return;
            }
            if(i>0 && arr[i]<arr[i-1]){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");

    }
}
