package com.example.demo.atcoder.abc283;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        while (q-->0){
            int tag = sc.nextInt();
            if(tag==1){
                int k = sc.nextInt();
                int x= sc.nextInt();
                arr[k-1] = x;

            }else{
                int k = sc.nextInt();
                System.out.println(arr[k-1]);
            }
        }

    }
}
