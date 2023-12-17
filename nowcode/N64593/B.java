package com.example.demo.nowcode.N64593;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-->0){
            int n = sc.nextInt(), k = sc.nextInt();
            int[] arr  =  new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < k; i++) {
                int a = sc.nextInt()-1, b = sc.nextInt()-1;
                arr[a] ++;
                arr[b] --;
            }
            boolean f = false;
            for (int i = 0; i < n-1; i++) {
                if(arr[i]>arr[i+1]){
                    f = true;
                }
            }
            if(f){
                System.out.println("No");
            }else {
                System.out.println("Yes");
            }
        }
    }
}
