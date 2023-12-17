package com.example.demo.codeforces.CF1778;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int sum =0 , d = -3;
            for (int i = 0; i < n; i++) {
                sum +=arr[i];
                if(i!=n-1){
                    d = Math.max(-arr[i] - arr[i+1], d);
                }
            }
            System.out.println(sum + 2*d);
        }
    }

}
